package com.ecoinnova.pe.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.jasper.JasperException;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.ecoinnova.pe.jsf.util.Faces;
import com.ecoinnova.pe.model.TbClienteEntity;
import com.ecoinnova.pe.model.TbUsuarioEntity;
import com.ecoinnova.pe.services.interfaces.TbClienteServices;
import com.ecoinnova.pe.util.IReportManager;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class ClienteController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbClienteServices}")
	TbClienteServices   tbClienteServices;
	
	private TbClienteEntity       clienteBean;
	private TbClienteEntity       clienteBeanSelect;
	private List<TbClienteEntity> listaCliente;
	private StreamedContent filePdf;
	private boolean descargar;
	private String nombreReportePdf;
	public ClienteController(){
		MyUtil.systemOutPrintln("Llamando constructor ClienteController()");
		 clienteBean      = new TbClienteEntity();
		 descargar        = false;
		 nombreReportePdf = "reporteCliente.pdf";
		 
//		 InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/Jellyfish.jpg");
//			file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
	}	
	
	

	public boolean cargarListaCliente() throws Exception{
		
		String msg;
    	try {
    		MyUtil.systemOutPrintln("Llamando cargarListaCliente()");
    	
    		listaCliente = tbClienteServices.findAllCliente();
    		MyUtil.systemOutPrintln("listaCliente.size()= "+ listaCliente.size());
    		msg = "�Se recarg� Lista cliente!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
            
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar cliente", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().update("growls");
		}
    	return true;
	}
	
	
	public void onRowSelectCliente(SelectEvent event ){
		MyUtil.systemOutPrintln("Llamando onRowSelectCliente()");
    	clienteBeanSelect = (TbClienteEntity) event.getObject();
    	//Para que no se quede pegado cod, nombre del empleado
    	
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodigo");
    	RequestContext.getCurrentInstance().update("formUpdate:txtRUC");
    	RequestContext.getCurrentInstance().update("formUpdate:txtRazonS");
    	RequestContext.getCurrentInstance().update("formUpdate:txtDireccion");
    	
	}
	
	public void updateCliente(){
		try {
    		tbClienteServices.updateCliente(clienteBeanSelect);
    		String msg = "Se actualizo satisfactoriamente.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente", msg);
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
			resetCliente();
		}
	}
	
	public void resetCliente(){
    	MyUtil.systemOutPrintln("Llamando resetCliente()");
		clienteBean = new TbClienteEntity();
		clienteBeanSelect = null;
	}
	
    public void addSelectedDelete(TbClienteEntity obj){
    	clienteBeanSelect = obj;
    }
    
	public void deleteCliente(){
	    	try {
	    		tbClienteServices.deleteCliente(clienteBeanSelect);
	    		String msg = "Se elimin� satisfactoriamente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente", msg);
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
				resetCliente();
			}
	    }
	
	 public void generarCodigoCliente(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoCliente()");
	    	resetCliente();
	    	try {
	    		clienteBean.setCodigoCli(tbClienteServices.generarCodigoCliente());
	    		RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
	        	RequestContext.getCurrentInstance().update("formCreate:txtRUC");
	        	RequestContext.getCurrentInstance().update("formCreate:txtRazonS");
	        	RequestContext.getCurrentInstance().update("formCreate:txtDireccion");
			} catch (Exception e) {
				MyUtil.systemOutPrintln(e.getMessage()+"");
				MyUtil.systemOutPrintln(e.getCause()+"");
			}
	    }
	    
	    public boolean recargarListaCliente(){
	    	String msg;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando recargarListaCliente()");
	    		listaCliente = tbClienteServices.findAllCliente();
	    		msg = "�Recarga completa!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("formDataTable");
	            RequestContext.getCurrentInstance().update("growls");
	            
			} catch (Exception e) {
				msg = ""+e.getMessage();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar cliente", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().update("growls");
			}
	    	return true;
	    }
	    
	    public void createCliente(){
	    	
	    	try {
	    			tbClienteServices.insertCliente(clienteBean);
	    			String msg = "Se cre� correctamente el registro.";
	        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente", msg);
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
				resetCliente();
			}
	    }
	    
	    

	    
	    public void  exportarReportePdf() {
	    	descargar = true;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando a descargarReportePdf()");
	    		listaCliente = tbClienteServices.findAllCliente();
		    	
	            imprimirPDF(descargar);		    	
	            listaCliente.clear();	    		
		    	
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
	    		listaCliente = tbClienteServices.findAllCliente();
		    	imprimirPDF(descargar);
		    	
		    	if(filePdf == null){
		    		salida = false;
		    	}
		    	
		    	listaCliente.clear();
		    		
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
	    	listaCliente      = tbClienteServices.findAllCliente();
	    	
	    	ir.setJasperPrint("/resources/reporte/ClientesReport.jasper", param, new JRBeanCollectionDataSource(listaCliente));
//	    	ir.setJasperPrint("/resources/reporte/Ecoinnovareport1.jasper", param, new JRBeanCollectionDataSource(listaCliente));
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
	            if(listaCliente != null && listaCliente.size() >0) {
	                ir.setJasperPrint("/resources/reporte/ClientesReport.jasper", param, new JRBeanCollectionDataSource(listaCliente));
//	            	ir.setJasperPrint("/resources/reporte/Ecoinnovareport1.jasper", param, new JRBeanCollectionDataSource(listaCliente));
	            	if(descargar==false){//ViewReportPdf
	            		filePdf = ir.generateMediaPdf(nombreReportePdf);
	            	}else{
//	            		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/Jellyfish.jpg");
//	           			file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
//	            		file = new DefaultStreamedContent(stream, "application/pdf", "downloaded_optimus.pdf");
//	            		file = filePdf; //Opcion uno
//		                ir.exportarPDF(nombreReportePdf); //Opcion dos
	            		filePdf = ir.generateMediaPdf(nombreReportePdf);
	            	}
	            	RequestContext.getCurrentInstance().update("idFormReport:idMedia");
	                
	            }else {
	                Faces.addMessage("ERROR.!", "REPORTE VACIA!", FacesMessage.SEVERITY_ERROR);
	            } 
			} catch (Exception e) {
				e.printStackTrace();
				MyUtil.systemOutPrintln(""+e.getMessage());
				MyUtil.systemOutPrintln(""+e.getCause());
			}

	    }    	    
	    
	    
	    
	public TbClienteEntity getClienteBean() {
		return clienteBean;
	}
	public void setClienteBean(TbClienteEntity clienteBean) {
		this.clienteBean = clienteBean;
	}
	public List<TbClienteEntity> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<TbClienteEntity> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public TbClienteEntity getClienteBeanSelect() {
		return clienteBeanSelect;
	}
	public void setClienteBeanSelect(TbClienteEntity clienteBeanSelect) {
		this.clienteBeanSelect = clienteBeanSelect;
	}
	public void setTbClienteServices(TbClienteServices tbClienteServices) {
		this.tbClienteServices = tbClienteServices;
	}
	public StreamedContent getFilePdf() {
		return filePdf;
	}
	public void setFilePdf(StreamedContent filePdf) {
		this.filePdf = filePdf;
	}

}
