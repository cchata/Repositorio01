package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import dao.PeliculaDao;
import entity.Actor;
import entity.Pelicula;
import exception.DataBaseException;

public class PeliculaDaoImpl implements PeliculaDao {

	@Override
	public boolean insert(EntityManager em, Pelicula pelicula) {
		boolean salida = false;
		try {
			em.persist(pelicula);
			salida = true;
		} catch (Exception ex) {
			salida = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.insert() <br/> "+ex.getMessage(),ex);
		}
		
		return salida;
	}

	@Override
	public boolean update(EntityManager em, Pelicula pelicula) {
		boolean salida = false;
		try {
//			Actor actorEntity = em.find(Actor.class, actor.getId());
			em.merge(pelicula);
			salida = true;
		} catch (PersistenceException ex) {
			salida = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.update() <br/> "+ex.getMessage(),ex);
		}
		return salida;
	}

	@Override
	public boolean delete(EntityManager em, Pelicula pelicula) {
		boolean salida = false;
		try {
			Pelicula peliculaEntity = em.find(Pelicula.class, pelicula.getId());
			em.remove(peliculaEntity);
			salida = true;
		} catch (IllegalArgumentException ex) {
			 salida = false;
			 throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.delete() <br/> "+ex.getMessage(),ex);
		}		
		return salida;
	}

	@Override
	public Pelicula getById(EntityManager em, int id) {
		Pelicula pelicula = null;
		try {
			pelicula = em.find(Pelicula.class, id);
//			NoResultException             cuando no existe resultados.  GETSINGLERESULT
//			NoUniqueResultException       cuando existe mas resultados en lugar de uno.			
		} catch (NoResultException ex) {
			pelicula = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.getById() <br/> "+ex.getMessage(),ex);
		} catch (NonUniqueResultException ex) {
			pelicula = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.getById() <br/> "+ex.getMessage(),ex);
		}
		
		return pelicula;
	}

	@Override
	public List<Pelicula> getListByNombre(EntityManager em, String nombre) {
		List<Pelicula> lista       = null;
		String      queryParam1    = "";
		Query       q              = null;
		try {
			queryParam1 = " Select a From Pelicula a Where lower(a.nombre) like concat('%',concat(?1,'%')) order by a.id desc ";
			q           = em.createQuery(queryParam1);
			q.setParameter(1, nombre.toLowerCase());
			lista       = q.getResultList();	
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.getListByNombre() <br/> "+ex.getMessage(),ex);
		}
		 
		return lista;
	}

	@Override
	public List<Pelicula> getListAll(EntityManager em) {
		List<Pelicula> lista    = null;
		Query       q           = null;
		try {
			q     = em.createNamedQuery("Pelicula.findAll");
			lista = q.getResultList();	
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoImpl.getListAll() <br/> "+ex.getMessage(),ex);
		}
		return lista;
	}

}
