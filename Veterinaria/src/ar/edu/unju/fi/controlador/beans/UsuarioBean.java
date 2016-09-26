/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.controlador.beans;

import ar.edu.unju.fi.apu.dao.IUsuarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.UsuarioDAOImp;
import ar.edu.unju.fi.apu.modelo.dominio.Persona;
import ar.edu.unju.fi.apu.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dios salva
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        Usuario usuarioSesion = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if (usuarioSesion != null) {
            String nombreUsuario = usuarioSesion.getNombreUsuario();
            IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
            usuario = usuarioDAO.obtenerUsuario(nombreUsuario);
            if (usuario.getPersona() == null) {
                usuario.setPersona(new Persona());
            }
        }
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
