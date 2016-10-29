package com.ecoinnova.pe.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbProveedorEntity;

public interface TbProveedorDao extends GenericEntityDao<TbProveedorEntity, Serializable> {


	public void insertProveedor(TbProveedorEntity transientInstance) throws Exception;

	public void deleteProveedor(TbProveedorEntity persistentInstance) throws Exception;
		
	public void updateProveedor(TbProveedorEntity detachedInstance) throws Exception;
		
	public TbProveedorEntity findByIdProveedor(java.lang.String id) throws Exception;
		
	public List<TbProveedorEntity> findAllProveedor() throws Exception;
		
	public String generarCodigoProveedor() throws Exception;
	
	
}
