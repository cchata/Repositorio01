/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.daoimpl;

import java.io.Serializable;
import java.util.List;

import com.aprendemosjsf.dao.UsuarioDao;
import com.aprendemosjsf.model.Usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aprendemosjsf.util.HibernateUtil;

public class UsuarioDaoImpl implements UsuarioDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        String sql = "FROM Usuario WHERE usuario = '"+usuario.getUsuario()+"'";
        try {
            tx = sesion.getTransaction();
            tx.begin();
            model = (Usuario) sesion.createQuery(sql).uniqueResult();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return model;
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario model = this.findByUsuario(usuario);
        if (model != null) {
            if (!usuario.getClave().equals(model.getClave())) {
                model = null;
            }
        }
        return model;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        String sql = "FROM Usuario u left join fetch u.rol";
        try {
        	tx = sesion.getTransaction();
        	tx.begin();
            listado =  sesion.createQuery(sql).list();
            tx.commit();
        } catch (Exception e) {
        	 tx.rollback();
        }
        return listado;
    }

    @Override
    public boolean create(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
        	tx = sesion.getTransaction();
        	tx.begin();
            sesion.save(usuario);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
        	tx = sesion.getTransaction();
        	tx.begin();
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getId());
            usuariodb.setEmail(usuario.getEmail());
            usuariodb.setUsuario(usuario.getUsuario());
            usuariodb.setRol(usuario.getRol());
            sesion.update(usuariodb);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = null;
        try {
        	tx = sesion.getTransaction();
        	tx.begin();
            Usuario usuario = (Usuario) sesion.load(Usuario.class, id);
            sesion.delete(usuario);
            tx.commit();
            flag = true;
        } catch (Exception e) {
            flag = false;
            tx.rollback();
        }
        return flag;
    }
}