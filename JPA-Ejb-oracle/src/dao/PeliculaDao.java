package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Pelicula;

public interface PeliculaDao {

	
	public boolean insert(EntityManager em, Pelicula pelicula);
	public boolean update(EntityManager em, Pelicula pelicula);
	public boolean delete(EntityManager em, Pelicula pelicula);
	public Pelicula getById(EntityManager em, int id);
	public List<Pelicula> getListByNombre(EntityManager em, String nombre);
	public List<Pelicula> getListAll(EntityManager em);

}
