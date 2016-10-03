/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.mysql;

import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.hibernate.configuracion.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dios salva
 */
public class UsuarioDAOImp implements IUsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("password", password));
        criteria.add(Restrictions.eq("estado", true));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }

    @Override
    public void modificar(Usuario unUsuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(unUsuario);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }
    
}
