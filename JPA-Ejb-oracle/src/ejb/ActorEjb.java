package ejb;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import entity.Actor;
import exception.DataBaseException;

@Local
public interface ActorEjb {
	public List<Actor> buscarPorNombre(String nombre);
	public boolean  insertActor(Actor actor);
	public boolean  deleteActor(Actor actor);
	public boolean  updateActor(Actor actor);
	public List<Actor> listarAll();
	public Actor buscarPorId(int id);

}
