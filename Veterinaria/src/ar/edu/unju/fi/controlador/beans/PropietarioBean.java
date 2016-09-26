/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.controlador.beans;

import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dios salva
 */
@ManagedBean
@ViewScoped
public class PropietarioBean implements Serializable{
    private Propietario propietario;

    /**
     * Creates a new instance of PropietarioBean
     */
    public PropietarioBean() {
        if(propietario==null){
            propietario = new Propietario();
        }
    }
    
    /**
     * @return the propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
}
