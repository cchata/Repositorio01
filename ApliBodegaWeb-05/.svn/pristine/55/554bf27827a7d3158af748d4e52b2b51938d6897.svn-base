package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.dao.interfaces.TbUsuarioDao;
import com.ecoinnova.pe.model.TbUsuarioEntity;
import com.ecoinnova.pe.services.interfaces.TbUsuarioServices;

@Service("tbUsuarioServices")
public class TbUsuarioServicesImpl implements TbUsuarioServices, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	TbUsuarioDao tbUsuarioDao;
	
	@Override
	public Serializable save(TbUsuarioEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.save(object);
	}

	@Override
	public void saveCollection(List<TbUsuarioEntity> list) throws Exception {
		tbUsuarioDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbUsuarioEntity object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(TbUsuarioEntity object) throws Exception {
		tbUsuarioDao.delete(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbUsuarioEntity object) throws Exception {
		tbUsuarioDao.update(object);

	}

	@Override
	public void updateCollection(List<TbUsuarioEntity> object) throws Exception {
		tbUsuarioDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbUsuarioDao.executeQuery(query, nativeSQL);
	}

	
	
	
	@Override
	public void insertUsuario(TbUsuarioEntity transientInstance)
			throws Exception {
		try {
			tbUsuarioDao.insertUsuario(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
		

	}

	@Override
	public void deleteUsuario(TbUsuarioEntity persistentInstance)
			throws Exception {

		try {
			tbUsuarioDao.deleteUsuario(persistentInstance);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateUsuario(TbUsuarioEntity detachedInstance)
			throws Exception {
		try {
			tbUsuarioDao.updateUsuario(detachedInstance);
		} catch (Exception e) {
			throw e;
			
		}
		
	}

	@Override
	public TbUsuarioEntity findByIdUsuario(String id) throws Exception {
		
		try {
			return  tbUsuarioDao.findByIdUsuario(id);
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<TbUsuarioEntity> findAllUsuario() throws Exception {

		try {
			return tbUsuarioDao.findAllUsuario();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String generarCodigoUsuario() throws Exception {
		try {
			return tbUsuarioDao.generarCodigoUsuario();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void validarUsuario(Usuario usu) throws Exception {
		try {
			tbUsuarioDao.validarUsuario(usu);
		} catch (Exception e) {
			throw e;
		}
		
	}

}
