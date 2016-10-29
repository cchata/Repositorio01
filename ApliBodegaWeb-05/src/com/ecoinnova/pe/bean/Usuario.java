/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.bean;

import java.io.Serializable;

/**
 *
 * @author operator
 */
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    //////DATOS DE ENTRADA
    private String login;
    private String clave;
    ///////DATOS DE SALIDA
    private String c_menserro;
    private String urlImage;
    private String codigoEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
   


    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getC_menserro() {
        return c_menserro;
    }

    public void setC_menserro(String c_menserro) {
        this.c_menserro = c_menserro;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

    
}
