package com.ecoinnova.pe.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbCategoriaEntity;

public interface TbCategoriaDao extends GenericEntityDao<TbCategoriaEntity, Serializable> {


	public void insertCategoria(TbCategoriaEntity transientInstance) throws Exception;

	public void deleteCategoria(TbCategoriaEntity persistentInstance) throws Exception;
		
	public void updateCategoria(TbCategoriaEntity detachedInstance) throws Exception;
		
	public TbCategoriaEntity findByIdCategoria(java.lang.String id) throws Exception;
		
	public List<TbCategoriaEntity> findAllCategoria() throws Exception;
		
	public String generarCodigoCategoria() throws Exception;
	
	
}
