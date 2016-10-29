package com.ecoinnova.pe.dao.hibernate.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.ecoinnova.pe.dao.interfaces.TbUsuarioDao;
import com.ecoinnova.pe.dao.util.GenericEntityDaoImpl;
import com.ecoinnova.pe.model.TbUsuarioEntity;

import com.ecoinnova.pe.bean.*;

@Repository("tbUsuarioDao")
public class TbUsuarioDaoImpl extends GenericEntityDaoImpl<TbUsuarioEntity,Serializable> implements TbUsuarioDao, Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public void insertUsuario(TbUsuarioEntity transientInstance)
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
	public void deleteUsuario(TbUsuarioEntity persistentInstance)
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
	public void updateUsuario(TbUsuarioEntity detachedInstance)
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
	public TbUsuarioEntity findByIdUsuario(String id) throws Exception {
		try {
			TbUsuarioEntity instance = (TbUsuarioEntity) getSessionFactory().getCurrentSession().get(TbUsuarioEntity.class, id);
			if (instance == null) {
				
			} else {
				
			}
			return instance;
		} catch (Exception re) {
			throw re;
		}	}

	@Override
	public List<TbUsuarioEntity> findAllUsuario() throws Exception {
		try {
			Session sesion = getSessionFactory().openSession();
			List<TbUsuarioEntity> results = sesion.createQuery(" from TbUsuarioEntity ").list();
			sesion.close();
			return results;
		} catch (Exception re) {
			System.out.println(re.getMessage());
			System.out.println(re.getCause());
			throw re;
		}
	}

	@Override
	public String generarCodigoUsuario() throws Exception {
		String salida = null;
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	         ProcedureCall call = sesion.createStoredProcedureCall("pa_usuario_generar_codigo2")
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
	public void validarUsuario(Usuario usu) throws Exception {
		
        try {
        	 Session sesion = getSessionFactory().getCurrentSession();
        	 sesion.getTransaction().begin();
	         ProcedureCall call;
	         
	         call = sesion.createStoredProcedureCall("pa_validar_usuario")
	        		 .registerParameter0("p_loguinUsuario", String.class, ParameterMode.IN)
	         		 .registerParameter0("p_claveUsuario", String.class, ParameterMode.IN)
	         		 .registerParameter0("p_codigoEmpleado", String.class, ParameterMode.OUT)
	         		 .registerParameter0("p_nombreEmpleado", String.class, ParameterMode.OUT)
	         		 .registerParameter0("p_apellidoEmpleado", String.class, ParameterMode.OUT)
	         		 .registerParameter0("p_mensajeError", String.class, ParameterMode.OUT);
	             
	         call.getParameterRegistration("p_loguinUsuario").bindValue(usu.getLogin());
	         call.getParameterRegistration("p_claveUsuario").bindValue(usu.getClave());
	         
	         
	         ProcedureOutputs po = call.getOutputs();
	         usu.setCodigoEmpleado( (String)po.getOutputParameterValue("p_codigoEmpleado"));
	         usu.setNombreEmpleado( (String)po.getOutputParameterValue("p_nombreEmpleado"));
	         usu.setApellidoEmpleado( (String)po.getOutputParameterValue("p_apellidoEmpleado"));
	         usu.setC_menserro( (String)po.getOutputParameterValue("p_mensajeError"));
	         
             sesion.getTransaction().commit();
             
		} catch (Exception e) {
			throw e;
		}	
    
		
	}

	
}
