package com.ecoinnova.pe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.jasper.JasperException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

import com.ecoinnova.pe.jsf.util.Faces;
import com.ecoinnova.pe.model.TbProveedorEntity;
import com.ecoinnova.pe.services.interfaces.TbProveedorServices;
import com.ecoinnova.pe.util.IReportManager;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class ProveedorController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbProveedorServices}")
    TbProveedorServices   tbProveedorServices;
	
	private TbProveedorEntity       proveedorBean;
	private TbProveedorEntity       proveedorBeanSelect;
	private List<TbProveedorEntity> proveedorList;
	private StreamedContent filePdf;
	private String nombreReportePdf;
	private boolean descargar;
	public ProveedorController(){
		MyUtil.systemOutPrintln("Llamando constructor ProveedorController()");
		proveedorBean = new TbProveedorEntity();
		descargar        = false;
		nombreReportePdf ="reporteProveedor.pdf";
	}	
	
	

	public boolean cargarListaProveedor() throws Exception{
		
		String msg;
    	try {
    		MyUtil.systemOutPrintln("Llamando cargarListaProveedor()");
    	
    		proveedorList = tbProveedorServices.findAllProveedor();
    		
    		msg = "�Lista Proveedor completa!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
            
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Proveedor", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().update("growls");
		}
    	return true;
	}
	
	
	public void onRowSelectProveedor(SelectEvent event ){
		MyUtil.systemOutPrintln("Llamando onRowSelectProveedor()");
    	proveedorBeanSelect = (TbProveedorEntity) event.getObject();
    	//Para que no se quede pegado cod, nombre del empleado
    	
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodigo");
    	RequestContext.getCurrentInstance().update("formUpdate:txtRUC");
    	RequestContext.getCurrentInstance().update("formUpdate:txtRazonS");
    	RequestContext.getCurrentInstance().update("formUpdate:txtDireccion");
    	RequestContext.getCurrentInstance().update("formUpdate:txtTelefono");
    	RequestContext.getCurrentInstance().update("formUpdate:txtEmail");
    	
	}
	
	public void updateProveedor(){
		try {
    		tbProveedorServices.updateProveedor(proveedorBeanSelect);
    		String msg = "Se actualizo satisfactoriamente.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor", msg);
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
			resetProveedor();
		}
	}
	
	public void resetProveedor(){
    	MyUtil.systemOutPrintln("Llamando resetProveedor()");
		proveedorBean = new TbProveedorEntity();
		proveedorBeanSelect = null;
	}
	
    public void addSelectedDelete(TbProveedorEntity obj){
    	proveedorBeanSelect = obj;
    }
    
	public void deleteProveedor(){
	    	try {
	    		tbProveedorServices.deleteProveedor(proveedorBeanSelect);
	    		String msg = "Se elimin� satisfactoriamente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor", msg);
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
				resetProveedor();
			}
	    }
	
	 public void generarCodigoProveedor(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoProveedor()");
	    	resetProveedor();
	    	try {
	    		proveedorBean.setCodigoProv(tbProveedorServices.generarCodigoProveedor());
	    		RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
	        	RequestContext.getCurrentInstance().update("formCreate:txtRUC");
	        	RequestContext.getCurrentInstance().update("formCreate:txtRazonS");
	        	RequestContext.getCurrentInstance().update("formCreate:txtDireccion");
	        	RequestContext.getCurrentInstance().update("formCreate:txtTelefono");
	        	RequestContext.getCurrentInstance().update("formCreate:txtEmail");
			} catch (Exception e) {
				MyUtil.systemOutPrintln(e.getMessage()+"");
				MyUtil.systemOutPrintln(e.getCause()+"");
			}
	    }
	    
	    public boolean recargarListaProveedor(){
	    	String msg;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando recargarListaProveedor()");
	    		proveedorList = tbProveedorServices.findAllProveedor();
	    		msg = "�Recarga completa!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("formDataTable");
	            RequestContext.getCurrentInstance().update("growls");
	            
			} catch (Exception e) {
				msg = ""+e.getMessage();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Proveedor", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().update("growls");
			}
	    	return true;
	    }
	    
	    public void createProveedor(){
	    	
	    	try {
	    			tbProveedorServices.insertProveedor(proveedorBean);
	    			String msg = "Se cre� correctamente el registro.";
	        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor", msg);
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
				resetProveedor();
			}
	    }

	    
	    public void  exportarReportePdf() {
	    	descargar = true;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando a descargarReportePdf()");
	    		proveedorList = tbProveedorServices.findAllProveedor();
		    	
	            imprimirPDF(descargar);		    	
	            proveedorList.clear();	    		
		    	
			} catch (Exception e) {
				System.out.println("e.getMessage()= "+e.getMessage());
				System.out.println("e.getCause()  = "+e.getCause());
			}
	    }
	    
	    public boolean  viewReportePdf() {
    		MyUtil.systemOutPrintln("Llamando a generarReporteView()");
	    	boolean salida = true;
	    	descargar      = false;
	    	filePdf          = null;
	    	try {
	    		proveedorList = tbProveedorServices.findAllProveedor();
		    	imprimirPDF(descargar);
		    	
		    	if(filePdf == null){
		    		salida = false;
		    	}
		    	
		    	proveedorList.clear();
		    		
			} catch (Exception e) {
				System.out.println("e.getMessage()= "+e.getMessage());
				System.out.println("e.getCause()  = "+e.getCause());
			}
	    	return salida;
	    }
	    
	    
	    public void refrescarReportePdf() throws Exception{
	    	MyUtil.systemOutPrintln("Llamando a refrescarReportePdf()");
	    	IReportManager      ir    = new IReportManager(null);
	    	Map<String, Object> param = null;
	    	proveedorList = tbProveedorServices.findAllProveedor();
	    	
	    	ir.setJasperPrint("/resources/reporte/ProveedorReport.jasper", param, new JRBeanCollectionDataSource(proveedorList));
	    	filePdf = ir.generateMediaPdf(nombreReportePdf);
	    	
	    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion", "Se actualiz� satisfactoriamente");
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("idFormReport:idMedia");
            RequestContext.getCurrentInstance().update("growls");
	    }
	    
	    
	  
	    
	    

	    public void imprimirPDF(boolean descargar) throws JasperException, IOException {
	    	IReportManager      ir    = new IReportManager(null);
        	Map<String, Object> param = null;

        	try {
	            if(proveedorList != null && proveedorList.size() >0) {
	                ir.setJasperPrint("/resources/reporte/ProveedorReport.jasper", param, new JRBeanCollectionDataSource(proveedorList));
	            	if(descargar==false){//ViewReportPdf
	            		filePdf = ir.generateMediaPdf(nombreReportePdf);
			            RequestContext.getCurrentInstance().update("idFormReport:idMedia");
	            	}else{
//	            		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/Jellyfish.jpg");
//	           			file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
//	            		file = new DefaultStreamedContent(stream, "application/pdf", "downloaded_optimus.pdf");
//	            		file = filePdf; //Opcion uno
//		                ir.exportarPDF(nombreReportePdf); //Opcion dos	            		
	            	}
	                
	            }else {
	                Faces.addMessage("ERROR.!", "REPORTE VACIA!", FacesMessage.SEVERITY_ERROR);
	            } 
			} catch (Exception e) {
				e.printStackTrace();
				MyUtil.systemOutPrintln(""+e.getMessage());
				MyUtil.systemOutPrintln(""+e.getCause());
			}

	    }    	

		public TbProveedorEntity getProveedorBean() {
			return proveedorBean;
		}
		public void setProveedorBean(TbProveedorEntity proveedorBean) {
			this.proveedorBean = proveedorBean;
		}
		public TbProveedorEntity getProveedorBeanSelect() {
			return proveedorBeanSelect;
		}
		public void setProveedorBeanSelect(TbProveedorEntity proveedorBeanSelect) {
			this.proveedorBeanSelect = proveedorBeanSelect;
		}
		public List<TbProveedorEntity> getProveedorList() {
			return proveedorList;
		}
		public void setProveedorList(List<TbProveedorEntity> proveedorList) {
			this.proveedorList = proveedorList;
		}
		public void setTbProveedorServices(TbProveedorServices tbProveedorServices) {
			this.tbProveedorServices = tbProveedorServices;
		}
		public StreamedContent getFilePdf() {
			return filePdf;
		}
		public void setFilePdf(StreamedContent filePdf) {
			this.filePdf = filePdf;
		}
	
	
}
