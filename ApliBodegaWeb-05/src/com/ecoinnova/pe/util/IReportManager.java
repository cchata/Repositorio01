/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.util;

import Country.Country;
import Country.JasperReportUtil;

import com.ecoinnova.pe.jsf.util.Faces;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.StreamedContent;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

/**
 *
 * @author CJAVAPERU
 */
public class IReportManager {

    private JasperPrint jasperPrint;

    public IReportManager(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    public JasperPrint getJasperPrint() {
        return jasperPrint;
    }

    public void setJasperPrint(JasperPrint jasperPrint) {
        this.jasperPrint = jasperPrint;
    }

    /**
     * Para la asignación de JaserPrint, 
     * @param filePathWeb ruta de la carpeta que contiene todas las vistas (paginas web) EJEMPLO: <code>"/rpJSF.jasper"</code>
     * @param param parametros para el envío hacia el reporte
     * @param collection EJEMPLO: <code>new JRBeanCollectionDataSource(this.getLstPersonas())</code>
     * @throws JRException 
     */
    public void setJasperPrint(String filePathWeb, Map<String, Object> param, JRBeanCollectionDataSource collection) throws JRException {
        File jasper = new File(Faces.getRealPath(filePathWeb));
        jasperPrint = JasperFillManager.fillReport(jasper.getPath(), param, collection);
    }
    
    /**
     * 
     * @param filePathWeb ruta de la carpeta que contiene todas las vistas (paginas web) EJEMPLO: <code>"/rpJSF.jasper"</code>
     * @param param parametros para el envío hacia el reporte
     * @param connection JDBC Connexion.
     * @throws JRException 
     */
    public void setJasperPrint(String filePathWeb, Map<String, Object> param, Connection connection) throws JRException {
        File jasper = new File(Faces.getRealPath(filePathWeb));
        jasperPrint = JasperFillManager.fillReport(jasper.getPath(), param, connection);
    }

    public void exportarPDF(String outputName) throws JRException, IOException {
        HttpServletResponse response = Faces.getResponse();
        if (!outputName.endsWith(".pdf")) {
            outputName = outputName + ".pdf";
        }
        response.addHeader("Content-disposition", "attachment; filename=" + outputName);
        ServletOutputStream stream = response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);//-------------- * ----------------
        stream.flush();
        stream.close();
        Faces.getCurrentInstance().responseComplete();
    }

    public void verPDF(ActionEvent actionEvent) throws Exception {
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/rpJSF.jasper"));
//
//        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getLstPersonas()));
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.setContentType("application/pdf");
//        response.setContentLength(bytes.length);
//        ServletOutputStream outStream = response.getOutputStream();
//        outStream.write(bytes, 0, bytes.length);
//        outStream.flush();
//        outStream.close();
//
//        FacesContext.getCurrentInstance().responseComplete();
    }

//--------------- Se agrego --------------
	    public  ByteArrayOutputStream getOutputStreamFromReport(JRBeanCollectionDataSource dataSource, Map map) throws Exception {
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
//	        JasperPrint jasperPrint = JasperFillManager.fillReport(pathJasper, map, dataSource);
	        JasperExportManager.exportReportToPdfStream(jasperPrint, os);
	        os.flush();
	        os.close();
//	        Faces.getCurrentInstance().responseComplete();
	        return os;
	    }
    
	    
	    public  ByteArrayOutputStream getOutputStreamFromReport() throws Exception {
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
//	        JasperPrint jp = JasperFillManager.fillReport(pathJasper, map, dataSource);
	        JasperExportManager.exportReportToPdfStream(jasperPrint, os);//-------------- * ----------------
	        os.flush();
	        os.close();
//	        Faces.getCurrentInstance().responseComplete();
	        return os;
	    }
	    
	    public StreamedContent generateMediaPdf(JRBeanCollectionDataSource dataSource, Map map,String nameFilePdf){
	           StreamedContent media = null;
	           ByteArrayOutputStream outputStream;
	        try {
	            outputStream = getOutputStreamFromReport(dataSource, map);
//	        	outputStream = getOutputStreamFromReport();
	            media = JasperReportUtil.getStreamContentFromOutputStream(outputStream, "application/pdf", nameFilePdf);
//	            response.addHeader("Content-disposition", "attachment; filename=" + outputName);
//	            media = JasperReportUtil.getStreamContentFromOutputStream(outputStream, "application/pdf");
	           
	        } catch (Exception e) {
	        	System.out.println("--catch--");
	        	System.out.println("--e.getMessage()--"+e.getMessage());
	        	System.out.println("--e.getCause()--"+e.getCause());
	            e.getStackTrace();
	        }
	        return media;
	    } 
	    
	    public StreamedContent generateMediaPdf(String nameFilePdf){
	           StreamedContent media = null;
	           ByteArrayOutputStream outputStream;
	        try {
	            outputStream = getOutputStreamFromReport();
	           
	            media = JasperReportUtil.getStreamContentFromOutputStream(outputStream, "application/pdf", nameFilePdf);
//	            media = JasperReportUtil.getStreamContentFromOutputStream(outputStream, "application/pdf");
	           
	        } catch (Exception e) {
	        	System.out.println("--catch--");
	        	System.out.println("--e.getMessage()--"+e.getMessage());
	        	System.out.println("--e.getCause()--"+e.getCause());
	            e.getStackTrace();
	        }
	        return media;
	    } 
	 
//	    ---------------  .  -------------- 
    public void exportarExcel(String outputName) throws JRException, IOException {
        HttpServletResponse response = Faces.getResponse();
        if (!outputName.endsWith(".xls")) {
            outputName = outputName + ".xls";
        }
        response.addHeader("Content-disposition", "attachment; filename=" + outputName);
        ServletOutputStream outStream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarDOC(String outputName) throws JRException, IOException {
        HttpServletResponse response = Faces.getResponse();
        if (!outputName.endsWith(".doc")) {
            outputName = outputName + ".doc";
        }
        response.addHeader("Content-disposition", "attachment; filename=" + outputName);
        ServletOutputStream outStream = response.getOutputStream();

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarPPT(String outputName) throws JRException, IOException {
        HttpServletResponse response = Faces.getResponse();
        if (!outputName.endsWith(".ppt")) {
            outputName = outputName + ".ppt";
        }
        response.addHeader("Content-disposition", "attachment; filename=" + outputName);
        ServletOutputStream outStream = response.getOutputStream();

        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
        exporter.exportReport();

        outStream.flush();
        outStream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
}
