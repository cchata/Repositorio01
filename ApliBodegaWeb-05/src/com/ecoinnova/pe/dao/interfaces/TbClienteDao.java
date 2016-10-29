package com.ecoinnova.pe.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbClienteEntity;
import com.ecoinnova.pe.model.TbUsuarioEntity;

public interface TbClienteDao extends GenericEntityDao<TbClienteEntity, Serializable> {


	public void insertCliente(TbClienteEntity transientInstance) throws Exception;

	public void deleteCliente(TbClienteEntity persistentInstance) throws Exception;
		
	public void updateCliente(TbClienteEntity detachedInstance) throws Exception;
		
	public TbClienteEntity findByIdCliente(java.lang.String id) throws Exception;
		
	public List<TbClienteEntity> findAllCliente() throws Exception;
		
	public String generarCodigoCliente() throws Exception;
	
	
}