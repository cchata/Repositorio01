package daoimpl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.ActorDao;
import entity.Actor;
import exception.DataBaseException;

public class ActorDaoImpl implements ActorDao {

	@Override
	public boolean insert(EntityManager em, Actor actor) {
		boolean salida = false;
		try {
			em.persist(actor);
			salida = true;
		} catch (Exception ex) {
			salida = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
		}
		
		return salida;
	}

	@Override
	public boolean update(EntityManager em, Actor actor) {
		boolean salida = false;
		try {
//			Actor actorEntity = em.find(Actor.class, actor.getId());
			em.merge(actor);
			salida = true;
		} catch (PersistenceException ex) {
			salida = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.update() <br/> "+ex.getMessage(),ex);
		}
		return salida;
	}

	@Override
	public boolean delete(EntityManager em, Actor actor) {
		
		boolean salida = false;
		try {
			Actor actorEntity = em.find(Actor.class, actor.getId());
			em.remove(actorEntity);
			salida = true;
		} catch (IllegalArgumentException ex) {
			 salida = false;
			 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.delete() <br/> "+ex.getMessage(),ex);
		}		
		return salida;
	}

	@Override
	public Actor getById(EntityManager em, int id) {
		Actor actor = null;
		try {
			actor = em.find(Actor.class, id);
//			NoResultException             cuando no existe resultados.  GETSINGLERESULT
//			NoUniqueResultException       cuando existe mas resultados en lugar de uno.			
		} catch (NoResultException ex) {
			actor = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.getById() <br/> "+ex.getMessage(),ex);
		} catch (NonUniqueResultException ex) {
			actor = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.getById() <br/> "+ex.getMessage(),ex);
		}
		
		return actor;
	}

	@Override
	public List<Actor> getListByNombre(EntityManager em, String nombre) {
		List<Actor> lista       = null;
		String      queryParam1 = "";
		Query       q           = null;
		try {
			queryParam1 = " Select a From Actor a Where lower(a.nombre) like concat('%',concat(?1,'%')) order by a.id asc ";
			q           = em.createQuery(queryParam1);
			q.setParameter(1, nombre.toLowerCase());
			lista       = q.getResultList();
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.getListByNombre() <br/> "+ex.getMessage(),ex);
		}
		 
		return lista;
	}

	@Override
	public List<Actor> getListAll(EntityManager em){
		List<Actor> lista       = null;
		Query       q           = null;
		try {
			q     = em.createNamedQuery("Actor.findAll");
			lista = q.getResultList();	
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.getListAll() <br/> "+ex.getMessage(),ex);
		}
		return lista;
	}

}
