/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.controlador.formbeans;

import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

/**
 *
 * @author Dios salva
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    private String nombreUsuario;
    private String password;

    public LoginFormBean() {
    }

    public void validarUsuario(){
        String      resultado  = null;
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario     usuario    = usuarioDAO.validarUsuario(nombreUsuario, password);
        boolean     loggedIn   = false;
        String      ruta       = "";
        FacesMessage facesMessage = null;
        if(usuario!=null){
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario valido", "Iniciando sesion");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
//            resultado = "menu?faces-redirect=true";
            loggedIn = true;
            ruta =iniciarSesion()+"/faces/menu.xhtml";
        }else{
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales Invalidas", "Credenciales Invalidas");
        }   
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        RequestContext.getCurrentInstance().addCallbackParam("loggedIn", loggedIn);
        RequestContext.getCurrentInstance().addCallbackParam("view", ruta);
//        return resultado;
    
    }
    public String getNombreUsuarioValidado(){
        Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getNombreUsuario();
    }
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesion Cerrada", "Sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        
        String resultado = "/index?faces-redirect=true";
        return resultado;
    }
    
    public boolean verificarSesion(){
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")!=null){
            sesionValida=true;
        }
        return sesionValida;
    }
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String iniciarSesion(){
    	//Devuelve: /Veterinaria02
    	return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }
}
