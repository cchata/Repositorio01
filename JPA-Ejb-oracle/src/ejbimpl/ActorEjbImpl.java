package ejbimpl;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;


import dao.ActorDao;
import daoimpl.ActorDaoImpl;
import ejb.ActorEjb;
import entity.Actor;
import exception.DataBaseException;
@Stateless
public class ActorEjbImpl implements ActorEjb {

	private EntityManagerFactory emf = null;
	private EntityManager        em  = null;
	private EntityTransaction    et  = null;
	
	@Override
	public List<Actor> buscarPorNombre(String nombre){
		List<Actor> lista = null;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			lista = actorDao.getListByNombre(em, nombre);
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.buscarPorNombre() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
		}
		return lista;
	}

	@Override
	public boolean insertActor(Actor actor){
		boolean mensaje = false;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			et.begin();
			actorDao.insert(em, actor);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.insertActor() <br/> "+ex.getMessage()+"ALL"+ex.getLocalizedMessage()+"<br/>",ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.insertActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.insertActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public boolean deleteActor(Actor actor){
		boolean mensaje = false;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			et.begin();
			actorDao.delete(em, actor);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public boolean updateActor(Actor actor){
		boolean mensaje = false;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			et.begin();
			actorDao.update(em, actor);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public List<Actor> listarAll(){
			List<Actor> lista = null;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			lista = actorDao.getListAll(em);
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.listarAll() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
		}
		return lista;
	}

	@Override
	public Actor buscarPorId(int id) {
		Actor actor = null;
		try {
			ActorDao actorDao = new ActorDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			actor = actorDao.getById(em, id);
		} catch (Exception ex) {
			actor = null;
			throw new DataBaseException(ex.getClass()+" <br/>ActorEjbImpl.buscarPorNombre() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
		}
		return actor;	
		}

}
