package com.ecoinnova.pe.dao.hibernate.impl;

import java.io.Serializable;



import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbCategoriaDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbCategoriaEntity;
import com.ecoinnova.pe.model.TbCategoriaEntity;
import com.ecoinnova.pe.model.TbUsuarioEntity;

@Repository("tbCategoriaDao")
public class TbCategoriaDaoImpl extends GenericEntityDaoImpl<TbCategoriaEntity,Serializable> implements TbCategoriaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void insertCategoria(TbCategoriaEntity transientInstance)
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
	public void deleteCategoria(TbCategoriaEntity persistentInstance)
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
	public void updateCategoria(TbCategoriaEntity detachedInstance)
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
	public TbCategoriaEntity findByIdCategoria(String id) throws Exception {
		try {
			TbCategoriaEntity instance = (TbCategoriaEntity) getSessionFactory().getCurrentSession().get(TbCategoriaEntity.class, id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}	
	}

	@Override
	public List<TbCategoriaEntity> findAllCategoria() throws Exception {
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbCategoriaEntity> results = sesion.createQuery(" from TbCategoriaEntity ").list();
			sesion.close();
			return results;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public String generarCodigoCategoria() throws Exception {
		String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_categoria_generar_codigo2")
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
