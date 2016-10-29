package com.ecoinnova.pe.dao.hibernate.impl;

// default package
// Generated 04-oct-2016 16:13:59 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.List;





import javax.persistence.ParameterMode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbEmpleadoDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbEmpleadoEntity;

/**
 * Home object for domain model class TbCargo.
 * @see .TbCargo
 * @author Hibernate Tools
 */
@Repository("tbEmpleadoDao")
public class TbEmpleadoDaoImpl extends GenericEntityDaoImpl<TbEmpleadoEntity, Serializable> implements TbEmpleadoDao, Serializable{

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(TbEmpleadoDaoImpl.class);

//	private final SessionFactory sessionFactory = getSessionFactory();

	@Override
	public void insertEmpleado(TbEmpleadoEntity transientInstance)throws Exception{
		log.debug("persisting TbEmpleadoEntity instance");
		Session sesion = getSessionFactory().getCurrentSession();
		Transaction tx = sesion.getTransaction();
		try {
			tx.begin();
			sesion.save(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (Exception re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void deleteEmpleado(TbEmpleadoEntity persistentInstance)throws Exception {
		log.debug("deleting TbEmpleadoEntity instance");
		try {
			Session sesion = getSessionFactory().getCurrentSession();
//			sesion.getTransaction().begin();
			sesion.beginTransaction();
			System.out.println("Codigo empleado = "+persistentInstance.getCodigoEmp());
			sesion.delete(persistentInstance);
//			sesion.getTransaction().commit();
			sesion.getTransaction().commit();
			log.debug("delete successful");
		} catch (Exception re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public void updateEmpleado(TbEmpleadoEntity detachedInstance) throws Exception {
		log.debug("merging TbEmpleadoEntity instance");
		try {
			
			Session sesion = getSessionFactory().getCurrentSession();
//			Transaction tx = sesion.getTransaction();
			sesion.beginTransaction();
//			tx.begin();
			sesion.merge(detachedInstance);
//			tx.commit();
			sesion.getTransaction().commit();
			log.debug("merge successful");
		} catch (Exception re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public TbEmpleadoEntity findByIdEmpleado(String id) throws Exception {
		log.debug("getting TbEmpleadoEntity instance with id: " + id);
		try {
			TbEmpleadoEntity instance = (TbEmpleadoEntity) getSessionFactory().getCurrentSession().get("TbCargo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (Exception re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findAllEmpleado() throws Exception,HibernateException {
		log.debug("finding TbEmpleadoEntity instance by example");
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbEmpleadoEntity> results = sesion.createQuery(" from TbEmpleadoEntity ").list(); 
//			List<TbCargoEntity> results = getSessionFactory().openStatelessSession().createQuery("from CargoEntity").list();
			sesion.close();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (HibernateException re) {
			log.error("find by example failed", re);
			System.out.println(re.getMessage());
			System.out.println(re.getCause());
			System.out.println(re.getLocalizedMessage());
			System.out.println(re.getStackTrace().getClass().getName());
			throw re;
		}
	}
	
    @Override
    public String generarCodigoEmpleado() throws Exception {
    	String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	             ProcedureCall call = sesion.createStoredProcedureCall("pa_empleado_generar_codigo2")
	                     .registerParameter0("codigo_generado", String.class, ParameterMode.OUT);
	             
	             ProcedureOutputs po = call.getOutputs();
	             salida = (String)po.getOutputParameterValue("codigo_generado");
             sesion.getTransaction().commit();
             
            return  salida;
		} catch (Exception e) {
			throw e;
		}
    }
}
