package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbCargoDao;
import com.ecoinnova.pe.model.TbCargoEntity;
import com.ecoinnova.pe.services.interfaces.TbCargoServices;

@Service("tbCargoServices")
public class TbCargoServicesImpl implements TbCargoServices, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	TbCargoDao tbCargoDao;
	
	@Override
	public Serializable save(TbCargoEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.save(object);
	}

	@Override
	public void saveCollection(List<TbCargoEntity> list) throws Exception {
		tbCargoDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbCargoEntity object) throws Exception {
		tbCargoDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbCargoEntity object) throws Exception {
		tbCargoDao.update(object);

	}

	@Override
	public void updateCollection(List<TbCargoEntity> object) throws Exception {
		tbCargoDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbCargoDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbCargoEntity object) throws Exception {
		try {
			tbCargoDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertCargo(TbCargoEntity transientInstance) throws Exception {
		try {
			 tbCargoDao.insertCargo(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateCargo(TbCargoEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbCargoDao.updateCargo(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbCargoEntity findByIdCargo(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbCargoDao.findByIdCargo(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbCargoEntity> findAllCargo() throws Exception {
		try {
			return tbCargoDao.findAllCargo();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteCargo(TbCargoEntity persistentInstance) throws Exception {
		
		try {
			tbCargoDao.deleteCargo(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoCargo() throws Exception{
		
		try {
			return tbCargoDao.generarCodigoCargo();	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
