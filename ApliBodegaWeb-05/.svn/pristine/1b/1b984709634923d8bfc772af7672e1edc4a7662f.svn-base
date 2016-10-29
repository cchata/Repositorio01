package com.ecoinnova.pe.dao.hibernate.impl;

import java.io.Serializable;



import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbMarcaDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbMarcaEntity;

@Repository("tbMarcaDao")
public class TbMarcaDaoImpl extends GenericEntityDaoImpl<TbMarcaEntity,Serializable> implements TbMarcaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void insertMarca(TbMarcaEntity transientInstance)
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
	public void deleteMarca(TbMarcaEntity persistentInstance)
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
	public void updateMarca(TbMarcaEntity detachedInstance)
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
	public TbMarcaEntity findByIdMarca(String id) throws Exception {
		try {
			TbMarcaEntity instance = (TbMarcaEntity) getSessionFactory().getCurrentSession().get(TbMarcaEntity.class, id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}	
	}

	@Override
	public List<TbMarcaEntity> findAllMarca() throws Exception {
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbMarcaEntity> results = sesion.createQuery(" from TbMarcaEntity ").list();
			sesion.close();
			return results;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public String generarCodigoMarca() throws Exception {
		String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_marca_generar_codigo2")
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
