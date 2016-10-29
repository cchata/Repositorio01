package com.ecoinnova.pe.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbUsuarioEntity;

public interface TbUsuarioDao extends GenericEntityDao<TbUsuarioEntity, Serializable> {

	public void insertUsuario(TbUsuarioEntity transientInstance) throws Exception;

	public void deleteUsuario(TbUsuarioEntity persistentInstance) throws Exception;
		
	public void updateUsuario(TbUsuarioEntity detachedInstance) throws Exception;
		
	public TbUsuarioEntity findByIdUsuario(java.lang.String id) throws Exception;
		
	public List<TbUsuarioEntity> findAllUsuario() throws Exception;
		
	public String generarCodigoUsuario() throws Exception;
	
	public void validarUsuario(Usuario usu) throws Exception;
	
	
}