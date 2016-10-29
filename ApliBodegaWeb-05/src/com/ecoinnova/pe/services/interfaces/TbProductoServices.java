package com.ecoinnova.pe.services.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.model.TbProductoEntity;
import com.ecoinnova.pe.services.util.GenericService;

public interface TbProductoServices extends GenericService<TbProductoEntity, Serializable> {


	public void insertProducto(TbProductoEntity transientInstance) throws Exception;

	public void deleteProducto(TbProductoEntity persistentInstance) throws Exception;
		
	public void updateProducto(TbProductoEntity detachedInstance) throws Exception;
		
	public TbProductoEntity findByIdProducto(java.lang.String id) throws Exception;
		
	public List<TbProductoEntity> findAllProducto() throws Exception;
		
	public String generarCodigoProducto() throws Exception;
	
	
	
	
	
	
}