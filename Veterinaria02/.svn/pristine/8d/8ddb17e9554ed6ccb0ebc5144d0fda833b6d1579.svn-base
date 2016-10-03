/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.mysql;

import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.hibernate.configuracion.HibernateUtil;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dios salva
 */
public class PropietarioDAOImp implements IPropietarioDAO{

	private SessionFactory sesssionFactory = HibernateUtil.getSessionFactory();
	
    @Override
    public void crear(Propietario propietario) {
    	try {

    		System.out.println("------crear-----");
    		System.out.println(propietario.getApellido());
    		System.out.println(propietario.getDireccion());
    		System.out.println(propietario.getDni());
    		System.out.println(propietario.getNombres());
    		System.out.println(propietario.getTelefono());
    		System.out.println(propietario.getFechaNacimiento());
    		
    		sesssionFactory.getCurrentSession().getTransaction().begin();
    		
    		sesssionFactory.getCurrentSession().save(propietario);
    		sesssionFactory.getCurrentSession().getTransaction().commit();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println(e.getCause());
    		sesssionFactory.getCurrentSession().getTransaction().rollback();
			// TODO: handle exception
		}
    }

    @Override
    public void modificar(Propietario propietario) {
    	
    	try {

    		
    		sesssionFactory.getCurrentSession().getTransaction().begin();
    		
    		sesssionFactory.getCurrentSession().update(propietario);
    		sesssionFactory.getCurrentSession().getTransaction().commit();
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    		System.out.println(e.getCause());
    		sesssionFactory.getCurrentSession().getTransaction().rollback();
			// TODO: handle exception
		}    	
    }

    @Override
    public List<Propietario> obtenerTodos() {
    	List propietarios = null;
    	try {
	
    	    Session session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Propietario.class);
            criteria.add(Restrictions.eq("estado", true));
            criteria.addOrder(Order.asc("apellido"));
            propietarios = criteria.list();
            System.out.println("propietarios.size()::::::"+propietarios.size());
            
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
    	
    
        return propietarios;
    }
    
}
