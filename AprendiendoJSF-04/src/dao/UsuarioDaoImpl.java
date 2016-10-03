/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;

import model.Usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 *
 * @author lude
 */
public class UsuarioDaoImpl implements UsuarioDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
    public Usuario findByUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Usuario WHERE usuario = '"+usuario.getUsuario()+"'";
        Transaction tx = sesion.getTransaction();
        try {
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
    	System.out.println("Llamando lista usuario 2");
        List<Usuario> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.getTransaction();
        String sql = "FROM Usuario u left join fetch u.rol";
        try {
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
        Transaction tx = sesion.getTransaction();
        try {
        	tx.begin();
        	sesion.save(usuario);
            tx.commit();
            
            flag = true;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            flag = false;
            tx.rollback();
        }
        return flag;
    }

    @Override
    public boolean update(Usuario usuario) {
    	System.out.println("usuario.getId()     = "+usuario.getId());
    	System.out.println("usuario.getUsuario()= "+usuario.getUsuario());
    	System.out.println("usuario.getEmail()  = "+usuario.getEmail());
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.getTransaction();
        try {
        	
        	tx.begin();
            Usuario usuariodb = (Usuario) sesion.load(Usuario.class, usuario.getId());
            usuariodb.setEmail(usuario.getEmail());
            usuariodb.setUsuario(usuario.getUsuario());
            usuariodb.setRol(usuario.getRol());
            usuariodb.setEstado(usuario.getEstado());
            usuariodb.setUsuariomodificacion(usuario.getUsuariomodificacion());
            usuariodb.setFechamodificacion(new java.util.Date());
            sesion.update(usuariodb);
            tx.commit();
            flag = true;
        } catch (Exception e) {
        	System.out.println(e.getMessage());
            flag = false;
            tx.rollback();
        }
        
        System.out.println("flag = "+flag);
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.getTransaction();
        try {
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