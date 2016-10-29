package com.ecoinnova.pe.dao.hibernate.impl;

import java.io.Serializable;



import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbBoletaDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbBoletaEntity;
import com.ecoinnova.pe.util.MyUtil;

@Repository("tbBoletaDao")
public class TbBoletaDaoImpl extends GenericEntityDaoImpl<TbBoletaEntity,Serializable> implements TbBoletaDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void insertBoleta(TbBoletaEntity transientInstance)
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
	public void deleteBoleta(TbBoletaEntity persistentInstance)
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
	public void updateBoleta(TbBoletaEntity detachedInstance)
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
	public TbBoletaEntity findByIdBoleta(String id) throws Exception {
		try {
			TbBoletaEntity instance = (TbBoletaEntity) getSessionFactory().getCurrentSession().get(TbBoletaEntity.class, id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}	
	}

	@Override
	public List<TbBoletaEntity> findAllBoleta() throws Exception {
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbBoletaEntity> results = sesion.createQuery(" from TbBoletaEntity ").list();
			sesion.close();
			return results;
		} catch (Exception re) {
			throw re;
		}
	}

	@Override
	public String generarCodigoBoleta() throws Exception {
		String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();                      
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_boleta_generar_codigo2")
	                     .registerParameter0("codigo_generado", String.class, ParameterMode.OUT);
	             
	         ProcedureOutputs po = call.getOutputs();
	         salida = (String)po.getOutputParameterValue("codigo_generado");
             sesion.getTransaction().commit();
            return  salida;
		} catch (Exception e) {
			throw e;
		}	
	}

	@Override
	public String actulizarStockProducto(String codProducto, int cantidadVendida)
			throws Exception {

		
		String salida = null;
		 try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();                      
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_producto_actulizar_stock2")
	        		     .registerParameter0("p_codigoPro", String.class, ParameterMode.IN)
	        		     .registerParameter0("p_cantidad", Integer.class, ParameterMode.IN)
	                     .registerParameter0("p_mensaje_error", String.class, ParameterMode.OUT);
	             
	         
	         call.getParameterRegistration("p_codigoPro").bindValue(codProducto);
	         call.getParameterRegistration("p_cantidad").bindValue(cantidadVendida);
	         
	         ProcedureOutputs po = call.getOutputs();
	         salida = (String)po.getOutputParameterValue("p_mensaje_error");
             sesion.getTransaction().commit();
             MyUtil.systemOutPrintln("p_mensaje_error: "+salida);
             return salida;
		} catch (Exception e) {
			throw e;
		}
		
		
	}
		
}
