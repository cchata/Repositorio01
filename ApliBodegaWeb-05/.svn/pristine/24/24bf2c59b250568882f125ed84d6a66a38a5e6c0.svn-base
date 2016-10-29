package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbCategoriaDao;
import com.ecoinnova.pe.model.TbCategoriaEntity;
import com.ecoinnova.pe.services.interfaces.TbCategoriaServices;

@Service("tbCategoriaServices")
public class TbCategoriaServicesImpl implements TbCategoriaServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbCategoriaDao tbCategoriaDao;
	
	@Override
	public Serializable save(TbCategoriaEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.save(object);
	}

	@Override
	public void saveCollection(List<TbCategoriaEntity> list) throws Exception {
		tbCategoriaDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbCategoriaEntity object) throws Exception {
		tbCategoriaDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbCategoriaEntity object) throws Exception {
		tbCategoriaDao.update(object);

	}

	@Override
	public void updateCollection(List<TbCategoriaEntity> object) throws Exception {
		tbCategoriaDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbCategoriaDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbCategoriaEntity object) throws Exception {
		try {
			tbCategoriaDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertCategoria(TbCategoriaEntity transientInstance) throws Exception {
		try {
			 tbCategoriaDao.insertCategoria(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateCategoria(TbCategoriaEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbCategoriaDao.updateCategoria(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbCategoriaEntity findByIdCategoria(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbCategoriaDao.findByIdCategoria(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbCategoriaEntity> findAllCategoria() throws Exception {
		try {
			return tbCategoriaDao.findAllCategoria();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteCategoria(TbCategoriaEntity persistentInstance) throws Exception {
		
		try {
			tbCategoriaDao.deleteCategoria(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoCategoria() throws Exception{
		
		try {
			return tbCategoriaDao.generarCodigoCategoria();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
