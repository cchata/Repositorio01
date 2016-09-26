package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.Actor;
import exception.DataBaseException;

public interface ActorDao {
	
	public boolean insert(EntityManager em, Actor actor);
	public boolean update(EntityManager em, Actor actor);
	public boolean delete(EntityManager em, Actor actor);
	public Actor getById(EntityManager em, int id);
	public List<Actor> getListByNombre(EntityManager em, String nombre);
	public List<Actor> getListAll(EntityManager em);
	

}
