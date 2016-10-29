package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbProveedorDao;
import com.ecoinnova.pe.model.TbProveedorEntity;
import com.ecoinnova.pe.services.interfaces.TbProveedorServices;

@Service("tbProveedorServices")
public class TbProveedorServicesImpl implements TbProveedorServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbProveedorDao tbProveedorDao;
	
	@Override
	public Serializable save(TbProveedorEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.save(object);
	}

	@Override
	public void saveCollection(List<TbProveedorEntity> list) throws Exception {
		tbProveedorDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbProveedorEntity object) throws Exception {
		tbProveedorDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbProveedorEntity object) throws Exception {
		tbProveedorDao.update(object);

	}

	@Override
	public void updateCollection(List<TbProveedorEntity> object) throws Exception {
		tbProveedorDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbProveedorDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbProveedorEntity object) throws Exception {
		try {
			tbProveedorDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertProveedor(TbProveedorEntity transientInstance) throws Exception {
		try {
			 tbProveedorDao.insertProveedor(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateProveedor(TbProveedorEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbProveedorDao.updateProveedor(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbProveedorEntity findByIdProveedor(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbProveedorDao.findByIdProveedor(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbProveedorEntity> findAllProveedor() throws Exception {
		try {
			return tbProveedorDao.findAllProveedor();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteProveedor(TbProveedorEntity persistentInstance) throws Exception {
		
		try {
			tbProveedorDao.deleteProveedor(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoProveedor() throws Exception{
		
		try {
			return tbProveedorDao.generarCodigoProveedor();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
