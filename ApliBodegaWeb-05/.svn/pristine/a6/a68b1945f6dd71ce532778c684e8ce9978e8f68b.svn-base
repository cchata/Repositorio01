package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbClienteDao;
import com.ecoinnova.pe.model.TbClienteEntity;
import com.ecoinnova.pe.services.interfaces.TbClienteServices;

@Service("tbClienteServices")
public class TbClienteServicesImpl implements TbClienteServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbClienteDao tbClienteDao;
	
	@Override
	public Serializable save(TbClienteEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.save(object);
	}

	@Override
	public void saveCollection(List<TbClienteEntity> list) throws Exception {
		tbClienteDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbClienteEntity object) throws Exception {
		tbClienteDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbClienteEntity object) throws Exception {
		tbClienteDao.update(object);

	}

	@Override
	public void updateCollection(List<TbClienteEntity> object) throws Exception {
		tbClienteDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbClienteDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbClienteEntity object) throws Exception {
		try {
			tbClienteDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertCliente(TbClienteEntity transientInstance) throws Exception {
		try {
			 tbClienteDao.insertCliente(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateCliente(TbClienteEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbClienteDao.updateCliente(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbClienteEntity findByIdCliente(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbClienteDao.findByIdCliente(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbClienteEntity> findAllCliente() throws Exception {
		try {
			return tbClienteDao.findAllCliente();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteCliente(TbClienteEntity persistentInstance) throws Exception {
		
		try {
			tbClienteDao.deleteCliente(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoCliente() throws Exception{
		
		try {
			return tbClienteDao.generarCodigoCliente();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
