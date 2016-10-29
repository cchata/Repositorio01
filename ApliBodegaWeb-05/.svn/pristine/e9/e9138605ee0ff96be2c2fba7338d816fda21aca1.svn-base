package com.ecoinnova.pe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
import com.ecoinnova.pe.model.TbCargoEntity;
import com.ecoinnova.pe.model.TbEmpleadoEntity;
import com.ecoinnova.pe.services.interfaces.TbEmpleadoServices;
import com.ecoinnova.pe.util.IReportManager;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class EmpleadoController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbEmpleadoServices}")
	TbEmpleadoServices   tbEmpleadoServices;
    
    private TbEmpleadoEntity       empleadoBean;
	private List<TbEmpleadoEntity> listaEmpleado;
	private TbEmpleadoEntity       empleadoBeanSelect;
	private TbCargoEntity          cargoBeanSelect;
	private TbCargoEntity          cargoBean;
	private StreamedContent filePdf;
	private String nombreReportePdf;
	private boolean descargar;
	public EmpleadoController(){
		MyUtil.systemOutPrintln("Llamando constructor EmpleadoController()");
		cargoBean = new TbCargoEntity();
		empleadoBean = new TbEmpleadoEntity();
		descargar        = false;
		nombreReportePdf ="reporteEmpleado.pdf";
	}
	
	
	
	
	
	public TbCargoEntity getCargoBean() {
		return cargoBean;
	}
	public void setCargoBean(TbCargoEntity cargoBean) {
		this.cargoBean = cargoBean;
	}
	public TbEmpleadoEntity getEmpleadoBean() {
		return empleadoBean;
	}
	public void setEmpleadoBean(TbEmpleadoEntity empleadoBean) {
		this.empleadoBean = empleadoBean;
	}
	
		
    public TbCargoEntity getCargoBeanSelect() {
		return cargoBeanSelect;
	}
	public void setCargoBeanSelect(TbCargoEntity cargoBeanSelect) {
		this.cargoBeanSelect = cargoBeanSelect;
	}
	
	
	public void updateEmpleado() {
        String msg;
        
        try {
//        	    empleadoBeanSelect.setTbCargo(cargoBeanSelect);
        	    tbEmpleadoServices.updateEmpleado(empleadoBeanSelect);
                msg = "Se modificó correctamente el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Empleado", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
                RequestContext.getCurrentInstance().update("growls");
                RequestContext.getCurrentInstance().execute("PF('dialogEmpleadoUpdate').hide()");
                
		} catch (Exception e) {
			 msg = ""+e.getMessage();
             FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error update", msg);
             FacesContext.getCurrentInstance().addMessage(null, message);
             RequestContext.getCurrentInstance().update("messages");
             RequestContext.getCurrentInstance().execute("PF('dialogEmpleadoUpdate').hide()");
		}finally{
		    empleadoBeanSelect=null;
//            cargoBeanSelect=null;			
		}
    }

    public void deleteEmpleado(){
    	String msg;
    	try {
    		tbEmpleadoServices.deleteEmpleado(empleadoBeanSelect);
//    		tbCargoServices.delete(cargoBeanSelect);
    		msg = "Se eliminó correctamente el registro.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Empleado", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("growls");
            RequestContext.getCurrentInstance().execute("PF('dialogEmpleadoDelete').hide()");
            
			
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error delete", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().execute("PF('dialogEmpleadoDelete').hide()");
		}finally{
			empleadoBeanSelect = null;
		}
    }
	
	
	
    public void createEmpleado(){
    	String msg;
    	try {
    		
    		empleadoBean.setTbCargo(cargoBean);
    		
    		if(empleadoBean.getTbCargo().getCodigoCar() != null){
    		
//    			empleadoBean.setTbCargo(cargoBean);
        		tbEmpleadoServices.insertEmpleado(empleadoBean);
        		msg = "Se creó correctamente el registro.";
        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Empleado", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
                RequestContext.getCurrentInstance().update("growls");
                RequestContext.getCurrentInstance().execute("PF('dlgEmpleadoCreate').hide()");
                cargoBean = new TbCargoEntity();
				empleadoBean = new TbEmpleadoEntity();
	    		RequestContext.getCurrentInstance().update("formCreate");
                
    		}else{
    			msg = "Se necesita elegir un cargo.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validacion:", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
                RequestContext.getCurrentInstance().update("growls");
                return;
//                RequestContext.getCurrentInstance().execute("PF('dlgEmpleadoCreate').hide()");
    		}
    		
    		
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error insert", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().execute("PF('dlgEmpleadoCreate').hide()");
            
            cargoBean = new TbCargoEntity();
			empleadoBean = new TbEmpleadoEntity();
    		RequestContext.getCurrentInstance().update("formCreate");
		}
    }
	
	
    
    
    public boolean cargarListaEmpleado(){
		MyUtil.systemOutPrintln("Llamando constructor cargarListaEmpleado()");
    	
    	String msg;
    	try {
    		listaEmpleado = tbEmpleadoServices.findAllEmpleado();
//    		System.out.println("listaEmpleado.size()= "+listaEmpleado.size());
    		msg = "Lista cargada";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Lista Empleado", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("formDataTable");
//            RequestContext.getCurrentInstance().update("growls");
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error  lista Empleado", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
//            RequestContext.getCurrentInstance().update("messages");
		}
    	return true;
    }
	
	
	
	public List<TbEmpleadoEntity> getListaEmpleado() {
		MyUtil.systemOutPrintln("Llamando constructor getListaEmpleado()");
		return listaEmpleado;
	}
	public void setListaEmpleado(List<TbEmpleadoEntity> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	
	public void addSelectedEmpleado(TbEmpleadoEntity empleado){
		empleadoBeanSelect = empleado;
//		cargoBeanSelect = empleadoBeanSelect.getTbCargo();
	}
	
	public TbEmpleadoEntity getEmpleadoBeanSelect() {
		return empleadoBeanSelect;
	}
	public void setEmpleadoBeanSelect(TbEmpleadoEntity empleadoBeanSelect) {
		this.empleadoBeanSelect = empleadoBeanSelect;
	}
	
	
	public void setTbEmpleadoServices(TbEmpleadoServices tbEmpleadoServices) {
		this.tbEmpleadoServices = tbEmpleadoServices;
	}
	
	public void generarCodigoEmpleado(){
		
//		RequestContext.getCurrentInstance().update("formCreate");
//		RequestContext.getCurrentInstance().update("formUpdate:txtIdCargo");
//		RequestContext.getCurrentInstance().update("formUpdate:txtNombCargo");
//		RequestContext.getCurrentInstance().update("formCreate:txtIdCargo");
//		RequestContext.getCurrentInstance().update("formCreate:txtNombCargo");
		try {
			cargoBean = new TbCargoEntity();
			empleadoBean = new TbEmpleadoEntity();
			empleadoBean.setCodigoEmp((tbEmpleadoServices.generarCodigoEmpleado()));
			empleadoBean.setTbCargo(cargoBean);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
			RequestContext.getCurrentInstance().update("formCreate:txtIdCargo");
			RequestContext.getCurrentInstance().update("formCreate:txtNombCargo");			
		}
		
		
	}
	
	public void onRowSelectCargo(SelectEvent event){
//		this.cargoBeanSelect = carg;
		
		
		if(empleadoBeanSelect!=null){
			System.out.println("empleadoBeanSelect = ok");
//			cargoBean = ((TbCargoEntity) event.getObject());
//			RequestContext.getCurrentInstance().update("formUpdate:txtIdCargo");
//			RequestContext.getCurrentInstance().update("formUpdate:txtNombCargo");
			
//			RequestContext.getCurrentInstance().update("formUpdate");
//			cargoBean = ((TbCargoEntity) event.getObject());
//			RequestContext.getCurrentInstance().execute("PF('dialogEmpleadoUpdate').show()");
			cargoBeanSelect = ((TbCargoEntity) event.getObject());
			empleadoBeanSelect.setTbCargo(cargoBeanSelect);
			Collection<String> colUpdate = new HashSet<String>();
			colUpdate.add("formUpdate:txtIdCargo");
			colUpdate.add("formUpdate:txtNombCargo");
			RequestContext.getCurrentInstance().update(colUpdate);
			
		}else{
//			cargoBean = ((TbCargoEntity) event.getObject());
//			RequestContext.getCurrentInstance().update("formCreate:txtIdCargo");
//			RequestContext.getCurrentInstance().update("formCreate:txtNombCargo");
			
//			RequestContext.getCurrentInstance().update("formCreate");
//			cargoBean = ((TbCargoEntity) event.getObject());
//			RequestContext.getCurrentInstance().execute("PF('dlgEmpleadoCreate').show()");
			
			cargoBean = ((TbCargoEntity) event.getObject());
			empleadoBean.setTbCargo(cargoBean);
			Collection<String> colCreater = new HashSet<String>();
			colCreater.add("formCreate:txtIdCargo");
			colCreater.add("formCreate:txtNombCargo");
			RequestContext.getCurrentInstance().update(colCreater);

		}
	}

	public void  onRowSelectEmpleado(SelectEvent event){
		empleadoBeanSelect = ((TbEmpleadoEntity) event.getObject());
		RequestContext.getCurrentInstance().update("formUpdate");
		RequestContext.getCurrentInstance().update("formUpdate:txtIdCargo");
		RequestContext.getCurrentInstance().update("formUpdate:txtNombCargo");
	}
	
	public void resetEmpSelect(){
		MyUtil.systemOutPrintln("Llamando constructor resetEmpSelect()");
		empleadoBeanSelect = null;
}
	
    public void  exportarReportePdf() {
    	descargar = true;
    	try {
    		MyUtil.systemOutPrintln("Llamando a descargarReportePdf()");
    		listaEmpleado = tbEmpleadoServices.findAllEmpleado();
	    	
            imprimirPDF(descargar);		    	
            listaEmpleado.clear();	    		
	    	
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
    		listaEmpleado = tbEmpleadoServices.findAllEmpleado();
	    	imprimirPDF(descargar);
	    	
	    	if(filePdf == null){
	    		salida = false;
	    	}
	    	
	    	listaEmpleado.clear();
	    		
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
    	listaEmpleado = tbEmpleadoServices.findAllEmpleado();
    	
    	ir.setJasperPrint("/resources/reporte/EmpleadosReport.jasper", param, new JRBeanCollectionDataSource(listaEmpleado));
    	filePdf = ir.generateMediaPdf(nombreReportePdf);
    	
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion", "Se actualizó satisfactoriamente");
        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("idFormReport:idMedia");
        RequestContext.getCurrentInstance().update("growls");
    }
    
    
  
    
    

    public void imprimirPDF(boolean descargar) throws JasperException, IOException {
    	IReportManager      ir    = new IReportManager(null);
    	Map<String, Object> param = null;

    	try {
            if(listaEmpleado != null && listaEmpleado.size() >0) {
                ir.setJasperPrint("/resources/reporte/EmpleadosReport.jasper", param, new JRBeanCollectionDataSource(listaEmpleado));
            	if(descargar==false){//ViewReportPdf
            		filePdf = ir.generateMediaPdf(nombreReportePdf);
		            RequestContext.getCurrentInstance().update("idFormReport:idMedia");
            	}else{
//            		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/images/Jellyfish.jpg");
//           			file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
//            		file = new DefaultStreamedContent(stream, "application/pdf", "downloaded_optimus.pdf");
//            		file = filePdf; //Opcion uno
//	                ir.exportarPDF(nombreReportePdf); //Opcion dos	            		
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




	public StreamedContent getFilePdf() {
		return filePdf;
	}
	public void setFilePdf(StreamedContent filePdf) {
		this.filePdf = filePdf;
	}






    
    
}
