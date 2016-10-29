package com.ecoinnova.pe.services.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.model.TbMarcaEntity;
import com.ecoinnova.pe.services.util.GenericService;

public interface TbMarcaServices extends GenericService<TbMarcaEntity, Serializable> {


	public void insertMarca(TbMarcaEntity transientInstance) throws Exception;

	public void deleteMarca(TbMarcaEntity persistentInstance) throws Exception;
		
	public void updateMarca(TbMarcaEntity detachedInstance) throws Exception;
		
	public TbMarcaEntity findByIdMarca(java.lang.String id) throws Exception;
		
	public List<TbMarcaEntity> findAllMarca() throws Exception;
		
	public String generarCodigoMarca() throws Exception;
	
	
	
	
}
