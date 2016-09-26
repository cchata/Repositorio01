package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BuiltinFormats;

import services.Util;
import ejb.ActorEjb;
import entity.Actor;
import exception.DataBaseException;

@WebServlet("/GenerarExcelServlet.html")
public class GenerarExcelServlet extends HttpServlet {
	
	@EJB
	ActorEjb actorEjb;
	private Map         listaExcel        = null;
	private String[]    tituloExcel       = null;
	private String[]    tipoDateExcel     = null;
	private String[]    longitudExcel     = null;
	private List<Actor> lista             = null;
	
	private static final long serialVersionUID = 1L;
    public GenerarExcelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("GenerarExcelServlet.html");
		lista = actorEjb.listarAll();
		
		listaExcel = new HashMap();
		tituloExcel       = new String[]{"ID","NOMBRE","EDAD"};
		tipoDateExcel     = new String[]{"NUMBER","VARCHAR2","NUMBER"};
		longitudExcel     = new String[]{"5","45","2"};
		
		listaExcel.put(1, tituloExcel);
		listaExcel.put(2, tipoDateExcel);
		listaExcel.put(3, longitudExcel);
		listaExcel.put(4, lista);
		
		
//		Map listaExcel = (Map)request.getAttribute("listaExcel");
		
		System.out.println("---11---");
		int          intTemp    = 0;
		double       doubleTemp = 0.0;
		double       longTemp   = 0;
		OutputStream out        = null;
		String       testDate   = null;
		Date         date       = null;
		HSSFRow      row        = null;
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println("---12---");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition","inline; filename=Nettalco.xls");
		System.out.println("---13---");
		HSSFWorkbook  wb    = new HSSFWorkbook();
		HSSFSheet     sheet = wb.createSheet("Hoja1");//pestaña
		HSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat((short)BuiltinFormats.getBuiltinFormat("m/d/yy"));
		System.out.println("---14---");
		
					
					if(listaExcel!=null){
						
						try {
									System.out.println("---15---");
								
								String[] titulo    = (String[])listaExcel.get(1);
								System.out.println("---16---"+titulo.toString());
								String[] tipoDato  = (String[])listaExcel.get(2);
								System.out.println("---17---"+tipoDato.toString());
								String[] longitud  = (String[])listaExcel.get(3);
								System.out.println("---18---"+longitud.toString());
								String[] fila      = null;
								List<Actor> listaEntity  = (List<Actor>)listaExcel.get(4);
								System.out.println("---19---size:"+listaEntity.size());
								    HSSFRow rowTitu = sheet.createRow(0);
								    System.out.println("---20---");
						//		    HSSFRow rowTipoDato = sheet.createRow(1);
						//		    HSSFRow rowPresicion = sheet.createRow(2);
								for(int col = 0; col < titulo.length; ++col){
									System.out.println("---21---");
									   rowTitu.createCell(col).setCellValue(new HSSFRichTextString(titulo[col].toString()));
									   System.out.println("---22---");
								}
								
								for(int fil = 0; fil < listaEntity.size(); fil++){
									System.out.println("---23---");
									   String[] filaS = new String[3];
									   filaS[0] = listaEntity.get(fil).getId()+"";
									   System.out.println("---24---");
									   filaS[1] = listaEntity.get(fil).getNombre()+"";
									   System.out.println("---25---");
									   filaS[2] = listaEntity.get(fil).getEdad()+"";
									   System.out.println("---26---");
									   
									   fila = filaS;
									   row  = sheet.createRow(fil+1);	
									   System.out.println("---27---");
									for(int col = 0; col < fila.length; col++){
										System.out.println("---28---");
										if(fila[col] == null || fila[col].trim().length()==0 ){
											System.out.println("---29---");
															if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
																System.out.println("---30---");
																    row.createCell(col).setCellValue(new HSSFRichTextString(""));//null
															}else if(tipoDato[col].trim().equalsIgnoreCase("CHAR")){
																    row.createCell(col).setCellValue(new HSSFRichTextString(""));//null
														    }else if(tipoDato[col].trim().equalsIgnoreCase("NUMBER")){
																	row.createCell(col).setCellValue(0);
																	if(Util.isInteger(fila[col])){
																		row.createCell(col).setCellValue(0);	
																	}else if(Util.isDouble(fila[col])){
																		row.createCell(col).setCellValue(0.0);
																	}
																	
															}else if(tipoDato[col].trim().equalsIgnoreCase("LONG")){
																        row.createCell(col).setCellValue(0);
																	if(Util.isLong(fila[col])){
																		row.createCell(col).setCellValue(0);	
																	}
																
															}else if(tipoDato[col].trim().equalsIgnoreCase("DATE")){
											    						row.createCell(col).setCellValue(new HSSFRichTextString(""));//null
																}
																		
										}else{
											System.out.println("---31---");
											if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
												System.out.println("---32---");
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
												    System.out.println("---33---");
											}else if(tipoDato[col].trim().equalsIgnoreCase("CHAR")){
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
									        }else if(tipoDato[col].trim().equalsIgnoreCase("NUMBER")){
									        	System.out.println("---34---");
													
														if(Util.isInteger(fila[col])){
															 intTemp    = Integer.parseInt(fila[col]);
															row.createCell(col).setCellValue(intTemp);	
														}else if(Util.isDouble(fila[col])){
															doubleTemp = Double.parseDouble(fila[col]);
															row.createCell(col).setCellValue(intTemp);
														}
												
											}else if(tipoDato[col].trim().equalsIgnoreCase("LONG")){
												
												if(Util.isLong(fila[col])){
													      longTemp = Long.parseLong(fila[col]);
													      row.createCell(col).setCellValue(intTemp);	
												}
												
									    	}else if(tipoDato[col].trim().equalsIgnoreCase("DATE")){
												
												            testDate = fila[col];
															try{
																		date = sdf.parse(testDate);
																		row.createCell(col).setCellValue(date);
																		row.getCell(col).setCellStyle(style);//Asignando estilo.
																
															}catch(Exception e){
																
															}
															
											}
											
										}
														
									}
								}
								
								
						
								System.out.println("---35---");
							out = response.getOutputStream();
							System.out.println("---36---");
							wb.write(out);
							System.out.println("---37---");
							out.close();
							System.out.println("---38---");
						} catch (IOException ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}catch (Exception ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}
				
					
					
					
				  }
	}	

	}


