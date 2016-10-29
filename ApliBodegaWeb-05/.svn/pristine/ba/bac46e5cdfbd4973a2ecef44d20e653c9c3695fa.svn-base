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

import com.ecoinnova.pe.model.TbUnidadMedidaEntity;
import com.ecoinnova.pe.services.interfaces.TbUnidadMedidaServices;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class UnidadMedidaController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbUnidadMedidaServices}")
    TbUnidadMedidaServices   tbUnidadMedidaServices;
	
	private TbUnidadMedidaEntity       unidadMedidaBean;
	private TbUnidadMedidaEntity       unidadMedidaBeanSelect;
	private List<TbUnidadMedidaEntity> unidadMedidaList;

	public UnidadMedidaController(){
		MyUtil.systemOutPrintln("Llamando constructor UnidadMedidaController()");
		unidadMedidaBean = new TbUnidadMedidaEntity();
	}	
	
	
//	private String codigoUni;
//	private String nombreUni;
//	private String descripcionUni;
//	
	public boolean cargarListaUnidadMedida() throws Exception{
		
		String msg;
    	try {
    		MyUtil.systemOutPrintln("Llamando cargarListaUnidadMedida()");
    	
    		unidadMedidaList = tbUnidadMedidaServices.findAllUnidadMedida();
    		
    		msg = "¡Lista UnidadMedida completa!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"UnidadMedida", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
            
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar UnidadMedida", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().update("growls");
		}
    	return true;
	}
	
	
	public void onRowSelectUnidadMedida(SelectEvent event ){
		MyUtil.systemOutPrintln("Llamando onRowSelectUnidadMedida()");
    	unidadMedidaBeanSelect = (TbUnidadMedidaEntity) event.getObject();
    	//Para que no se quede pegado cod, nombre del empleado
        
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodigo");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombre");
    	RequestContext.getCurrentInstance().update("formUpdate:txtDescripcion");
    	
	}
	
	public void updateUnidadMedida(){
		try {
    		tbUnidadMedidaServices.updateUnidadMedida(unidadMedidaBeanSelect);
    		String msg = "Se actualizo satisfactoriamente.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"UnidadMedida", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
    		RequestContext.getCurrentInstance().update("formDataTable");
    		RequestContext.getCurrentInstance().update("growls");
    		RequestContext.getCurrentInstance().execute("PF('dlgUpdate').hide()");
    		
		} catch (Exception e) {
			String msg = "";
			msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
			msg +=e.getCause()!=null?"Causa: "+e.getCause()+"":"";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Update", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().execute("PF('dlgUpdate').hide()");
		}finally{
			resetUnidadMedida();
		}
	}
	
	public void resetUnidadMedida(){
    	MyUtil.systemOutPrintln("Llamando resetUnidadMedida()");
		unidadMedidaBean = new TbUnidadMedidaEntity();
		unidadMedidaBeanSelect = null;
	}
	
    public void addSelectedDelete(TbUnidadMedidaEntity obj){
    	unidadMedidaBeanSelect = obj;
    }
    
	public void deleteUnidadMedida(){
	    	try {
	    		tbUnidadMedidaServices.deleteUnidadMedida(unidadMedidaBeanSelect);
	    		String msg = "Se eliminó satisfactoriamente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"UnidadMedida", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    		RequestContext.getCurrentInstance().update("formDataTable");
	    		RequestContext.getCurrentInstance().update("growls");
	    		RequestContext.getCurrentInstance().execute("PF('dlgDelete').hide()");
			} catch (Exception e) {
				String msg = "";
				msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
				msg +=e.getCause()!=null?"Causa: "+e.getCause()+"":"";
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Delete", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().execute("PF('dlgDelete').hide()");
			}finally{
				resetUnidadMedida();
			}
	    }
	
	 public void generarCodigoUnidadMedida(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoUnidadMedida()");
	    	resetUnidadMedida();
	    	try {
	    		unidadMedidaBean.setCodigoUni(tbUnidadMedidaServices.generarCodigoUnidadMedida());
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombre");
	        	RequestContext.getCurrentInstance().update("formCreate:txtDescripcion");

			} catch (Exception e) {
				MyUtil.systemOutPrintln(e.getMessage()+"");
				MyUtil.systemOutPrintln(e.getCause()+"");
			}
	    }
	    
	    public boolean recargarListaUnidadMedida(){
	    	String msg;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando recargarListaUnidadMedida()");
	    		unidadMedidaList = tbUnidadMedidaServices.findAllUnidadMedida();
	    		msg = "¡Recarga completa!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"UnidadMedida", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("formDataTable");
	            RequestContext.getCurrentInstance().update("growls");
	            
			} catch (Exception e) {
				msg = ""+e.getMessage();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar UnidadMedida", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().update("growls");
			}
	    	return true;
	    }
	    
	    public void createUnidadMedida(){
	    	
	    	try {
	    			tbUnidadMedidaServices.insertUnidadMedida(unidadMedidaBean);
	    			String msg = "Se creó correctamente el registro.";
	        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"UnidadMedida", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	        		RequestContext.getCurrentInstance().update("formDataTable");
	        		RequestContext.getCurrentInstance().update("growls");
	        		RequestContext.getCurrentInstance().execute("PF('dlgCreate').hide()");
	    		
			} catch (Exception e) {
				String msg = "";
				msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
				msg +=e.getCause()!=null?"Causa: "+e.getCause()+"":"";
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error insert", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().execute("PF('dlgCreate').hide()");
			}finally{
				resetUnidadMedida();
			}
	    }



		public TbUnidadMedidaEntity getunidadMedidaBean() {
			return unidadMedidaBean;
		}



		public void setunidadMedidaBean(TbUnidadMedidaEntity unidadMedidaBean) {
			this.unidadMedidaBean = unidadMedidaBean;
		}



		public TbUnidadMedidaEntity getunidadMedidaBeanSelect() {
			return unidadMedidaBeanSelect;
		}



		public void setunidadMedidaBeanSelect(TbUnidadMedidaEntity unidadMedidaBeanSelect) {
			this.unidadMedidaBeanSelect = unidadMedidaBeanSelect;
		}



		public List<TbUnidadMedidaEntity> getunidadMedidaList() {
			return unidadMedidaList;
		}



		public void setunidadMedidaList(List<TbUnidadMedidaEntity> unidadMedidaList) {
			this.unidadMedidaList = unidadMedidaList;
		}



		public void setTbUnidadMedidaServices(TbUnidadMedidaServices tbUnidadMedidaServices) {
			this.tbUnidadMedidaServices = tbUnidadMedidaServices;
		}
	

	    
	
	
}
