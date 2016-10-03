/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

import model.Rol;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class RolDaoImpl implements RolDao{

    @Override
    public List<Rol> selectItems() {
        List<Rol> listado = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = sesion.getTransaction();
        String sql = "FROM Rol";
        try {
            tx.begin();
            listado =  sesion.createQuery(sql).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return listado;
    }
}
