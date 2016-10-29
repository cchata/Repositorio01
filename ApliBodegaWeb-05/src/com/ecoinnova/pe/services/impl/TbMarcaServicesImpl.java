package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbMarcaDao;
import com.ecoinnova.pe.model.TbMarcaEntity;
import com.ecoinnova.pe.services.interfaces.TbMarcaServices;

@Service("tbMarcaServices")
public class TbMarcaServicesImpl implements TbMarcaServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbMarcaDao tbMarcaDao;
	
	@Override
	public Serializable save(TbMarcaEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.save(object);
	}

	@Override
	public void saveCollection(List<TbMarcaEntity> list) throws Exception {
		tbMarcaDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbMarcaEntity object) throws Exception {
		tbMarcaDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbMarcaEntity object) throws Exception {
		tbMarcaDao.update(object);

	}

	@Override
	public void updateCollection(List<TbMarcaEntity> object) throws Exception {
		tbMarcaDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbMarcaDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbMarcaEntity object) throws Exception {
		try {
			tbMarcaDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertMarca(TbMarcaEntity transientInstance) throws Exception {
		try {
			 tbMarcaDao.insertMarca(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateMarca(TbMarcaEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbMarcaDao.updateMarca(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbMarcaEntity findByIdMarca(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbMarcaDao.findByIdMarca(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbMarcaEntity> findAllMarca() throws Exception {
		try {
			return tbMarcaDao.findAllMarca();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteMarca(TbMarcaEntity persistentInstance) throws Exception {
		
		try {
			tbMarcaDao.deleteMarca(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoMarca() throws Exception{
		
		try {
			return tbMarcaDao.generarCodigoMarca();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
