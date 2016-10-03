/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.controlador.formbeans;

import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.dao.imp.mysql.PropietarioDAOImp;
import ar.edu.unju.fi.apu.dao.imp.ram.TablaPropietarios;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import ar.edu.unju.fi.controlador.beans.PropietarioBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Dios salva
 */
@ManagedBean
@ViewScoped
public class PropietarioFormBean implements Serializable{
    @ManagedProperty(value = "#{propietarioBean}")
    private PropietarioBean propietarioBean;
    
    
    private List<Propietario> propietariosFiltrados;
    
    public void actualizarPropietario(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        propietarioDAO.modificar(propietarioBean.getPropietario());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación concretada", "Operación exitosa"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificacionPropietario').hide();PF('modificacionPropietario').hide()");
        
    }
    
    public void establecerPropietario(Propietario propietario){
        propietarioBean.setPropietario(propietario);
    }
    
    public Date getFechaActual(){
        return new Date(System.currentTimeMillis());
    }
    
    public void grabarNuevoPropietario(){
    	
    	try {
    		IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
            System.out.println(" Apellido:  "+propietarioBean.getPropietario().getApellido());
            System.out.println(" Direccion: "+propietarioBean.getPropietario().getDireccion());
            System.out.println(" DNI:       "+propietarioBean.getPropietario().getDni());
            System.out.println(" Nombres:   "+propietarioBean.getPropietario().getNombres());
            System.out.println(" Telefono:  "+propietarioBean.getPropietario().getTelefono());
            System.out.println(" FechaNaci: "+propietarioBean.getPropietario().getFechaNacimiento());
            
            propietarioDAO.crear(propietarioBean.getPropietario());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion concretada", "Operacion exitosa"));
            RequestContext.getCurrentInstance().execute("PF('confirmaAltaPropietario').hide();PF('altaPropietario').hide()");
			
		} catch (Exception e) {
            System.out.println(e.getMessage());
		}
    	
        
        
    }
    
    public void modificarPropietario(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        propietarioDAO.modificar(propietarioBean.getPropietario());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación concretada", "Operación exitosa"));
        RequestContext.getCurrentInstance().execute("PF('confirmaModificacionPropietario').hide();PF('modificacionPropietario').hide()");
        
    }
    
    public List<Propietario> obtenerPropietarios(){
        IPropietarioDAO propietarioDAO = new PropietarioDAOImp();
        /*if(TablaPropietarios.tablaPropietarios == null){
            TablaPropietarios.llenarTabla();
        }*/
        return propietarioDAO.obtenerTodos();
    }
    
    public void visualizarVentanaConfirmaAlta(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaAltaPropietario').show();");
    }
    
    public void visualizarVentanaConfirmaModificacion(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confirmaModificacionPropietario').show();");
    }

    /**
     * Creates a new instance of PropietarioFormBean
     */
    public PropietarioFormBean() {
    }

    /**
     * @return the propietarioBean
     */
    public PropietarioBean getPropietarioBean() {
        return propietarioBean;
    }

    /**
     * @param propietarioBean the propietarioBean to set
     */
    public void setPropietarioBean(PropietarioBean propietarioBean) {
        this.propietarioBean = propietarioBean;
    }

    /**
     * @return the propietariosFiltrados
     */
    public List<Propietario> getPropietariosFiltrados() {
        return propietariosFiltrados;
    }

    /**
     * @param propietariosFiltrados the propietariosFiltrados to set
     */
    public void setPropietariosFiltrados(List<Propietario> propietariosFiltrados) {
        this.propietariosFiltrados = propietariosFiltrados;
    }

    
    
}
