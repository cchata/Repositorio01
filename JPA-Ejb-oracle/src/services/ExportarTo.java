package services;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BuiltinFormats;

import entity.*;
import exception.DataBaseException;
public class ExportarTo {

	
	public  static void toExcel(HttpServletRequest request, HttpServletResponse response,List<String[]> listaExcel,String fileName){
		int          intTemp    = 0;
		double       doubleTemp = 0.0;
		double       longTemp   = 0;
		OutputStream output     = null;
		String       testDate   = null;
		Date         date       = null;
		HSSFRow      row        = null;
		HSSFRow      rowTitu    = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
		String[] titulo    = null;
		String[] tipoDato  = null;
		String[] longitud  = null;
		String[] fila      = null;
		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-disposition","inline; filename=Excel.xls");
		response.setHeader("Content-disposition","inline; filename="+fileName);
		
		HSSFWorkbook  wb    = new HSSFWorkbook();
		HSSFSheet     sheet = wb.createSheet("Hoja1");//pestaña
		HSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat((short)BuiltinFormats.getBuiltinFormat("m/d/yy"));
		
					
					if(listaExcel!=null){
						
						try {
								titulo    = listaExcel.get(0);
								tipoDato  = listaExcel.get(1);
								longitud  = listaExcel.get(2);
								rowTitu   = sheet.createRow(0);
								for(int col = 0; col < titulo.length; ++col){
									   rowTitu.createCell(col).setCellValue(new HSSFRichTextString(titulo[col].toString()));
								}
								
								for(int fil = 3; fil < listaExcel.size(); fil++){
									
									   fila = listaExcel.get(fil);
									   row  = sheet.createRow(fil-2);	
									   
									for(int col = 0; col < fila.length; col++){
										if(fila[col] == null || fila[col].trim().length()==0 ){
															if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
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
											if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
											}else if(tipoDato[col].trim().equalsIgnoreCase("CHAR")){
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
									        }else if(tipoDato[col].trim().equalsIgnoreCase("NUMBER")){
													
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
							output = response.getOutputStream();
							wb.write(output);
							output.close();
						} catch (IOException ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}catch (Exception ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}
				
				  }
	
	}
	
	
	public  static void toExcel(HttpServletRequest request, HttpServletResponse response,List<String[]> listaExcel,String fileName, SimpleDateFormat sdf){
		int          intTemp    = 0;
		double       doubleTemp = 0.0;
		double       longTemp   = 0;
		OutputStream output     = null;
		String       testDate   = null;
		Date         date       = null;
		HSSFRow      row        = null;
		HSSFRow      rowTitu    = null;
//		SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
		String[] titulo    = null;
		String[] tipoDato  = null;
		String[] longitud  = null;
		String[] fila      = null;
		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-disposition","inline; filename=Excel.xls");
		response.setHeader("Content-disposition","inline; filename="+fileName);
		HSSFWorkbook  wb    = new HSSFWorkbook();
		HSSFSheet     sheet = wb.createSheet("Hoja1");//pestaña
		HSSFCellStyle style = wb.createCellStyle();
		style.setDataFormat((short)BuiltinFormats.getBuiltinFormat("m/d/yy"));
		
					
					if(listaExcel!=null){
						
						try {
								titulo    = listaExcel.get(0);
								tipoDato  = listaExcel.get(1);
								longitud  = listaExcel.get(2);
								rowTitu   = sheet.createRow(0);
								for(int col = 0; col < titulo.length; ++col){
									   rowTitu.createCell(col).setCellValue(new HSSFRichTextString(titulo[col].toString()));
								}
								
								for(int fil = 3; fil < listaExcel.size(); fil++){
									
									   fila = listaExcel.get(fil);
									   row  = sheet.createRow(fil-2);	
									   
									for(int col = 0; col < fila.length; col++){
										if(fila[col] == null || fila[col].trim().length()==0 ){
															if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
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
											if(tipoDato[col].trim().equalsIgnoreCase("VARCHAR2")){
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
											}else if(tipoDato[col].trim().equalsIgnoreCase("CHAR")){
												    row.createCell(col).setCellValue(new HSSFRichTextString(fila[col]));
									        }else if(tipoDato[col].trim().equalsIgnoreCase("NUMBER")){
													
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
							output = response.getOutputStream();
							wb.write(output);
							output.close();
						} catch (IOException ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}catch (Exception ex) {
							 throw new DataBaseException(ex.getClass()+" <br/>ActorDaoImpl.insert() <br/> "+ex.getMessage(),ex);
						}
				
				  }
	}	
}
