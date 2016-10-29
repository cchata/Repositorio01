package com.ecoinnova.pe.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbEmpleadoEntity;

public interface TbEmpleadoDao extends GenericEntityDao<TbEmpleadoEntity, Serializable> {


	public void insertEmpleado(TbEmpleadoEntity transientInstance) throws Exception;

	public void deleteEmpleado(TbEmpleadoEntity persistentInstance) throws Exception;
		
	public void updateEmpleado(TbEmpleadoEntity detachedInstance) throws Exception;
		
	public TbEmpleadoEntity findByIdEmpleado(java.lang.String id) throws Exception;
		
	public List<TbEmpleadoEntity> findAllEmpleado() throws Exception;
		
	public String generarCodigoEmpleado() throws Exception;
	
}
