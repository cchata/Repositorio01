package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbProductoDao;
import com.ecoinnova.pe.model.TbProductoEntity;
import com.ecoinnova.pe.services.interfaces.TbProductoServices;

@Service("tbProductoServices")
public class TbProductoServicesImpl implements TbProductoServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbProductoDao tbProductoDao;
	
	@Override
	public Serializable save(TbProductoEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.save(object);
	}

	@Override
	public void saveCollection(List<TbProductoEntity> list) throws Exception {
		tbProductoDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbProductoEntity object) throws Exception {
		tbProductoDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbProductoEntity object) throws Exception {
		tbProductoDao.update(object);

	}

	@Override
	public void updateCollection(List<TbProductoEntity> object) throws Exception {
		tbProductoDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbProductoDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbProductoEntity object) throws Exception {
		try {
			tbProductoDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertProducto(TbProductoEntity transientInstance) throws Exception {
		try {
			 tbProductoDao.insertProducto(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateProducto(TbProductoEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbProductoDao.updateProducto(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbProductoEntity findByIdProducto(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbProductoDao.findByIdProducto(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbProductoEntity> findAllProducto() throws Exception {
		try {
			return tbProductoDao.findAllProducto();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteProducto(TbProductoEntity persistentInstance) throws Exception {
		
		try {
			tbProductoDao.deleteProducto(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoProducto() throws Exception{
		
		try {
			return tbProductoDao.generarCodigoProducto();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
