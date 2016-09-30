package com.ecoinnova.pe.dao.interfaces;

import static org.hibernate.criterion.Example.create;

import java.io.Serializable;
import java.util.List;

import com.ecoinnova.pe.dao.util.GenericEntityDao;
import com.ecoinnova.pe.model.TbCliente;

public interface TbClienteHomeDao  extends GenericEntityDao<TbCliente,Serializable>{

	
	public void persist(TbCliente transientInstance) throws Exception;
		

	public void delete(TbCliente persistentInstance)throws Exception;
		

	public TbCliente merge(TbCliente detachedInstance)throws Exception;
		

	public TbCliente findById(java.lang.String id)throws Exception;
		

	public List<TbCliente> findByExample(TbCliente instance)throws Exception;
		
}
