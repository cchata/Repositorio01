/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import model.Usuario;



@ManagedBean(name="usuarioController")
//@ViewScoped
@SessionScoped
public class usuarioBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;  
    private Usuario selectedUsuario;
    private Usuario usuarioBean;
    
    @ManagedProperty(value="#{loginBean}")
    private loginBean loginbean;

    public usuarioBean() {
    	System.out.println("Llamando a constructor usuarioBean.");
        usuarios        = new ArrayList<Usuario>(); 
        selectedUsuario = new Usuario();
        usuarioBean     = new Usuario();
        if(usuarios!=null){
        	System.out.println(usuarios.size());	
        }else{
        	System.out.println("usuarios= "+usuarios);
        }
        
    }

    public List<Usuario> getUsuarios() {
    	System.out.println("Llamando lista usuario 1");
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        usuarios = usuarioDao.findAll();
        return usuarios;
    }
    
    public void addSelectedUsuario(Usuario usuario){
    	selectedUsuario = usuario;
    }
    

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void btnCreateUsuario(){
//    	oncomplete="dialogUsuarioCreate.hide()"
    	System.out.println("loginbean.getNombreUsuario()=  "+loginbean.getNombreUsuario());
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
//        Date hoy = new Date();
//        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(hoy);
//        usuarioBean.setFechacreacion(java.sql.Date.valueOf(fecha));
        usuarioBean.setFechacreacion(new java.util.Date());
        usuarioBean.setUsuariocreacion(loginbean.getNombreUsuario());
        System.out.println("usuarioBean.getEstado()= "+usuarioBean.getEstado());
        if (usuarioDao.create(usuarioBean)) {
            msg = "Se creeó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("dialogUsuarioCreate.hide();");
        } else {
            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void resetUsuario(){
    	usuarioBean = new Usuario();    	
    }
    public void btnUpdateUsuario()
    {
    	selectedUsuario.setUsuariomodificacion(loginbean.getNombreUsuario());
    	System.out.println("Estado= "+selectedUsuario.getEstado());
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        if (usuarioDao.update(this.selectedUsuario)) {
            msg = "Se modificó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al modificar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void btnDeleteUsuario()
    {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        if (usuarioDao.delete(this.selectedUsuario.getId())) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

	public Usuario getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public loginBean getLoginbean() {
		return loginbean;
	}

	public void setLoginbean(loginBean loginbean) {
		this.loginbean = loginbean;
	}

	
    
}
