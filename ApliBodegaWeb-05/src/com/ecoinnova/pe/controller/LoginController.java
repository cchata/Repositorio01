/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.controller;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.jsf.util.Faces;
import com.ecoinnova.pe.services.interfaces.TbCargoServices;
import com.ecoinnova.pe.services.interfaces.TbUsuarioServices;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class LoginController implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario    usuario;
    private String     ruta = null;
    
    @ManagedProperty("#{tbUsuarioServices}")
  	TbUsuarioServices   tbUsuarioServices;
    
    public LoginController() {
    	MyUtil.systemOutPrintln("Llamando constructor LoginController()");
    	 usuario = new Usuario();
    	
//        if (usuario == null) {
//            usuario = new Usuario();
//            usuario.setLogin("cchata");
//            usuario.setClave("root");
//            usuario.setNombre("Carlos Chata");
//            usuario.setCodigo("42863384");
//        }
    }

   
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  

    public void login() throws Exception {  
    	
    	MyUtil.systemOutPrintln("Llamando login() --1--");
        FacesMessage msg;  
        boolean      loggedIn = false; 
        ruta = null;
        
        tbUsuarioServices.validarUsuario(usuario);
        MyUtil.systemOutPrintln("Llamando login() --2--");
        MyUtil.systemOutPrintln("usuario.getC_menserro()= "+usuario.getC_menserro());
        if(usuario.getC_menserro() == null) { 
            loggedIn = true; 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(Faces.ATTRIBUTE_USER, usuario);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido","Usuario: "+ usuario.getNombreEmpleado());
//          ruta = "/AprendiendoJSF-04/faces/views/index.xhtml";
            ruta = MyUtil.nombreApp()+""+MyUtil.servletPath()+"/views/index.xhtml";
//            ruta = MyUtil.nombreApp()+""+"/views/index.xhtml";
            System.out.println("ruta= "+ruta);
            
            FacesContext.getCurrentInstance().addMessage(null, msg);
            RequestContext.getCurrentInstance().addCallbackParam("loggedIn", loggedIn);
            RequestContext.getCurrentInstance().addCallbackParam("view", ruta);

        } else {  
//            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario y/o Clave es incorrecto.");
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", usuario.getC_menserro());
            FacesContext.getCurrentInstance().addMessage(null, msg);
//            ruta = MyUtil.nombreApp()+""+MyUtil.servletPath()+"/login.xhtml";
            if (usuario == null) {
                usuario = new Usuario();
            }
        }  
    }

    public void logout()
    {
    	usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Faces.ATTRIBUTE_USER);
//    	       ruta = /AprendiendoJSF-04/faces/login.xhtml
        ruta = MyUtil.nombreApp()+""+MyUtil.servletPath()+"/login.xhtml";
//    	ruta = MyUtil.nombreApp()+""+"/login.xhtml";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cerrando sesion", "Usuario: "+usuario.getNombreEmpleado()));
        
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        sesion.invalidate();
        
        RequestContext.getCurrentInstance().addCallbackParam("loggetOut", true);  
        RequestContext.getCurrentInstance().addCallbackParam("view", ruta);
    }

    public boolean verificarSesion(){
    	MyUtil.systemOutPrintln("Llamando constructor verificarSesion()");
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Faces.ATTRIBUTE_USER)!=null){
            return true;
        }
        return false;
    }
	public String nombreUsuario() {
		
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Faces.ATTRIBUTE_USER)!=null){
			return ((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Faces.ATTRIBUTE_USER)).getNombreEmpleado();	
		}
		
		return null;
	}



	public void setTbUsuarioServices(TbUsuarioServices tbUsuarioServices) {
		this.tbUsuarioServices = tbUsuarioServices;
	}

	
	
	

    
}