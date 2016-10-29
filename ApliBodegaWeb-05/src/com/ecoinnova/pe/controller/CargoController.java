package com.ecoinnova.pe.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import com.ecoinnova.pe.model.TbCargoEntity;
import com.ecoinnova.pe.model.TbEmpleadoEntity;
import com.ecoinnova.pe.services.interfaces.TbCargoServices;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class CargoController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbCargoServices}")
	TbCargoServices   tbCargoServices;
	
    
	public CargoController(){
		MyUtil.systemOutPrintln("Llamando constructor CargoController()");
//		listaCargo = cargarListaCargo();
	}
	
	
	private TbCargoEntity       cargoBean;
	private List<TbCargoEntity> listaCargo;
	private TbCargoEntity       cargoBeanSelect;
	
	public TbCargoEntity getCargoBean() {
		return cargoBean;
	}
	public void setCargoBean(TbCargoEntity cargoBean) {
		this.cargoBean = cargoBean;
	}
	
	
		
    public void updateCargo() {
        String msg;
        try {
        	    tbCargoServices.updateCargo(cargoBeanSelect);
                msg = "Se modific� correctamente el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
                RequestContext.getCurrentInstance().update("growls");
                RequestContext.getCurrentInstance().execute("PF('dialogUsuarioUpdate').hide()");
                
		} catch (Exception e) {
			 msg = ""+e.getMessage();
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error update", msg);
             FacesContext.getCurrentInstance().addMessage(null, message);
             RequestContext.getCurrentInstance().update("messages");
             RequestContext.getCurrentInstance().execute("PF('dialogUsuarioUpdate').hide()");
		}
    }

    public void deleteCargo(){
    	String msg;
    	try {
    		tbCargoServices.deleteCargo(cargoBeanSelect);
//    		tbCargoServices.delete(cargoBeanSelect);
    		msg = "Se elimin� correctamente el registro.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("growls");
            RequestContext.getCurrentInstance().execute("PF('dialogUsuarioDelete').hide()");
			
		} catch (Exception e) {
//			msg = ""+e.getMessage();
			msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
			msg +=e.getCause()!=null?"Causa: "+e.getMessage()+"":"";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error delete", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().execute("PF('dialogUsuarioDelete').hide()");
		}
    }
	
	
	
    public void createCargo(){
    	String msg;
    	try {
    		tbCargoServices.insertCargo(cargoBean);
    		msg = "Se cre� correctamente el registro.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cargo", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("growls");
            RequestContext.getCurrentInstance().execute("PF('dlgCargoCreate').hide()");
			
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error insert", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().execute("PF('dlgCargoCreate').hide()");
		}finally{
			cargoBean  = new TbCargoEntity();
    		RequestContext.getCurrentInstance().update("formCreate");
		}
    }
	
	
    
    
    public boolean cargarListaCargo(){
    	MyUtil.systemOutPrintln("Llamando cargarListaCargo()");
    	String msg;
    	try {
    		listaCargo = tbCargoServices.findAllCargo();
    		msg = "Lista cargada";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Lista", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
//            RequestContext.getCurrentInstance().update("growls");
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error cargar lista", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("messages");
		}
    	return true;
    }
	
	
	
	public List<TbCargoEntity> getListaCargo() {
		MyUtil.systemOutPrintln("Llamando getListaCargo()");
//		cargarListaCargo();
		return listaCargo;
	}
	public void setListaCargo(List<TbCargoEntity> listaCargo) {
		this.listaCargo = listaCargo;
	}

	
	public void addSelectedCargo(TbCargoEntity cargo){
		cargoBeanSelect = cargo;
	}
	
	
	
	public TbCargoEntity getCargoBeanSelect() {
		return cargoBeanSelect;
	}
	public void setCargoBeanSelect(TbCargoEntity cargoBeanSelect) {
		this.cargoBeanSelect = cargoBeanSelect;
	}
	
	
	public void setTbCargoServices(TbCargoServices tbCargoServices) {
		this.tbCargoServices = tbCargoServices;
	}
	
	public void generarCodigoCargo(){
		
		try {
			cargoBean  = new TbCargoEntity();
			cargoBean.setCodigoCar(tbCargoServices.generarCodigoCargo());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			
		}finally{
			RequestContext.getCurrentInstance().update("formCreate:txtCodigoCar");
		}
//		System.out.println("cargoBean.getCodigoCar()=  "+cargoBean.getCodigoCar());
	}
	
	public void onRowSelectCargo(SelectEvent event){
		cargoBeanSelect = ((TbCargoEntity) event.getObject());
		RequestContext.getCurrentInstance().update("formUpdate");
//		RequestContext.getCurrentInstance().update("formUpdate:txtIdCargo");
	}
}