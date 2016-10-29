package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbUnidadMedidaDao;
import com.ecoinnova.pe.model.TbUnidadMedidaEntity;
import com.ecoinnova.pe.services.interfaces.TbUnidadMedidaServices;

@Service("tbUnidadMedidaServices")
public class TbUnidadMedidaServicesImpl implements TbUnidadMedidaServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbUnidadMedidaDao tbUnidadMedidaDao;
	
	@Override
	public Serializable save(TbUnidadMedidaEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.save(object);
	}

	@Override
	public void saveCollection(List<TbUnidadMedidaEntity> list) throws Exception {
		tbUnidadMedidaDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbUnidadMedidaEntity object) throws Exception {
		tbUnidadMedidaDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbUnidadMedidaEntity object) throws Exception {
		tbUnidadMedidaDao.update(object);

	}

	@Override
	public void updateCollection(List<TbUnidadMedidaEntity> object) throws Exception {
		tbUnidadMedidaDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbUnidadMedidaDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbUnidadMedidaEntity object) throws Exception {
		try {
			tbUnidadMedidaDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertUnidadMedida(TbUnidadMedidaEntity transientInstance) throws Exception {
		try {
			 tbUnidadMedidaDao.insertUnidadMedida(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateUnidadMedida(TbUnidadMedidaEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbUnidadMedidaDao.updateUnidadMedida(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbUnidadMedidaEntity findByIdUnidadMedida(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbUnidadMedidaDao.findByIdUnidadMedida(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbUnidadMedidaEntity> findAllUnidadMedida() throws Exception {
		try {
			return tbUnidadMedidaDao.findAllUnidadMedida();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteUnidadMedida(TbUnidadMedidaEntity persistentInstance) throws Exception {
		
		try {
			tbUnidadMedidaDao.deleteUnidadMedida(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoUnidadMedida() throws Exception{
		
		try {
			return tbUnidadMedidaDao.generarCodigoUnidadMedida();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
