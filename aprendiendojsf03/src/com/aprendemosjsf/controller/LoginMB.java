package com.aprendemosjsf.controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.aprendemosjsf.model.Usuario;

import org.primefaces.context.RequestContext;

import com.aprendemosjsf.util.MyUtil;
import com.aprendemosjsf.dao.*;
import com.aprendemosjsf.daoimpl.*;

@SessionScoped
@ManagedBean(name="loginMB")
public class LoginMB implements Serializable {
	
	
	/**
	 * 
	 */
	private Usuario usuario;
    private UsuarioDao usuarioDao;
    private String user;
    private String pass;
    
    public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	public LoginMB() {
        this.usuarioDao = new UsuarioDaoImpl();
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
    public void login() {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg;  
        boolean loggedIn; 
        String ruta = "";
//        usuario.setUsuario(user);
//        usuario.setClave(pass);
        
        usuario = usuarioDao.login(usuario);
        if(usuario != null) {  
            loggedIn = true; 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsuario());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getUsuario());
            ruta = MyUtil.basepathlogin()+"views/inicio.xhtml";
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario y/o Clave es incorrecto.");
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }
        }  

        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
        context.addCallbackParam("ruta", ruta);
    }

    public void logout()
    {
        String ruta = MyUtil.basepathlogin()+"login.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();

        context.addCallbackParam("loggetOut", true);
        context.addCallbackParam("ruta", ruta);
    }
	

}
