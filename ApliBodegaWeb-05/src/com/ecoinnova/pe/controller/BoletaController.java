package com.ecoinnova.pe.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.jasper.JasperException;
import org.primefaces.component.media.Media;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

import Country.Country;
import Country.JasperReportUtil;

import com.ecoinnova.pe.util.IReportManager;
import com.ecoinnova.pe.bean.Usuario;
import com.ecoinnova.pe.jsf.util.Faces;
import com.ecoinnova.pe.model.TbBoletaEntity;
import com.ecoinnova.pe.model.TbClienteEntity;
import com.ecoinnova.pe.model.TbDetalleBoletaEntity;
import com.ecoinnova.pe.model.TbEmpleadoEntity;
import com.ecoinnova.pe.model.TbProductoEntity;
import com.ecoinnova.pe.model.util.DetalleBoletaReporte;
import com.ecoinnova.pe.model.util.HeaderBoletaReporte;
import com.ecoinnova.pe.services.interfaces.TbBoletaServices;
import com.ecoinnova.pe.util.MyUtil;

@SessionScoped
@ManagedBean
public class BoletaController implements Serializable{

	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{tbBoletaServices}")
    TbBoletaServices   tbBoletaServices;
    
    @ManagedProperty(value = "#{productoController}")
    private ProductoController productoController;
    
    

    private boolean btnBuscarCliente;
    private boolean btnNuevoCliente;
    private boolean btnNuevaBoleta;
    private boolean btnGuardar;
    private boolean btnCancelar;
    private boolean btnSalir;
    
    private boolean inputCodigoBoleta;
    private boolean inputFechaBoleta;
    private boolean inputCodigoCliente;
    private boolean inputNombreCliente;
    
    private boolean inputCodigoProducto;
    private boolean inputNombreProducto;
    private boolean inputStockProducto;
    private boolean inputPrecioVentaProducto;
    private boolean inputCantidadProducto;
    
    private boolean btnAgregarProducto;
    private boolean btnLimpiarProducto;
    private boolean btnQuitarProducto;
    
    private boolean btnRefrescarListaP;

    private boolean inputTotalApagar;
    
    private TbBoletaEntity boletaBean;
    
    private List<TbProductoEntity> productoBeanList;    
    
    private TbDetalleBoletaEntity detalleBoletaBean;
    
    private TbProductoEntity productoBeanSelect;
    
    private List<TbDetalleBoletaEntity> detalleBoletaBeanList;
    
    private TbDetalleBoletaEntity detalleBoletaCopyBean;
    
    private BigDecimal totalApagar;
    
    
    private TbDetalleBoletaEntity detalleBoletaQuitarBean;
    
    
    private TbDetalleBoletaEntity dbExiste;
    
    private HeaderBoletaReporte headerBoletaReporte;
    
    private DetalleBoletaReporte detalleBoletaReporte;
    
    private List<DetalleBoletaReporte> detalleBoletaReporteList;
    
    private StreamedContent filePdf;
	private boolean descargar;
	private String nombreReportePdf;
    
    
    
    
	public  BoletaController(){
		MyUtil.systemOutPrintln("Llamando al constructor BoletaController()");
		boletaBean        = new TbBoletaEntity();
		productoBeanList  = new ArrayList<TbProductoEntity>();
		
		detalleBoletaBeanList = new ArrayList<TbDetalleBoletaEntity>();
//		boletaBean.setTbEmpleado(new TbEmpleadoEntity());
		
	    btnBuscarCliente = true;
	    btnNuevoCliente  = true;
	    btnNuevaBoleta   = false;
	    btnGuardar       = true;
	    btnCancelar      = true;
	    btnSalir         = false;
	    
	    inputCodigoBoleta  = true;
	    inputFechaBoleta   = true;
	    inputCodigoCliente = true;
	    inputNombreCliente = true;
	    
	    inputCodigoProducto      = true;
	    inputNombreProducto      = true;
	    inputStockProducto       = true;
	    inputPrecioVentaProducto = true;
	    inputCantidadProducto    = true;
	    
	    btnAgregarProducto = true;
	    btnLimpiarProducto = true;
	    btnQuitarProducto  = true;
	    inputTotalApagar   = true;
	    btnRefrescarListaP = true;
	    totalApagar = new BigDecimal(0);
	    descargar        = false;
		nombreReportePdf = "boletaReport.pdf";
    }
    


