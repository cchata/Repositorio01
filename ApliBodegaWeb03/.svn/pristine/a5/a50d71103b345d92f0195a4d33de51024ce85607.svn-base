package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbClienteHomeDao;
import com.ecoinnova.pe.model.TbCliente;
import com.ecoinnova.pe.services.interfaces.TbClienteServices;

@Service("tbClienteServices")
public class TbClienteServicesImpl implements TbClienteServices {

	@Autowired
	TbClienteHomeDao tbClienteHomeDao;
	
	@Override
	public Serializable save(TbCliente object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCollection(List<TbCliente> list) throws Exception {
		tbClienteHomeDao.saveCollection(list);
	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters, int start, int finish, Class clazz) throws Exception {
		return tbClienteHomeDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbCliente object) throws Exception {
		tbClienteHomeDao.saveOrUpdate(object);
	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		return tbClienteHomeDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters, Class<T> type) throws Exception {
		return tbClienteHomeDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		return tbClienteHomeDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz) throws Exception {
		return tbClienteHomeDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz) throws Exception {
		return tbClienteHomeDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		return tbClienteHomeDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbCliente object) throws Exception {
		tbClienteHomeDao.update(object);
	}

	@Override
	public void updateCollection(List<TbCliente> object) throws Exception {
		tbClienteHomeDao.updateCollection(object);
	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,boolean nativeSQL) throws Exception {
		return tbClienteHomeDao.executeQuery(query, parameters, nativeSQL);
	}

	//Propios.
	@Override
	public void persist(TbCliente transientInstance) throws Exception {
		tbClienteHomeDao.persist(transientInstance);
	}

	@Override
	public void delete(TbCliente persistentInstance) throws Exception {
		tbClienteHomeDao.delete(persistentInstance);
	}

	@Override
	public TbCliente merge(TbCliente detachedInstance) throws Exception {
		return tbClienteHomeDao.merge(detachedInstance);
	}

	@Override
	public TbCliente findById(String id) throws Exception {
		return tbClienteHomeDao.findById(id);
	}

	@Override
	public List<TbCliente> findByExample(TbCliente instance) throws Exception {
		return tbClienteHomeDao.findByExample(instance);
	}

}
