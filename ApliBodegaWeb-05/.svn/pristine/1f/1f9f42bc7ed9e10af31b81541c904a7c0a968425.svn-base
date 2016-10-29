package com.ecoinnova.pe.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoinnova.pe.dao.interfaces.TbBoletaDao;
import com.ecoinnova.pe.model.TbBoletaEntity;
import com.ecoinnova.pe.services.interfaces.TbBoletaServices;

@Service("tbBoletaServices")
public class TbBoletaServicesImpl implements TbBoletaServices, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	TbBoletaDao tbBoletaDao;
	
	@Override
	public Serializable save(TbBoletaEntity object) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.save(object);
	}

	@Override
	public void saveCollection(List<TbBoletaEntity> list) throws Exception {
		tbBoletaDao.saveCollection(list);

	}

	@Override
	public List listLazyHQL(String hql, Map<String, Object> parameters,
			int start, int finish, Class clazz) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.listLazyHQL(hql, parameters, start, finish, clazz);
	}

	@Override
	public void saveOrUpdate(TbBoletaEntity object) throws Exception {
		tbBoletaDao.saveOrUpdate(object);

	}

	@Override
	public <T> T getById(Class<T> type, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.getById(type, id);
	}

	@Override
	public <T> T getByHQL(String hql, Map<String, Object> parameters,
			Class<T> type) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.getByHQL(hql, parameters, type);
	}

	@Override
	public int executeQuery(String query, boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.executeQuery(query, nativeSQL);
	}

	@Override
	public List listHQL(String hql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.listHQL(hql, parameters, clazz);
	}

	@Override
	public List listSQL(String sql, Map<String, Object> parameters, Class clazz)
			throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.listSQL(sql, parameters, clazz);
	}

	@Override
	public List listCriterion(List<Criterion> listCriterion) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.listCriterion(listCriterion);
	}

	@Override
	public void update(TbBoletaEntity object) throws Exception {
		tbBoletaDao.update(object);

	}

	@Override
	public void updateCollection(List<TbBoletaEntity> object) throws Exception {
		tbBoletaDao.updateCollection(object);

	}

	@Override
	public int executeQuery(String query, Map<String, Object> parameters,
			boolean nativeSQL) throws Exception {
		// TODO Auto-generated method stub
		return tbBoletaDao.executeQuery(query, parameters, nativeSQL);
	}
	
	@Override
	public void delete(TbBoletaEntity object) throws Exception {
		try {
			tbBoletaDao.delete(object);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	
	
	
	
	@Override
	public void insertBoleta(TbBoletaEntity transientInstance) throws Exception {
		try {
			 tbBoletaDao.insertBoleta(transientInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void updateBoleta(TbBoletaEntity detachedInstance) throws Exception {
		// TODO Auto-generated method stub
		try {
			tbBoletaDao.updateBoleta(detachedInstance);	
		} catch (Exception e) {
			throw e;
		}
		
	}

	@Override
	public TbBoletaEntity findByIdBoleta(String id) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			return tbBoletaDao.findByIdBoleta(id);	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<TbBoletaEntity> findAllBoleta() throws Exception {
		try {
			return tbBoletaDao.findAllBoleta();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	@Override
	public void deleteBoleta(TbBoletaEntity persistentInstance) throws Exception {
		
		try {
			tbBoletaDao.deleteBoleta(persistentInstance);	
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public String generarCodigoBoleta() throws Exception{
		
		try {
			return tbBoletaDao.generarCodigoBoleta();	
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String actulizarStockProducto(String codProducto, int cantidadVendida)
			throws Exception {
		try {
			return tbBoletaDao.actulizarStockProducto(codProducto, cantidadVendida);	
		} catch (Exception e) {
			throw e;
		}
	}
	
}