	public String salirGestionVenta(){
		MyUtil.systemOutPrintln("Llamando salirGestionVenta()");
		String url = "";
		try {
			 url = "index?faces-redirect=true";
			 RequestContext.getCurrentInstance().update("growls");
		} catch (Exception e) {
			MyUtil.systemOutPrintln("Llamando Exception e");
			MyUtil.systemOutPrintln(e.getMessage()+"");
			MyUtil.systemOutPrintln(e.getCause()+"");
			MyUtil.systemOutPrintln(e.getLocalizedMessage()+"");
		}
		return url;
	}
	
	 public void generarCodigoBoleta(){
	    	MyUtil.systemOutPrintln("Llamando generarCodigoBoleta()");
	    	resetBoleta();
	    	try {
	    		boletaBean.setCodigoBol(tbBoletaServices.generarCodigoBoleta());
	    		Usuario usu = ((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(Faces.ATTRIBUTE_USER));
	    		TbEmpleadoEntity tbEmpleadoBean = new TbEmpleadoEntity();
	    		tbEmpleadoBean.setCodigoEmp(usu.getCodigoEmpleado());
	    		boletaBean.setTbEmpleado(tbEmpleadoBean);
	    		//Sett cod cliente ya esta seteado en la vista.
	    		boletaBean.setFechaBol(new Date());
	    		
	    		
//	    		productoController.cargarListaProducto();
//	    		productoBeanList = productoController.getProductoList();
	    		
    		    btnBuscarCliente = false;
    		    btnNuevoCliente  = false;
    		    btnNuevaBoleta   = true;
//    		    btnGuardar       = false;
    		    btnCancelar      = false;
    		    btnSalir         = true;
    		    inputCodigoBoleta  = false;
    		    inputFechaBoleta   = false;
    		    inputCodigoCliente = false;
    		    inputNombreCliente = false;
//    		    inputCodigoProducto      = false;
//    		    inputNombreProducto      = false;
//    		    inputStockProducto       = false;
//    		    inputPrecioVentaProducto = false;
//    		    inputCantidadProducto    = false;
//    		    btnAgregarProducto = false;
//    		    btnLimpiarProducto = false;
//    		    btnQuitarProducto  = false;
    		    inputTotalApagar   = false;
	    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoBolVenta");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtFecha");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoCliente");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtNombreCliente");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnBuscarCliente");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnNuevoCliente");
    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoProducto");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtNombreProducto");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtStock");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtPrecio");
    		    RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnAgregarProducto");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnLimpiarProducto");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnQuitar");
    		    
    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:txtTotalPagar");
    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnNuevaBoleta");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnGuardarBoleta");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnCancelarBoleta");
    		    RequestContext.getCurrentInstance().update("formDataTable:idBtnSalir");
    		    
    		    RequestContext.getCurrentInstance().update("formDataTable:idProductos");
    		    
