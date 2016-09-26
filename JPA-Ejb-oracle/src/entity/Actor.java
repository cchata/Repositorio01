package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ACTOR database table.
 * 
 */
@Entity
@Table(name="Actor",schema="USUCCHATA")
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a order by a.id desc")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTOR_ID_GENERATOR", sequenceName="SEC_IDACTOR", schema="USUCCHATA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTOR_ID_GENERATOR")
	private int id;

	@Column(name="edad")
	private int edad;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="actor", targetEntity=Pelicula.class, fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	private List peliculas;

	public Actor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setActor(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setActor(null);

		return pelicula;
	}

}