package com.ecoinnova.pe.dao.hibernate.impl;

import java.io.Serializable;



import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbUnidadMedidaDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbUnidadMedidaEntity;

@Repository("tbUnidadMedidaDao")
public class TbUnidadMedidaDaoImpl extends GenericEntityDaoImpl<TbUnidadMedidaEntity,Serializable> implements TbUnidadMedidaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void insertUnidadMedida(TbUnidadMedidaEntity transientInstance)
			throws Exception {
		Session sesion = getSessionFactory().getCurrentSession();
		Transaction tx = sesion.getTransaction();
		try {
			tx.begin();
			sesion.save(transientInstance);
			tx.commit();
		} catch (Exception re) {
			throw re;
		}
		
		
	}

	@Override
	public void deleteUnidadMedida(TbUnidadMedidaEntity persistentInstance)
			throws Exception {
		try {
			Session sesion = getSessionFactory().getCurrentSession();
			sesion.beginTransaction();
			sesion.delete(persistentInstance);
			sesion.getTransaction().commit();
		} catch (Exception re) {
			throw re;
		}
		
	}

	@Override
	public void updateUnidadMedida(TbUnidadMedidaEntity detachedInstance)
			throws Exception {
		try {
			Session sesion = getSessionFactory().getCurrentSession();
			sesion.beginTransaction();
			sesion.merge(detachedInstance);
			sesion.getTransaction().commit();
		} catch (Exception re) {
			throw re;
		}
		
	}

	@Override
	public TbUnidadMedidaEntity findByIdUnidadMedida(String id) throws Exception {
		try {
			TbUnidadMedidaEntity instance = (TbUnidadMedidaEntity) getSessionFactory().getCurrentSession().get(TbUnidadMedidaEntity.class, id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}	
	}

	@Override
	public List<TbUnidadMedidaEntity> findAllUnidadMedida() throws Exception {
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbUnidadMedidaEntity> results = sesion.createQuery(" from TbUnidadMedidaEntity ").list();
			sesion.close();
			return results;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public String generarCodigoUnidadMedida() throws Exception {
		String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_unidadMedida_generar_codigo2")
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
