package com.ecoinnova.pe.services.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.model.TbCategoriaEntity;
import com.ecoinnova.pe.model.TbUnidadMedidaEntity;
import com.ecoinnova.pe.services.util.GenericService;

public interface TbUnidadMedidaServices extends GenericService<TbUnidadMedidaEntity, Serializable> {


	public void insertUnidadMedida(TbUnidadMedidaEntity transientInstance) throws Exception;

	public void deleteUnidadMedida(TbUnidadMedidaEntity persistentInstance) throws Exception;
		
	public void updateUnidadMedida(TbUnidadMedidaEntity detachedInstance) throws Exception;
		
	public TbUnidadMedidaEntity findByIdUnidadMedida(java.lang.String id) throws Exception;
		
	public List<TbUnidadMedidaEntity> findAllUnidadMedida() throws Exception;
		
	public String generarCodigoUnidadMedida() throws Exception;
	
	
}
