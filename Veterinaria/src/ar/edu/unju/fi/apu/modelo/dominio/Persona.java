package ar.edu.unju.fi.apu.modelo.dominio;
// Generated 19/05/2015 14:55:05 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private String dni;
     private String apellido;
     private String nombres;
     private Date fechaNacimiento;
     private boolean estado;

    public Persona() {
    }

    public Persona(String dni, String apellido, String nombres, Date fechaNacimiento, boolean estado) {
       this.dni = dni;
       this.apellido = apellido;
       this.nombres = nombres;
       this.fechaNacimiento = fechaNacimiento;
       this.estado = estado;
    }
   
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }




}


