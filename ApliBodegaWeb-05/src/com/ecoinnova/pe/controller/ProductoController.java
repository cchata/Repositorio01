package com.ecoinnova.pe.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
import com.ecoinnova.pe.model.TbCategoriaEntity;
import com.ecoinnova.pe.model.TbMarcaEntity;
import com.ecoinnova.pe.model.TbProductoEntity;
import com.ecoinnova.pe.model.TbProveedorEntity;
import com.ecoinnova.pe.model.TbUnidadMedidaEntity;
import com.ecoinnova.pe.services.interfaces.TbProductoServices;
import com.ecoinnova.pe.util.IReportManager;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class ProductoController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbProductoServices}")
    TbProductoServices   tbProductoServices;
	
	private TbProductoEntity       productoBean;
	private TbProductoEntity       productoBeanSelect;
	private List<TbProductoEntity> productoList;
	private StreamedContent filePdf;
	private boolean descargar;
	private String nombreReportePdf;
	
	public ProductoController(){
		MyUtil.systemOutPrintln("Llamando constructor ProductoController()");
		productoBean = new TbProductoEntity();
		productoList = new ArrayList<TbProductoEntity>();
		descargar        = false;
		nombreReportePdf = "reporteProductos.pdf";
	}	
	
	

	public boolean cargarListaProducto(){
		
		String msg;
		boolean salida = false;
    	try {
    		MyUtil.systemOutPrintln("Llamando cargarListaProducto()");
    	
    		productoList = tbProductoServices.findAllProducto();
    		
    		if(productoList.size()>0){
//        		msg = "�Lista Producto completa!";
        		msg = "�Recarga lista producto completa!";
        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
//                RequestContext.getCurrentInstance().update("formDataTable");
                salida = true;
    		}else{
//        		msg = "�Lista Producto completa!";
        		msg = "�Lista producto vacia!";
        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
                FacesContext.getCurrentInstance().addMessage(null, message);
//                RequestContext.getCurrentInstance().update("formDataTable");
                salida = false;
    		}
    		
    		

            
		} catch (Exception e) {
			msg = ""+e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Producto", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("messages");
            RequestContext.getCurrentInstance().update("growls");
            salida = false;
		}
    	return salida;
	}
	
	
	public void onRowSelectProducto(SelectEvent event ){
		MyUtil.systemOutPrintln("Llamando onRowSelectProducto()");
    	productoBeanSelect = (TbProductoEntity) event.getObject();
    	//Para que no se quede pegado cod, nombre del empleado
        
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodigo");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombre");
    	RequestContext.getCurrentInstance().update("formUpdate:txtStockMax");
    	RequestContext.getCurrentInstance().update("formUpdate:txtStockMin");
    	RequestContext.getCurrentInstance().update("formUpdate:txtPrecioComp");
    	RequestContext.getCurrentInstance().update("formUpdate:txtPrecioVent");
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodProveedor");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreProveedor");
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodCategoria");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreCategoria");
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodMarca");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreMarca");
    	RequestContext.getCurrentInstance().update("formUpdate:txtCodUnidadM");
    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreMedida");
    	
	}
	
	
	public void updateProducto(){
		try {
    		tbProductoServices.updateProducto(productoBeanSelect);
    		String msg = "Se actualizo satisfactoriamente.";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
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
			resetProducto();
		}
	}
	
	public void resetProducto(){
    	MyUtil.systemOutPrintln("Llamando resetProducto()");
		productoBean = new TbProductoEntity();
		productoBeanSelect = null;
	}
	
    public void addSelectedDelete(TbProductoEntity obj){
    	productoBeanSelect = obj;
    }
    
	public void deleteProducto(){
	    	try {
	    		tbProductoServices.deleteProducto(productoBeanSelect);
	    		String msg = "Se elimin� satisfactoriamente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    		RequestContext.getCurrentInstance().update("formDataTable");
	    		RequestContext.getCurrentInstance().update("growls");
	    		RequestContext.getCurrentInstance().execute("PF('dlgDelete').hide()");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				String msg = "";
				msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
				msg +=e.getCause()!=null?"Causa: "+e.getCause()+"":"";
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Delete", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().execute("PF('dlgDelete').hide()");
			}finally{
				resetProducto();
			}
	    }
	
	 public void generarCodigoProducto(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoProducto()");
	    	resetProducto();
	    	try {
	    		productoBean.setCodigoPro(tbProductoServices.generarCodigoProducto());
	    		RequestContext.getCurrentInstance().update("formCreate:txtCodigo");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombre");
	        	RequestContext.getCurrentInstance().update("formCreate:txtStockMax");
	        	RequestContext.getCurrentInstance().update("formCreate:txtStockMin");
	        	RequestContext.getCurrentInstance().update("formCreate:txtPrecioComp");
	        	RequestContext.getCurrentInstance().update("formCreate:txtPrecioVent");
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodProveedor");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombreProveedor");
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodCategoria");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombreCategoria");
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodMarca");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombreMarca");
	        	RequestContext.getCurrentInstance().update("formCreate:txtCodUnidadM");
	        	RequestContext.getCurrentInstance().update("formCreate:txtNombreMedida");

			} catch (Exception e) {
				MyUtil.systemOutPrintln(e.getMessage()+"");
				MyUtil.systemOutPrintln(e.getCause()+"");
			}
	    }
	    
	    public boolean recargarListaProducto(){
	    	String msg;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando recargarListaProducto()");
	    		productoList = tbProductoServices.findAllProducto();
	    		msg = "�Recarga completa!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("formDataTable");
	            RequestContext.getCurrentInstance().update("growls");
	            
			} catch (Exception e) {
				msg = ""+e.getMessage();
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en  listar Producto", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().update("growls");
			}
	    	return true;
	    }
	    
	    public void createProducto(){
	    	String msg ="";
	    	boolean seGuardo=false;
	    	try {
	    		
	    		if(productoBean.getTbProveedor()==null){
	    			msg = "Elija un Proveedor.";
	                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validacion:", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	    		}if(productoBean.getTbCategoria()==null){
	    			msg = "Elija una Categoria.";
	                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validacion:", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	    		}if(productoBean.getTbMarca()==null){
	    			msg = "Elija una Marca.";
	                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validacion:", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	    		}if(productoBean.getTbUnidadMedida()==null){
	    			msg = "Elija una Unidad de Medida.";
	                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validacion:", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	    		}
            	RequestContext.getCurrentInstance().update("growls");
	    		if(productoBean.getTbProveedor() != null && productoBean.getTbCategoria() !=null && productoBean.getTbMarca() != null && productoBean.getTbUnidadMedida() != null){
	    		
	    			tbProductoServices.insertProducto(productoBean);
	    			msg = "Se cre� correctamente el registro.";
	        	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
	                FacesContext.getCurrentInstance().addMessage(null, message);
	        		RequestContext.getCurrentInstance().update("formDataTable");
	        		RequestContext.getCurrentInstance().update("growls");
	        		RequestContext.getCurrentInstance().execute("PF('dlgCreate').hide()");
	        		seGuardo = true;
	    		}
	    		
			} catch (Exception e) {
				msg = "";
				msg =e.getMessage()!=null?"Mensaje: "+e.getMessage()+"\n":"";
				msg +=e.getCause()!=null?"Causa: "+e.getCause()+"":"";
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error insert", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("messages");
	            RequestContext.getCurrentInstance().execute("PF('dlgCreate').hide()");
			}finally{
				if(seGuardo){
					resetProducto();	
				}
				
			}
	    }

	    
	    public void onRowSelectProveedor(SelectEvent event ){
			MyUtil.systemOutPrintln("Llamando onRowSelectProveedor()");
			
			if(productoBeanSelect==null){
				productoBean.setTbProveedor(((TbProveedorEntity) event.getObject()));
		    	RequestContext.getCurrentInstance().update("formCreate:txtCodProveedor");
		    	RequestContext.getCurrentInstance().update("formCreate:txtNombreProveedor");
			}else{
				productoBeanSelect.setTbProveedor(((TbProveedorEntity) event.getObject()));
		    	RequestContext.getCurrentInstance().update("formUpdate:txtCodProveedor");
		    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreProveedor");
			}
		}
	    
	    public void onRowSelectCategoria(SelectEvent event ){
			MyUtil.systemOutPrintln("Llamando onRowSelectCategoria()");
			
			if(productoBeanSelect==null){
				productoBean.setTbCategoria((TbCategoriaEntity) event.getObject()); 
		    	RequestContext.getCurrentInstance().update("formCreate:txtCodCategoria");
		    	RequestContext.getCurrentInstance().update("formCreate:txtNombreCategoria");	
			}else{
				productoBeanSelect.setTbCategoria((TbCategoriaEntity) event.getObject()); 
		    	RequestContext.getCurrentInstance().update("formUpdate:txtCodCategoria");
		    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreCategoria");
			}
			
	    	
	    	
		}
	    
	    public void onRowSelectMarca(SelectEvent event ){
			MyUtil.systemOutPrintln("Llamando onRowSelectMarca()");
			
			if(productoBeanSelect==null){
				productoBean.setTbMarca((TbMarcaEntity) event.getObject()); 
		    	RequestContext.getCurrentInstance().update("formCreate:txtCodMarca");
		    	RequestContext.getCurrentInstance().update("formCreate:txtNombreMarca");	
			}else{
				productoBeanSelect.setTbMarca((TbMarcaEntity) event.getObject()); 
		    	RequestContext.getCurrentInstance().update("formUpdate:txtCodMarca");
		    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreMarca");
			}
			
	    	
	    	
		}
	    
	    public void onRowSelectUnidadMedida(SelectEvent event ){
			MyUtil.systemOutPrintln("Llamando onRowSelectUnidadMedida()");
			
			if(productoBeanSelect==null){
				productoBean.setTbUnidadMedida((TbUnidadMedidaEntity) event.getObject());
		    	RequestContext.getCurrentInstance().update("formCreate:txtCodUnidadM");
		    	RequestContext.getCurrentInstance().update("formCreate:txtNombreMedida");	
			}else{
				productoBeanSelect.setTbUnidadMedida((TbUnidadMedidaEntity) event.getObject());
		    	RequestContext.getCurrentInstance().update("formUpdate:txtCodUnidadM");
		    	RequestContext.getCurrentInstance().update("formUpdate:txtNombreMedida");
			}
			
	    	
	    	
		}
	    
	    
	    public void  exportarReportePdf() {
	    	descargar = true;
	    	try {
	    		MyUtil.systemOutPrintln("Llamando a descargarReportePdf()");
	    		productoList = tbProductoServices.findAllProducto();
		    	
	            imprimirPDF(descargar);		    	
	            productoList.clear();	    		
		    	
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
	    		productoList = tbProductoServices.findAllProducto();
		    	imprimirPDF(descargar);
		    	
		    	if(filePdf == null){
		    		salida = false;
		    	}
		    	
		    	productoList.clear();
		    		
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
	    	productoList = tbProductoServices.findAllProducto();
	    	
	    	ir.setJasperPrint("/resources/reporte/ProductosReport.jasper", param, new JRBeanCollectionDataSource(productoList));
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
	            if(productoList != null && productoList.size() >0) {
	            	ir.setJasperPrint("/resources/reporte/ProductosReport.jasper", param, new JRBeanCollectionDataSource(productoList));
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
	    
	    

	    
	    
//-------------------------------------------------------------------
		public TbProductoEntity getProductoBean() {
			return productoBean;
		}
		public void setProductoBean(TbProductoEntity productoBean) {
			this.productoBean = productoBean;
		}
		public TbProductoEntity getProductoBeanSelect() {
			return productoBeanSelect;
		}
		public void setProductoBeanSelect(TbProductoEntity productoBeanSelect) {
			this.productoBeanSelect = productoBeanSelect;
		}
		public List<TbProductoEntity> getProductoList() {
//			cargarListaProducto();
			return productoList;
		}
		public void setProductoList(List<TbProductoEntity> productoList) {
			this.productoList = productoList;
		}
		public void setTbProductoServices(TbProductoServices tbProductoServices) {
			this.tbProductoServices = tbProductoServices;
		}
		public StreamedContent getFilePdf() {
			return filePdf;
		}
		public void setFilePdf(StreamedContent filePdf) {
			this.filePdf = filePdf;
		}
	
}
