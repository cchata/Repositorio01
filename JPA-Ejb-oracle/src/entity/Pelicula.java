package entity;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.org.glassfish.external.arc.Taxonomy;

import java.util.Date;


/**
 * The persistent class for the PELICULA database table.
 * 
 */
@Entity
@Table(name="PELICULA",schema="USUCCHATA")
@NamedQuery(name="Pelicula.findAll", query="SELECT p FROM Pelicula p order by p.id desc ")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PELICULA_ID_GENERATOR", sequenceName="SEC_IDPELICULA",schema="USUCCHATA", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PELICULA_ID_GENERATOR")
	@Column(name="id")
	private int id;

	@Column(name="estreno")
	@Temporal(TemporalType.DATE)
	private Date estreno;

	@Column(name="nombre")
	private String nombre;

	//bi-directional many-to-one association to Actor
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ACTOR")
	private Actor actor;

	public Pelicula() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEstreno() {
		return this.estreno;
	}

	public void setEstreno(Date estreno) {
		this.estreno = estreno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}