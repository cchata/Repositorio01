package ejbimpl;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import dao.PeliculaDao;
import daoimpl.PeliculaDaoImpl;
import ejb.PeliculaEjb;
import entity.Pelicula;
import exception.DataBaseException;
@Stateless
public class PeliculaEjbImpl implements PeliculaEjb {
	private EntityManagerFactory emf = null;
	private EntityManager        em  = null;
	private EntityTransaction    et  = null;
	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		List<Pelicula> lista = null;
		try {
			PeliculaDao peliculaDao = new PeliculaDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			lista = peliculaDao.getListByNombre(em, nombre);
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.buscarPorNombre() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
		}
		return lista;
	}

	@Override
	public boolean insertPelicula(Pelicula pelicula) {
		boolean mensaje = false;
		try {
			PeliculaDao peliculaDao = new PeliculaDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			
			et.begin();
			peliculaDao.insert(em, pelicula);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.insertActor() <br/> "+ex.getMessage(),ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.insertActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.insertActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public boolean deletePelicula(Pelicula pelicula) {
		boolean mensaje = false;
		try {
			PeliculaDao peliculaDao = new PeliculaDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			et.begin();
			peliculaDao.delete(em, pelicula);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaDaoEjbImpl.deleteActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public boolean updatePelicula(Pelicula pelicula) {
		boolean mensaje = false;
		try {
			PeliculaDao peliculaDao = new PeliculaDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			et    = em.getTransaction();
			et.begin();
			peliculaDao.update(em, pelicula);
			et.commit();
			
		} catch (PersistenceException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}catch (EJBException ex) {
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}catch (Exception ex) {
			if(et!=null){et.rollback();}
			mensaje = false;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.updateActor() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
			et = null;
		}
		return mensaje;
	}

	@Override
	public List<Pelicula> listarAll() {
		List<Pelicula> lista = null;
		try {
			PeliculaDao peliculaDao = new PeliculaDaoImpl();
			emf   = Persistence.createEntityManagerFactory("JPA-Ejb-oracle");
			em    = emf.createEntityManager();
			lista = peliculaDao.getListAll(em);
		} catch (Exception ex) {
			lista = null;
			throw new DataBaseException(ex.getClass()+" <br/>PeliculaEjbImpl.listarAll() <br/> "+ex.getMessage(),ex);
		}finally{
			if(em!=null){em.close();}
			if(emf!=null){emf.close();}
		}
		return lista;
	}

}
