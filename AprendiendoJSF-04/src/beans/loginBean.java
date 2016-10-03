/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import model.Usuario;

import org.primefaces.context.RequestContext;

import util.MyUtil;

/**
 *
 * @author lude
 */
@SessionScoped
@ManagedBean(name="loginBean")
public class loginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
    private UsuarioDao usuarioDao;
    private String nombreUsuario;
    public loginBean() {
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
        FacesMessage msg;  
        boolean loggedIn; 
        String ruta = "";
        this.usuario = this.usuarioDao.login(this.usuario);
        if(this.usuario != null) { 
        	nombreUsuario = usuario.getUsuario();
            loggedIn = true; 
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getUsuario());
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido","Usuario: "+ this.usuario.getUsuario());
            ruta = MyUtil.basepathlogin()+"views/inicio.xhtml";
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Usuario y/o Clave es incorrecto.");
            if (this.usuario == null) {
                this.usuario = new Usuario();
            }
        }  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        RequestContext.getCurrentInstance().addCallbackParam("loggedIn", loggedIn);  
        RequestContext.getCurrentInstance().addCallbackParam("view", ruta);
    }

    public void logout()
    {
        String ruta = MyUtil.basepathlogin()+"login.xhtml";
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext facesContext = FacesContext.getCurrentInstance();

        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(false);
        sesion.invalidate();
       
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cerrando sesion", "Usuario: "+this.usuario.getUsuario()));  
        
        RequestContext.getCurrentInstance().addCallbackParam("loggetOut", true);  
        RequestContext.getCurrentInstance().addCallbackParam("view", ruta);
    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
    
    
}