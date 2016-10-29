package com.ecoinnova.pe.services.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.model.TbUsuarioEntity;
import com.ecoinnova.pe.services.util.GenericService;

public interface TbUsuarioServices extends GenericService<TbUsuarioEntity, Serializable> {


	public void insertUsuario(TbUsuarioEntity transientInstance) throws Exception;

	public void deleteUsuario(TbUsuarioEntity persistentInstance) throws Exception;
		
	public void updateUsuario(TbUsuarioEntity detachedInstance) throws Exception;
		
	public TbUsuarioEntity findByIdUsuario(java.lang.String id) throws Exception;
		
	public List<TbUsuarioEntity> findAllUsuario() throws Exception;
		
	public String generarCodigoUsuario() throws Exception;
	
	public void validarUsuario(Usuario usu) throws Exception;
}
