package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbEmpleadoDao;
import com.ecoinnova.pe.model.TbEmpleadoEntity;
import com.ecoinnova.pe.services.interfaces.TbEmpleadoServices;

@Service("tbEmpleadoServices")
public class TbEmpleadoServicesImpl implements TbEmpleadoServices, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	TbEmpleadoDao tbEmpleadoDao;
	
	
	@Override
	public void insertEmpleado(TbEmpleadoEntity transientInstance) throws Exception {
		try {
			 tbEmpleadoDao.insertEmpleado(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateEmpleado(TbEmpleadoEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbEmpleadoDao.updateEmpleado(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbEmpleadoEntity findByIdEmpleado(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbEmpleadoDao.findByIdEmpleado(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbEmpleadoEntity> findAllEmpleado() throws Exception {
		try {
			return tbEmpleadoDao.findAllEmpleado();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteEmpleado(TbEmpleadoEntity persistentInstance) throws Exception {
		
		try {
			tbEmpleadoDao.deleteEmpleado(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoEmpleado() throws Exception{
		
		try {
			return tbEmpleadoDao.generarCodigoEmpleado();	
		} catch (Exception e) {
			throw e;
		}
	}

	
	
	@Override
	public Serializable save(TbEmpleadoEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.save(object);
	}

	@Override
	public void saveCollection(List<TbEmpleadoEntity> list) throws Exception {
		tbEmpleadoDao.saveCollection(list);
		
	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbEmpleadoEntity object) throws Exception {
		tbEmpleadoDao.saveOrUpdate(object);
		
	}

	@Override
	public void delete(TbEmpleadoEntity object) throws Exception {
		tbEmpleadoDao.delete(object);
		
	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbEmpleadoEntity object) throws Exception {
		tbEmpleadoDao.update(object);
		
	}

	@Override
	public void updateCollection(List<TbEmpleadoEntity> object)
			throws Exception {
		tbEmpleadoDao.updateCollection(object);
		
	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbEmpleadoDao.executeQuery(query, nativeSQL);
	}

	
	
	
}
