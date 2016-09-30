/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.controller;


import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.jsf.util.Faces;
import com.ecoinnova.pe.model.TbCliente;
import com.ecoinnova.pe.services.interfaces.TbClienteServices;

/**
 *
 * @author Max
 */
@ManagedBean(name="loginController")
@SessionScoped
public class LoginController implements Serializable {


	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{tbClienteServices}")
	TbClienteServices   tbClienteServices;
	
	 private Usuario usuarioBean;
	 private String  login; 
	 private String  contrasena;
	 private Integer idTipoPersona;
	 private String  nombreUsuario;
	 private String  urlImagen;
	 
	 
	public LoginController(){
		usuarioBean = new Usuario();
	}
	
	public TbClienteServices getTbClienteServices() {
		return tbClienteServices;
	}
	public void setTbClienteServices(TbClienteServices tbClienteServices) {
		this.tbClienteServices = tbClienteServices;
	}



	///////////////////////////////////
    public void logOut() throws ServletException, IOException, Exception {
    	Faces.removeSessionAttribute(Faces.ATTRIBUTE_CODIGO);
    	Faces.removeSessionAttribute(Faces.ATTRIBUTE_USER);
        Faces.logout();
        Faces.invalidateSession();
        Faces.redirect("login.xhtml");//No es necesario poner "faces/" porque esta configurado en web.xml para atender peticiones /face/*
//        Faces.redirect("faces/index.xhtml");
    }

    public void logIn() throws Exception {
//    	CLI0000003
        Usuario us = new Usuario();
        us.setClave(usuarioBean.getClave());
        us.setLogin(usuarioBean.getLogin());
        us.setC_menserro(null);
        
//        usuarioSistemasService.validarUsuario(us);
        
        if(tbClienteServices!=null){
        	System.out.println("tbClienteServices Ok. ");
        }else{
        	System.out.println("tbClienteServices Null. ");
        }
        TbCliente cliente = tbClienteServices.findById("CLI0000003");
        System.out.println("Codigo:       "+cliente.getCodigoCli());
        System.out.println("DNI:          "+cliente.getRucDniCli());
        System.out.println("Razon social: "+cliente.getRazonSocialCli());
        System.out.println("Direccion:    "+cliente.getDireccionCli());
        
        System.out.println("us.getC_menserro()= "+us.getC_menserro());
        if (us.getC_menserro() != null) {
            Faces.addMessage("ERROR.!", us.getC_menserro(), FacesMessage.SEVERITY_ERROR);
        } else {
        	us.setNombre("Carlos Chata");
        	us.setUrlImage("resources/foto/paisana-jacinta-2014-00.jpg");
            login         = us.getNombre();
            nombreUsuario = us.getNombre();
            urlImagen     = us.getUrlImage();
            
            Faces.addMessage("INGRESO", "Datos correctos...", FacesMessage.SEVERITY_INFO);
            Faces.setSessionAttribute(Faces.ATTRIBUTE_CODIGO, login);
            Faces.setSessionAttribute(Faces.ATTRIBUTE_USER, us);
            Faces.getRequestContext().addCallbackParam("estaLogeado", true);//cadena-valor jScript
//          Faces.getRequestContext().addCallbackParam("view", "faces/welcome.xhtml");//cadena-valor jScript
            Faces.getRequestContext().addCallbackParam("view", "faces/index.xhtml");//cadena-valor jScript
//          Faces.redirect("index.xhtml");
        }

    }

 

	public Usuario getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Integer getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	
	
}
