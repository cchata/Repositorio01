/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.aprendemosjsf.model.Usuario;


import com.aprendemosjsf.dao.*;
import com.aprendemosjsf.daoimpl.*;

import java.awt.event.ActionEvent;

@SessionScoped
@ManagedBean(name="usuarioBean")
public class usuarioBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;  
    private Usuario selectedUsuario; 

    public usuarioBean() {
        this.selectedUsuario = new Usuario();
        this.usuarios = new ArrayList<Usuario>(); 
    }

    public List<Usuario> getUsuarios() {
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        this.usuarios = usuarioDao.findAll();
        return usuarios;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public void btnCreateUsuario(ActionEvent actionEvent){
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        String msg;
        this.selectedUsuario.setClave(this.selectedUsuario.getUsuario());
        this.selectedUsuario.setUsuariocreacion("admin");
        Date hoy = new Date();
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(hoy);
        this.selectedUsuario.setFechacreacion(java.sql.Date.valueOf(fecha));
        if (usuarioDao.create(this.selectedUsuario)) {
            msg = "Se creo correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al crear el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void btnUpdateUsuario(ActionEvent actionEvent)
    {
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

    public void btnDeleteUsuario(ActionEvent actionEvent)
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
}
