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

import com.ecoinnova.pe.model.TbMarcaEntity;
import com.ecoinnova.pe.services.interfaces.TbMarcaServices;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class MarcaController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbMarcaServices}")
    TbMarcaServices   tbMarcaServices;
	
	private TbMarcaEntity       marcaBean;
	private TbMarcaEntity       marcaBeanSelect;
	private List<TbMarcaEntity> marcaList;

	public MarcaController(){
		MyUtil.systemOutPrintln("Llamando constructor MarcaController()");
		marcaBean = new TbMarcaEntity();
	}	
	
	

	public boolean cargarListaMarca() throws Exception{
		
		String msg;
    	try {
    		MyUtil.systemOutPrintln("Llamando cargarListaMarca()");
    	
    		marcaList = tbMarcaServices.findAllMarca();
    		
    		msg = "�Lista Marca completa!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
            
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Marca", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().update("growls");
		}
    	return true;
	}
	
	
	public void onRowSelectMarca(SelectEvent event ){
		MyUtil.systemOutPrintln("Llamando onRowSelectMarca()");
    	marcaBeanSelect = (TbMarcaEntity) event.getObject();
    	//Para que no se quede pegado cod, nombre del empleado
        
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodigo");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombre");
    	RequestContext.getCurrentInstance().update("formUpdate:txtDescripcion");
    	
	}
	
	public void updateMarca(){
		try {
    		tbMarcaServices.updateMarca(marcaBeanSelect);
    		String msg = "Se actualizo satisfactoriamente.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca", msg);
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
			resetMarca();
		}
	}
	
	public void resetMarca(){
    	MyUtil.systemOutPrintln("Llamando resetMarca()");
		marcaBean = new TbMarcaEntity();
		marcaBeanSelect = null;
	}
	
    public void addSelectedDelete(TbMarcaEntity obj){
    	marcaBeanSelect = obj;
    }
    
	public void deleteMarca(){
	    	try {
	    		tbMarcaServices.deleteMarca(marcaBeanSelect);
	    		String msg = "Se elimin� satisfactoriamente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca", msg);
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
				resetMarca();
			}
	    }
	
	 public void generarCodigoMarca(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoMarca()");
	    	resetMarca();
	    	try {
	    		marcaBean.setCodigoMar(tbMarcaServices.generarCodigoMarca());
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombre");
	        	RequestContext.getCurrentInstance().update("formCreate:txtDescripcion");

			} catch (Exception e) {
				MyUtil.systemOutPrintln(e.getMessage()+"");
				MyUtil.systemOutPrintln(e.getCause()+"");
			}
	    }
	    
	    public boolean recargarListaMarca(){
	    	String msg;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando recargarListaMarca()");
	    		marcaList = tbMarcaServices.findAllMarca();
	    		msg = "�Recarga completa!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("formDataTable");
	            RequestContext.getCurrentInstance().update("growls");
	            
			} catch (Exception e) {
				msg = ""+e.getMessage();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Marca", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().update("growls");
			}
	    	return true;
	    }
	    
	    public void createMarca(){
	    	
	    	try {
	    			tbMarcaServices.insertMarca(marcaBean);
	    			String msg = "Se cre� correctamente el registro.";
	        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Marca", msg);
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
				resetMarca();
			}
	    }



		public TbMarcaEntity getMarcaBean() {
			return marcaBean;
		}



		public void setMarcaBean(TbMarcaEntity marcaBean) {
			this.marcaBean = marcaBean;
		}



		public TbMarcaEntity getMarcaBeanSelect() {
			return marcaBeanSelect;
		}



		public void setMarcaBeanSelect(TbMarcaEntity marcaBeanSelect) {
			this.marcaBeanSelect = marcaBeanSelect;
		}



		public List<TbMarcaEntity> getMarcaList() {
			return marcaList;
		}



		public void setMarcaList(List<TbMarcaEntity> marcaList) {
			this.marcaList = marcaList;
		}



		public void setTbMarcaServices(TbMarcaServices tbMarcaServices) {
			this.tbMarcaServices = tbMarcaServices;
		}
	

	    
	
	
}