package com.aprendemosjsf.model;

// Generated 25-sep-2016 17:02:05 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Rol generated by hbm2java
 */
@Entity
@Table(name = "rol", catalog = "aprendiendojsf")
public class Rol implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Boolean estado;
	private Set<Rolmenu> rolmenus = new HashSet<Rolmenu>(0);
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Rol() {
	}

	public Rol(String nombre) {
		this.nombre = nombre;
	}

	public Rol(String nombre, String descripcion, Boolean estado,
			Set<Rolmenu> rolmenus, Set<Usuario> usuarios) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.rolmenus = rolmenus;
		this.usuarios = usuarios;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nombre", nullable = false, length = 30)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion", length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "estado")
	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Rolmenu> getRolmenus() {
		return this.rolmenus;
	}

	public void setRolmenus(Set<Rolmenu> rolmenus) {
		this.rolmenus = rolmenus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}