//	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnRefrescarListaP");
	    		
	    		
			} catch (Exception e) {
				MyUtil.systemOutPrintln("Error: "+e.getMessage()+"");
				MyUtil.systemOutPrintln("Error: "+e.getCause()+"");
			}
	    }

	 
	 public void cancelarBoleta(){
	    	MyUtil.systemOutPrintln("Llamando cancelarBoleta()");
//	    	resetBoleta();
	    	try {
	    		btnBuscarCliente = true;
    		    btnNuevoCliente  = true;
    		    btnNuevaBoleta   = false;
    		    btnGuardar       = true;
    		    btnCancelar      = true;
    		    btnSalir         = false;
    		    
    		    inputCodigoBoleta  = true;
    		    inputFechaBoleta   = true;
    		    inputCodigoCliente = true;
    		    inputNombreCliente = true;
    		    
    		    inputCodigoProducto      = true;
    		    inputNombreProducto      = true;
    		    inputStockProducto       = true;
    		    inputPrecioVentaProducto = true;
    		    inputCantidadProducto    = true;
    		    
    		    btnAgregarProducto = true;
    		    btnLimpiarProducto = true;
    		    btnQuitarProducto  = true;
    		    inputTotalApagar   = true;
    		    
    		    btnRefrescarListaP = true;
	    		    
    		    resetBoleta();
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoBolVenta");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtFecha");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoCliente");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtNombreCliente");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnBuscarCliente");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnNuevoCliente");
	 		    
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtCodigoProducto");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtNombreProducto");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtStock");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtPrecio");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
	 		    
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnAgregarProducto");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnLimpiarProducto");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnQuitar");
	 		    
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnNuevaBoleta");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnGuardarBoleta");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnCancelarBoleta");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnSalir");
	    		
	 		    RequestContext.getCurrentInstance().update("formDataTable:idProductos");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idProductosComprar");
	 		    RequestContext.getCurrentInstance().update("formDataTable:txtTotalPagar");
	 		    RequestContext.getCurrentInstance().update("formDataTable:idBtnRefrescarListaP");
	 		  
	 		  
	 		   
			} catch (Exception e) {
				MyUtil.systemOutPrintln("Error: "+e.getMessage()+"");
				MyUtil.systemOutPrintln("Error: "+e.getCause()+"");
			}
	    }

	public void resetBoleta(){
		boletaBean            = new TbBoletaEntity(); 
		productoBeanList      = new ArrayList<TbProductoEntity>();
		detalleBoletaBean     = new TbDetalleBoletaEntity();
		detalleBoletaBeanList = new ArrayList<TbDetalleBoletaEntity>();
		totalApagar = new BigDecimal(0.00);
	}
	
	public void onRowSelectCliente(SelectEvent event){
		MyUtil.systemOutPrintln("Llamando onRowSelectCliente()");
		TbClienteEntity clienteBeanSelect =	(TbClienteEntity)event.getObject();
		
		boletaBean.setTbCliente(clienteBeanSelect);

		productoController.cargarListaProducto();
		productoBeanList = productoController.getProductoList();

		btnRefrescarListaP = false;
		
		RequestContext.getCurrentInstance().update("formDataTable:txtCodigoCliente");
		RequestContext.getCurrentInstance().update("formDataTable:txtNombreCliente");
		RequestContext.getCurrentInstance().update("formDataTable:idProductos");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnRefrescarListaP");
	}
	

	
	public void onRowSelectProducto(SelectEvent event){
		MyUtil.systemOutPrintln("Llamando onRowSelectProducto()");
		
		
		
		detalleBoletaBean  = new TbDetalleBoletaEntity();
		productoBeanSelect = (TbProductoEntity)event.getObject();
		detalleBoletaBean.setTbBoleta(boletaBean);
		
		detalleBoletaBean.getId().setCodigoBol(boletaBean.getCodigoBol());
		TbProductoEntity pe = settProducto(productoBeanSelect);
		
		detalleBoletaBean.setTbProducto(pe);
		detalleBoletaBean.getId().setCodigoPro(pe.getCodigoPro());
		
		detalleBoletaBean.setPrecioBol(pe.getPrecioVentaPro());
		
//		detalleBoletaBean.setCantidadBol(productoBeanSelect.getStockMaxPro());
		int stockMaxProTemp = 0;
		stockMaxProTemp = detalleBoletaBean.getTbProducto().getStockMaxPro();
		int stockMaxProUpdate = 0;
			for(TbDetalleBoletaEntity dbe:detalleBoletaBeanList){
				
				if(detalleBoletaBean.getTbProducto().getCodigoPro().equals(dbe.getTbProducto().getCodigoPro())){
					stockMaxProUpdate = stockMaxProTemp - dbe.getCantidadBol();
					detalleBoletaBean.getTbProducto().setStockMaxPro(stockMaxProUpdate);//update stockMax
				}
			}
			
			detalleBoletaCopyBean = detalleBoletaBean; 	
		
		
		
		
		
	    btnAgregarProducto = false;
	    btnLimpiarProducto = false;		
	    inputCantidadProducto = false;
	    inputCodigoProducto      = false;
	    inputNombreProducto      = false;
	    inputStockProducto       = false;
	    inputPrecioVentaProducto = false;
	    
	    
		RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
		RequestContext.getCurrentInstance().update("formDataTable:txtCodigoProducto");
		RequestContext.getCurrentInstance().update("formDataTable:txtNombreProducto");
		RequestContext.getCurrentInstance().update("formDataTable:txtStock");
		RequestContext.getCurrentInstance().update("formDataTable:txtPrecio");
		RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnAgregarProducto");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnLimpiarProducto");
		
		
		
	}
	
	
	
	public void limpiarDatosProductos(){
		MyUtil.systemOutPrintln("Llamando limpiarDatosProductos()");
		productoBeanSelect = new TbProductoEntity();
		detalleBoletaBean  = new TbDetalleBoletaEntity();
		
		btnAgregarProducto = true;
		btnLimpiarProducto = true;
		RequestContext.getCurrentInstance().update("formDataTable:txtCodigoProducto");
		RequestContext.getCurrentInstance().update("formDataTable:txtNombreProducto");
		RequestContext.getCurrentInstance().update("formDataTable:txtStock");
		RequestContext.getCurrentInstance().update("formDataTable:txtPrecio");
		RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnAgregarProducto");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnLimpiarProducto");
	}
	
	
	public void buscarRepiteProducto(){
		detalleBoletaBean = detalleBoletaCopyBean;
		dbExiste = null;
		
		if(detalleBoletaCopyBean.getCantidadBol()!=null && detalleBoletaCopyBean.getCantidadBol()>0){
			
			if(detalleBoletaCopyBean.getTbProducto().getStockMaxPro()>=detalleBoletaCopyBean.getCantidadBol()){
				for(TbDetalleBoletaEntity dbe:detalleBoletaBeanList){
					if(detalleBoletaBean.getTbProducto().getCodigoPro().equals(dbe.getTbProducto().getCodigoPro())){
						dbExiste = dbe;
						RequestContext.getCurrentInstance().execute("PF('dlgConfirProd').show()");
						break;
					}
				}
				
				if(dbExiste == null){
					agregarProducto();
				}
				
			}else{
				String msg = "No hay stock suficiente.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Stock Producto", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	    		RequestContext.getCurrentInstance().update("growls");
			}
		}else{
			String msg = "¡Ingrese una cantidad!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cantidad", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("growls");
		}
	}
	

	
	public void agregarProducto(){
		MyUtil.systemOutPrintln("Llamando agregarProducto()");
		btnGuardar = false;
		if(detalleBoletaCopyBean.getCantidadBol()!=null && detalleBoletaCopyBean.getCantidadBol()>0){

//			btnQuitarProducto  = false;
			detalleBoletaBean = detalleBoletaCopyBean;
			
			int    cantidadBolUpdate = 0;
			BigDecimal importe           = new BigDecimal(0);
					
			if(dbExiste != null){
				RequestContext.getCurrentInstance().execute("PF('dlgConfirProd').hide()");
//				totalApagar       = totalApagar -dbExiste.getPrecioBol().doubleValue()*dbExiste.getCantidadBol();
				totalApagar = totalApagar.subtract(dbExiste.getPrecioBol().multiply(new BigDecimal(dbExiste.getCantidadBol())));
				cantidadBolUpdate = dbExiste.getCantidadBol() + detalleBoletaBean.getCantidadBol();
				
				dbExiste.setCantidadBol(cantidadBolUpdate);
				
//				importe           = dbExiste.getPrecioBol()*dbExiste.getCantidadBol();
				importe = dbExiste.getPrecioBol().multiply(new BigDecimal(dbExiste.getCantidadBol()));
				dbExiste.setImporte(importe);
//				totalApagar      +=importe;
				totalApagar = totalApagar.add(importe);
				
			}else{
				
//				importe      = detalleBoletaBean.getPrecioBol().doubleValue()*detalleBoletaBean.getCantidadBol();
				importe = detalleBoletaBean.getPrecioBol().multiply(new BigDecimal(detalleBoletaBean.getCantidadBol()));
				MyUtil.systemOutPrintln("importe= "+importe);
				detalleBoletaBean.setImporte(importe);
				detalleBoletaBeanList.add(detalleBoletaBean);
				totalApagar = totalApagar.add(importe);	
				MyUtil.systemOutPrintln("totalApagar= "+totalApagar);
				
			}
			
			
//			detalleBoletaBean se pierde(no se pq?, por ello uso un copyBean), por eso cuando actualizamos los txt, se borran sus valores.
			btnAgregarProducto = true;
		    btnLimpiarProducto = true;	
//			detalleBoletaBean  = null;//Reseteamos
		    detalleBoletaBean  = new TbDetalleBoletaEntity();
		    
		    inputCantidadProducto = true;
		    inputCodigoProducto      = true;
		    inputNombreProducto      = true;
		    inputStockProducto       = true;
		    inputPrecioVentaProducto = true;
		    
			RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
			RequestContext.getCurrentInstance().update("formDataTable:txtCodigoProducto");
			RequestContext.getCurrentInstance().update("formDataTable:txtNombreProducto");
			RequestContext.getCurrentInstance().update("formDataTable:txtStock");
			RequestContext.getCurrentInstance().update("formDataTable:txtPrecio");
			RequestContext.getCurrentInstance().update("formDataTable:txtCantidad");
			RequestContext.getCurrentInstance().update("formDataTable:idProductosComprar");
			RequestContext.getCurrentInstance().update("formDataTable:txtTotalPagar");
			RequestContext.getCurrentInstance().update("formDataTable:idBtnAgregarProducto");
			RequestContext.getCurrentInstance().update("formDataTable:idBtnLimpiarProducto");
			RequestContext.getCurrentInstance().update("formDataTable:idProductos");
			RequestContext.getCurrentInstance().update("formDataTable:idBtnGuardarBoleta");
//			RequestContext.getCurrentInstance().update("formDataTable:idBtnQuitar");
//			detalleBoletaBean = null;//Reseteamos
		
		}else{
    		String msg = "¡Ingrese una cantidad!";
    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cantidad", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            RequestContext.getCurrentInstance().update("growls");
//            RequestContext.getCurrentInstance().addCallbackParam("loggedIn", true);
//            RequestContext.getCurrentInstance().execute("document.getElementById('formDataTable.txtCantidad').focus()");
//            RequestContext.getCurrentInstance().execute("document.getElementById('formDataTable:txtCantidad').focus()");
//            RequestContext.getCurrentInstance().execute("alert('Hola mundo')");
//            oncomplete="setFocusTo()"
//            RequestContext.getCurrentInstance().execute("setFocusTo()");
		}
		
	}
	
	
	public void onRowSelectProductoQuitar(SelectEvent event){
		
		detalleBoletaQuitarBean =	(TbDetalleBoletaEntity)event.getObject();
		btnQuitarProducto  = false;
		RequestContext.getCurrentInstance().update("formDataTable:idBtnQuitar");
	}
	
	public void btnQuitarProducto(){
		MyUtil.systemOutPrintln("Llamando a btnQuitarProducto()");
		MyUtil.systemOutPrintln("detalleBoletaQuitarBean= "+detalleBoletaQuitarBean);
//		totalApagar = totalApagar - detalleBoletaQuitarBean.getPrecioBol().doubleValue()*detalleBoletaQuitarBean.getCantidadBol();
		totalApagar = totalApagar.subtract(detalleBoletaQuitarBean.getPrecioBol().multiply(new BigDecimal(detalleBoletaQuitarBean.getCantidadBol())));
		MyUtil.systemOutPrintln("Nuevo totalApagar     = "+totalApagar);
		detalleBoletaBeanList.remove(detalleBoletaQuitarBean);
		btnQuitarProducto  = true;
		if(detalleBoletaBeanList.size()==0){
			btnGuardar = true;	
		}
		
		RequestContext.getCurrentInstance().update("formDataTable:txtTotalPagar");		
		RequestContext.getCurrentInstance().update("formDataTable:idProductosComprar");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnQuitar");
		RequestContext.getCurrentInstance().update("formDataTable:idBtnGuardarBoleta");
	}
	
	public TbProductoEntity settProducto(TbProductoEntity pe){
		TbProductoEntity pe2 = new  TbProductoEntity();
		pe2.setCodigoPro(pe.getCodigoPro());
		pe2.setFotoPro(pe.getFotoPro());
		pe2.setNombrePro(pe.getNombrePro());
		pe2.setObservacionPro(pe.getObservacionPro());
		pe2.setPrecioCompraPro(pe.getPrecioCompraPro());
		pe2.setPrecioVentaPro(pe.getPrecioVentaPro());
		pe2.setStockMaxPro(pe.getStockMaxPro());
		pe2.setStockMinPro(pe.getStockMinPro());
		pe2.setTbCategoria(pe.getTbCategoria());
		pe2.setTbDetalleBoletas(pe.getTbDetalleBoletas());
		pe2.setTbMarca(pe.getTbMarca());
		pe2.setTbProveedor(pe.getTbProveedor());
		pe2.setTbUnidadMedida(pe.getTbUnidadMedida());
		return pe2;
	}
	
	public void recargarListaProducto(){
		productoController.cargarListaProducto();
		productoBeanList = productoController.getProductoList();
//		String msg = "¡Recarga lista producto completa!";
//	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Producto", msg);
//        FacesContext.getCurrentInstance().addMessage(null, message);
        RequestContext.getCurrentInstance().update("formDataTable:idProductos");
        RequestContext.getCurrentInstance().update("growls");
		
	}
	



	public void guardarBoleta(){
		
		try {
			String mensaje =null;
			
			if(boletaBean!= null && detalleBoletaBeanList.size() > 0){
				
				prepararParametrosReporte();//Reporte pdf
				
				boletaBean.setTbDetalleBoletas(detalleBoletaBeanList);
				tbBoletaServices.insertBoleta(boletaBean);
				
				for(TbDetalleBoletaEntity dbe:detalleBoletaBeanList){
					mensaje = tbBoletaServices.actulizarStockProducto(dbe.getId().getCodigoPro(), dbe.getCantidadBol());
					mensaje = mensaje==null?"OK":""+mensaje;
					MyUtil.systemOutPrintln("update: "+mensaje);
				}
				
				String msg = "Se guardó satisfactriamente!";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Boleta", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            cancelarBoleta();
	            RequestContext.getCurrentInstance().update("growls");
	            
			}else{
				String msg = "Por favor, compre al menos un producto.";
	    	    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Boleta", msg);
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            RequestContext.getCurrentInstance().update("growls");
				MyUtil.systemOutPrintln("boletaBean Null: "+boletaBean);
			}
			
		} catch (Exception e) {
			MyUtil.systemOutPrintln(""+e.getMessage());
			MyUtil.systemOutPrintln(""+e.getCause());
		}
	}
	
	public void cancelarImprmirBoleta(){
		cancelarBoleta();
	}
	
	
    public void  exportarReportePdf() {
    	MyUtil.systemOutPrintln("Llamando a exportarReportePdf()");
    	descargar = true;
    	try {
//    		listaCliente = tbClienteServices.findAllCliente();
	    	
            imprimirPDF(descargar);		    	
//            listaCliente.clear();	    		
	    	
		} catch (Exception e) {
			System.out.println("e.getMessage()= "+e.getMessage());
			System.out.println("e.getCause()  = "+e.getCause());
		}
    }
    
    public boolean  viewReportePdf() {
		MyUtil.systemOutPrintln("Llamando a viewReportePdf()");
		descargar      = false;
		boolean salida = true;
    	filePdf          = null;
    	try {
//    		listaCliente = tbClienteServices.findAllCliente();
	    	imprimirPDF(descargar);
	    	
	    	if(filePdf == null){
	    		salida = false;
	    	}
	    	
//	    	listaCliente.clear();
	    		
		} catch (Exception e) {
			System.out.println("e.getMessage()= "+e.getMessage());
			System.out.println("e.getCause()  = "+e.getCause());
		}
    	return salida;
    }
    
    
