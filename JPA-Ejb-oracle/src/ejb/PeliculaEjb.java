package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import entity.Actor;
import entity.Pelicula;
import exception.DataBaseException;

@Local
public interface PeliculaEjb {
	public List<Pelicula> buscarPorNombre(String nombre);
	public boolean  insertPelicula(Pelicula pelicula);
	public boolean  deletePelicula(Pelicula pelicula);
	public boolean  updatePelicula(Pelicula pelicula);
	public List<Pelicula> listarAll();

}
