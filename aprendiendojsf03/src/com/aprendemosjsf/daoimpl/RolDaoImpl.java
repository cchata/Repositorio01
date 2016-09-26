/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.daoimpl;

import java.io.Serializable;
import java.util.List;

import com.aprendemosjsf.dao.RolDao;
import com.aprendemosjsf.model.Rol;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aprendemosjsf.util.HibernateUtil;

public class RolDaoImpl implements RolDao, Serializable{

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	    public List<Rol> selectItems() {
	        List<Rol> listado = null;
	        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
	        Transaction tx = null;
	        String sql = "FROM Rol";
	        try {
	        	tx = sesion.getTransaction();
	        	tx.begin();
	            listado =  sesion.createQuery(sql).list();
	            tx.begin();
	        } catch (Exception e) {
	            tx.rollback();
	        }
	        return listado;
	    }
}