//    public void refrescarReportePdf() throws Exception{
//    	MyUtil.systemOutPrintln("Llamando a refrescarReportePdf()");
//    	IReportManager      ir    = new IReportManager(null);
//    	Map<String, Object> param = null;
//    	listaCliente      = tbClienteServices.findAllCliente();
//    	
//    	ir.setJasperPrint("/resources/reporte/ClientesReport.jasper", param, new JRBeanCollectionDataSource(listaCliente));
//    	filePdf = ir.generateMediaPdf(nombreReportePdf);
//    	
//    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizacion", "Se actualizó satisfactoriamente");
//        FacesContext.getCurrentInstance().addMessage(null, message);
//        RequestContext.getCurrentInstance().update("idFormReport:idMedia");
//        RequestContext.getCurrentInstance().update("growls");
//    }
    
    
  
    
    

    public void imprimirPDF(boolean descargar) throws JasperException, IOException {
    	 MyUtil.systemOutPrintln("Llamando a imprimirPDF()");
    	 IReportManager      ir    = new IReportManager(null);
    	 Map<String, Object> param = new HashMap<String, Object>();
         param.put("BOLETA_N", headerBoletaReporte.getNumeroBoleta());
         param.put("FECHA_EMISION",headerBoletaReporte.getFechBoleta());
         param.put("CLIENTE",headerBoletaReporte.getRazonSocialCliente());

    	try {
            if(detalleBoletaReporteList != null && detalleBoletaReporteList.size() >0) {
            	ir.setJasperPrint("/resources/reporte/boleta_venta.jasper", param, new JRBeanCollectionDataSource(detalleBoletaReporteList));
            	if(descargar==false){//ViewReportPdf
            		filePdf = ir.generateMediaPdf(nombreReportePdf);
            		if(filePdf!=null){
            			MyUtil.systemOutPrintln("filePdf Ok: "+filePdf);
            		}else{
            			MyUtil.systemOutPrintln("filePdf Null: "+filePdf);
            		}
            		
		            RequestContext.getCurrentInstance().update("idFormReport:idMedia");
		            
	                RequestContext.getCurrentInstance().execute("PF('dlgReporteViewBoleta').show()");
//		            ir.exportarPDF(nombPdf);
            	}else{
            		if(filePdf!=null){
            			MyUtil.systemOutPrintln("filePdf Ok: "+filePdf);
            		}else{
            			MyUtil.systemOutPrintln("filePdf Null: "+filePdf);
            		}
            		filePdf = ir.generateMediaPdf(nombreReportePdf);
            		
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
    
    
	


    
    
    public void prepararParametrosReporte(){
    	detalleBoletaReporteList = new ArrayList<DetalleBoletaReporte>();
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    	headerBoletaReporte = new HeaderBoletaReporte();
    	headerBoletaReporte.setNumeroBoleta(boletaBean.getCodigoBol());
    	headerBoletaReporte.setRazonSocialCliente(boletaBean.getTbCliente().getRazonSocialCli());
    	headerBoletaReporte.setFechBoleta(sdf.format(boletaBean.getFechaBol()));
//    	---------------
    	
    	for(TbDetalleBoletaEntity dbe:detalleBoletaBeanList){
    		detalleBoletaReporte = new DetalleBoletaReporte();
    		detalleBoletaReporte.setNombreProducto(dbe.getTbProducto().getNombrePro());
    		detalleBoletaReporte.setPrecioBol(dbe.getPrecioBol());
    		detalleBoletaReporte.setCantidadBol(dbe.getCantidadBol());
    		detalleBoletaReporte.setImporte(dbe.getImporte());
    		detalleBoletaReporteList.add(detalleBoletaReporte);
    	}
        
    }
    
    public List<DetalleBoletaReporte> getParametrosReporte(){
    	List<DetalleBoletaReporte> listaReporte = new ArrayList<DetalleBoletaReporte>();
    	for(TbDetalleBoletaEntity dbe:detalleBoletaBeanList){
    		DetalleBoletaReporte dbdt = new  DetalleBoletaReporte();
    		dbdt.setNombreProducto(dbe.getTbProducto().getNombrePro());
    		dbdt.setPrecioBol(dbe.getPrecioBol());
    		dbdt.setCantidadBol(dbe.getCantidadBol());
    		dbdt.setImporte(dbe.getImporte());
    		listaReporte.add(dbdt);
    	}
    	return listaReporte;
    }

    
//	---------------------------------------------------
	public void setTbBoletaServices(TbBoletaServices tbBoletaServices) {
		this.tbBoletaServices = tbBoletaServices;
	}
	public boolean isBtnBuscarCliente() {
		return btnBuscarCliente;
	}
	public void setBtnBuscarCliente(boolean btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}
	public boolean isBtnNuevoCliente() {
		return btnNuevoCliente;
	}
	public void setBtnNuevoCliente(boolean btnNuevoCliente) {
		this.btnNuevoCliente = btnNuevoCliente;
	}
	public boolean isBtnNuevaBoleta() {
		return btnNuevaBoleta;
	}
	public void setBtnNuevaBoleta(boolean btnNuevaBoleta) {
		this.btnNuevaBoleta = btnNuevaBoleta;
	}
	public boolean isBtnGuardar() {
		return btnGuardar;
	}
	public void setBtnGuardar(boolean btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	public boolean isBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(boolean btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	public boolean isBtnSalir() {
		return btnSalir;
	}
	public void setBtnSalir(boolean btnSalir) {
		this.btnSalir = btnSalir;
	}



	public boolean isInputCodigoBoleta() {
		return inputCodigoBoleta;
	}
	public void setInputCodigoBoleta(boolean inputCodigoBoleta) {
		this.inputCodigoBoleta = inputCodigoBoleta;
	}
	public boolean isInputFechaBoleta() {
		return inputFechaBoleta;
	}
	public void setInputFechaBoleta(boolean inputFechaBoleta) {
		this.inputFechaBoleta = inputFechaBoleta;
	}
	public boolean isInputCodigoCliente() {
		return inputCodigoCliente;
	}
	public void setInputCodigoCliente(boolean inputCodigoCliente) {
		this.inputCodigoCliente = inputCodigoCliente;
	}
	public boolean isInputNombreCliente() {
		return inputNombreCliente;
	}
	public void setInputNombreCliente(boolean inputNombreCliente) {
		this.inputNombreCliente = inputNombreCliente;
	}
	public boolean isInputCodigoProducto() {
		return inputCodigoProducto;
	}
	public void setInputCodigoProducto(boolean inputCodigoProducto) {
		this.inputCodigoProducto = inputCodigoProducto;
	}
	public boolean isInputNombreProducto() {
		return inputNombreProducto;
	}
	public void setInputNombreProducto(boolean inputNombreProducto) {
		this.inputNombreProducto = inputNombreProducto;
	}
	public boolean isInputStockProducto() {
		return inputStockProducto;
	}
	public void setInputStockProducto(boolean inputStockProducto) {
		this.inputStockProducto = inputStockProducto;
	}
	public boolean isInputPrecioVentaProducto() {
		return inputPrecioVentaProducto;
	}
	public void setInputPrecioVentaProducto(boolean inputPrecioVentaProducto) {
		this.inputPrecioVentaProducto = inputPrecioVentaProducto;
	}
	public boolean isInputCantidadProducto() {
		return inputCantidadProducto;
	}
	public void setInputCantidadProducto(boolean inputCantidadProducto) {
		this.inputCantidadProducto = inputCantidadProducto;
	}
	public boolean isBtnAgregarProducto() {
		return btnAgregarProducto;
	}
	public void setBtnAgregarProducto(boolean btnAgregarProducto) {
		this.btnAgregarProducto = btnAgregarProducto;
	}
	public boolean isBtnLimpiarProducto() {
		return btnLimpiarProducto;
	}
	public void setBtnLimpiarProducto(boolean btnLimpiarProducto) {
		this.btnLimpiarProducto = btnLimpiarProducto;
	}
	public boolean isBtnQuitarProducto() {
		return btnQuitarProducto;
	}
	public void setBtnQuitarProducto(boolean btnQuitarProducto) {
		this.btnQuitarProducto = btnQuitarProducto;
	}
	public boolean isInputTotalApagar() {
		return inputTotalApagar;
	}
	public void setInputTotalApagar(boolean inputTotalApagar) {
		this.inputTotalApagar = inputTotalApagar;
	}
	public TbBoletaEntity getBoletaBean() {
		return boletaBean;
	}
	public void setBoletaBean(TbBoletaEntity boletaBean) {
		this.boletaBean = boletaBean;
	}
	public ProductoController getProductoController() {
		return productoController;
	}
	public void setProductoController(ProductoController productoController) {
		this.productoController = productoController;
	}
	public List<TbProductoEntity> getProductoBeanList() {
		return productoBeanList;
	}
	public void setProductoBeanList(List<TbProductoEntity> productoBeanList) {
		this.productoBeanList = productoBeanList;
	}
	public TbDetalleBoletaEntity getDetalleBoletaBean() {
		return detalleBoletaBean;
	}
	public void setDetalleBoletaBean(TbDetalleBoletaEntity detalleBoletaBean) {
		this.detalleBoletaBean = detalleBoletaBean;
	}
	public TbProductoEntity getProductoBeanSelect() {
		return productoBeanSelect;
	}
	public void setProductoBeanSelect(TbProductoEntity productoBeanSelect) {
		this.productoBeanSelect = productoBeanSelect;
	}
	public List<TbDetalleBoletaEntity> getDetalleBoletaBeanList() {
		return detalleBoletaBeanList;
	}
	public void setDetalleBoletaBeanList(
			List<TbDetalleBoletaEntity> detalleBoletaBeanList) {
		this.detalleBoletaBeanList = detalleBoletaBeanList;
	}
	public TbDetalleBoletaEntity getDetalleBoletaCopyBean() {
		return detalleBoletaCopyBean;
	}
	public void setDetalleBoletaCopyBean(TbDetalleBoletaEntity detalleBoletaCopyBean) {
		this.detalleBoletaCopyBean = detalleBoletaCopyBean;
	}
	public BigDecimal getTotalApagar() {
		return totalApagar;
	}
	public void setTotalApagar(BigDecimal totalApagar) {
		this.totalApagar = totalApagar;
	}
	public TbDetalleBoletaEntity getDetalleBoletaQuitarBean() {
		return detalleBoletaQuitarBean;
	}
	public void setDetalleBoletaQuitarBean(
			TbDetalleBoletaEntity detalleBoletaQuitarBean) {
		this.detalleBoletaQuitarBean = detalleBoletaQuitarBean;
	}
	public TbDetalleBoletaEntity getDbExiste() {
		return dbExiste;
	}
	public void setDbExiste(TbDetalleBoletaEntity dbExiste) {
		this.dbExiste = dbExiste;
	}
	public boolean isBtnRefrescarListaP() {
		return btnRefrescarListaP;
	}
	public void setBtnRefrescarListaP(boolean btnRefrescarListaP) {
		this.btnRefrescarListaP = btnRefrescarListaP;
	}
	public StreamedContent getFilePdf() {
		return filePdf;
	}
	public void setFilePdf(StreamedContent filePdf) {
		this.filePdf = filePdf;
	}

	
}
