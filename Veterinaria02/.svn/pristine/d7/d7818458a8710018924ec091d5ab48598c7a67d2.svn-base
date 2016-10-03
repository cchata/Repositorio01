/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.controlador.formbeans;

import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.controlador.beans.UsuarioBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dios salva
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean implements Serializable{
    @ManagedProperty(value = "#{usuarioBean}")
    private UsuarioBean usuarioBean;

    public UsuarioFormBean() {
    }
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    
    
    public void actualizarDatos(){
    	
    	try {
    		usuarioBean.getUsuario().getPersona().setEstado(true);
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            usuarioDAO.modificar(usuarioBean.getUsuario());
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos actualizados", "Datos actualizados");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
        
        
    }

    
}
