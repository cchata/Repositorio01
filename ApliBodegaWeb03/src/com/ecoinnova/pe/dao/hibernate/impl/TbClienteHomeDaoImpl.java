package com.ecoinnova.pe.dao.hibernate.impl;

// Generated 29-sep-2016 16:58:35 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbClienteHomeDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbCliente;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TbCliente.
 * @see com.ecoinnova.pe.dao.hibernate.impl.TbCliente
 * @author Hibernate Tools
 */
@Repository("tbClienteHomeDao")
public class TbClienteHomeDaoImpl extends GenericEntityDaoImpl<TbCliente,Serializable> implements TbClienteHomeDao{

	private static final Log log = LogFactory.getLog(TbClienteHomeDaoImpl.class);

//	private final SessionFactory sessionFactory = getSessionFactory();

//	protected SessionFactory getSessionFactory() {
//		try {
//			return (SessionFactory) new InitialContext()
//					.lookup("SessionFactory");
//		} catch (Exception e) {
//			log.error("Could not locate SessionFactory in JNDI", e);
//			throw new IllegalStateException(
//					"Could not locate SessionFactory in JNDI");
//		}
//	}

	@Override
	public void persist(TbCliente transientInstance) {
		log.debug("persisting TbCliente instance");
		try {
			getSessionFactory().getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}


	@Override
	public void delete(TbCliente persistentInstance) {
		log.debug("deleting TbCliente instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public TbCliente merge(TbCliente detachedInstance) {
		log.debug("merging TbCliente instance");
		try {
			TbCliente result = (TbCliente) getSessionFactory().getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public TbCliente findById(java.lang.String id) {
		log.debug("getting TbCliente instance with id: " + id);
		try {
			TbCliente instance = (TbCliente) getSessionFactory().getCurrentSession().get(TbCliente.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<TbCliente> findByExample(TbCliente instance) {
		log.debug("finding TbCliente instance by example");
		try {
			List<TbCliente> results = (List<TbCliente>) getSessionFactory().getCurrentSession().createCriteria(TbCliente.class).add(create(instance)).list();
			log.debug("find by example successful, result size: "+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
