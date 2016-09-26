package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Util {
	
	static private String[] param;
	static private String[] Sparam;
	public static String getFechaHora(){
		
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss a");  
        String salida="Fecha: "+formatoFecha.format(new Date());
        System.out.println(salida);
        return salida;
	}
	
	
    public static String getFechaHoraAll(){
		
    	DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,new Locale("es"));
		String fecha = df.format(new Date());
    	
        SimpleDateFormat formatoFecha=new SimpleDateFormat("hh:mm:ss a");  
        String salida=""+formatoFecha.format(new Date());
        System.out.println("Fecha"+fecha+"  "+salida);
        return fecha+"  "+salida;
	}
	
	

public static boolean isNumeric   (String cadena){
		
		boolean isint = isInteger(cadena);
		boolean isdouble = isDouble(cadena);
		if(isint==false && isdouble==false){
			
			return false;
		}else {
			
			return true;
		}
	}
	
	
	
	public static boolean isInteger(String cadena){
		try {
			if(cadena==null){
				cadena="0";
			}
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			System.out.println("Util.isInt::::::::"+cadena);
			return false;
		}
	}
	
	public static boolean isLong(String cadena){
		try {
			if(cadena==null){
				cadena="0";
			}
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException nfe){
			System.out.println("Util.isLong::::::::"+cadena);
			return false;
		}
	}
	
	public static boolean isDouble(String cadena){
		try {
			if(cadena==null){
				cadena="0.0";
			}
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			System.out.println("Util.isDouble::::::::"+cadena);
			return false;
		}
		
		
	}

	
	public static String obtenerIp(){
		String ip="";
		
		try 
		{
			String thisIp = InetAddress.getLocalHost().getHostAddress();
			System.out.println(InetAddress.getLocalHost().getHostName());
			System.out.println("IP:"+thisIp);
			ip=thisIp;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return ip;
	}
	
	
	public static String obtenerHostName(){
		String hostName="";
		
		try 
		{
			String thisHostName = InetAddress.getLocalHost().getHostName();
			System.out.println("IP_HOSTNAME:"+thisHostName);
			hostName=thisHostName;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return hostName;
	}
	
	
	public static boolean errorTipoDato(PreparedStatement pstm){
		
		try{
			System.out.println("\n 3.- paso.\n");
			ResultSet rs = pstm.executeQuery();
			
		} catch (SQLException ex) {
			return false;
			
		}catch (Exception ex) {
            System.out.println("Error Exception ex");
            return false;
		}
		
		return true;
		
	}
	
	public static  String[] arrayTxtArea(String ptxta){
		System.out.println("Pasooooooooooooooooooooo1");
		String[] array=imprimirTextArea(ptxta);
		System.out.println("Pasooooooooooooooooooooo2");
//		String Sptxta=ptxta.trim();
//		array = Sptxta.split("\n");
//		System.out.println("tamaño arrayTxtArea::: "+array.length);
//		for(int i=0;i<array.length;i++){
//			array[i] = array[i].trim();
//		}
		
		
		
		return array;
	}
	
////////////////////	
	
public static String[] imprimirTextArea(String ptxta){
		
		
		ArrayList<String> lista =new ArrayList<String>();
		lista.add(",");
		lista.add(";");
		lista.add(".");
		lista.add(":");
		lista.add("¨");
		lista.add("\'");
		lista.add("\"");
		lista.add("*");
		lista.add("!");
		lista.add("(");
		lista.add(")");
		lista.add("$");
		lista.add("%");
		lista.add("&");
		lista.add("/");
		lista.add("?");
		lista.add("¿");
		lista.add("{");
		lista.add("}");
		lista.add("[");
		lista.add("]");
		lista.add("-");
		lista.add("_");
		
		
		String Sptxta=ptxta.trim();
		System.out.println("Pasooooooooooooooooooooo3");
		String[]  array = null;
		if(Sptxta.split("\n").length > 1){
			array = Sptxta.split("\n");
		}else{ 
			System.out.println("Pasooooooooooooooooooooo4");
			Sptxta = Sptxta.replace("  ", " ");
			Sptxta = Sptxta.replace("   ", " ");
			Sptxta = Sptxta.replace("    ", " ");
			Sptxta = Sptxta.replace("     ", " ");
			Sptxta = Sptxta.replace("      ", " ");
			Sptxta = Sptxta.replace("       ", " ");
			Sptxta = Sptxta.replace("        ", " ");
			System.out.println("Pasooooooooooooooooooooo5");
			if(Sptxta.split(" ").length > 1){
			     array = Sptxta.split(" ");
		     }else if(Sptxta.split(",").length > 1){
		    	 array = Sptxta.split(","); 
		    	 System.out.println("Pasooooooooooooooooooooo6");
		     }else if(Sptxta.split(",").length == 1){
		    	 System.out.println("array.length:  "+array==null?"NULL":" ");
		    	 System.out.println("paso1234:  "+Sptxta);
		    	 String[] temp ={Sptxta};
		    	 array = temp;
		     }
			}
		System.out.println("tamaño:: "+array.length);
	
		
		
		for(int i=0;i<array.length;i++){
			array[i] = array[i].trim();
			System.out.println(array[i]);
			for(int j=0;j<lista.size();j++){
				array[i] = array[i].replace(lista.get(j), "");
				System.out.println("-"+array[i]);
			}
		}
		
		
		for(String txt : array){
			System.out.print(txt+" $$$ ");
		}
		
		
	return array;
	    
		
	}
////////////////
	

	public static boolean buscarCadena(String pcadena, String pbuscar){
		
		boolean presencia = pcadena.contains(pbuscar); 
		
		return presencia;
	}
	
	
	public static String getEtiqueta(String pcadenaS){
		
//		String cadenaS="<span class='required_notification'>* Datos requeridos</span>  <label>hola mundo nettalco</label>";
		String cadenaBusar = "<label>";
		int longCadenaBuscar = cadenaBusar.length(); 
		 
		int inicio = pcadenaS.indexOf(cadenaBusar);
		int fin = pcadenaS.indexOf("</label>", inicio + longCadenaBuscar);
		
		 return pcadenaS.substring(inicio + longCadenaBuscar,fin );
	}
	
	
	public static String isTipoDato(String cadenahtml){
		String mensaje="";
		
		String cadena99="type=\"number\"";
//        System.out.println(cadena99.lastIndexOf("\"number\""));//8
//        System.out.println(cadena99.lastIndexOf("\"string\""));//8
//        System.out.println(cadena99.lastIndexOf("\"date\""));//6
		int posicionCadena99 = cadena99.lastIndexOf("\"number\"");
		String substringcadena=cadena99.substring(posicionCadena99,posicionCadena99+8);
//		System.out.println("---------"+substringcadena);
		
		String salidaString=cadenahtml.replace("\"string\"", "");
		String salidaNumber=cadenahtml.replace("\"number\"", "");
		String salidaDate=cadenahtml.replace("\"date\"", "");
		if(cadenahtml.length() >salidaString.length()){
			mensaje = "string";
//			System.out.println("String-----------------------");
		}else if(cadenahtml.length() >salidaNumber.length()){
			mensaje = "number";
//			System.out.println("Number-----------------------");
		}else if(cadenahtml.length() >salidaDate.length()){
//			System.out.println("Date-----------------------");
			mensaje = "date";
		}
		return mensaje;
	}
	
	
	
	public static String getHtmla(String Shtml){
		System.out.println(Shtml); 
        String[] arrayp = Shtml.split("\"txta\"");

        
        /****REQUIRED*****/
        //
        
        boolean[] required = new boolean[arrayp.length-1];
        boolean[] value =    new boolean[arrayp.length-1];
        String[] valueDefault = new String[arrayp.length-1];
        System.out.println("paso1");
        for(int i=1; i<arrayp.length;i++){
        	required[i-1] = arrayp[i].trim().startsWith("required");
        	System.out.println("paso2");
        	
        	if(arrayp[i].trim().startsWith("required") == true){
        		System.out.println("paso3");
//        		value[i-1] =    arrayp[i].trim().substring(8).startsWith("value");
        		if(arrayp[i].trim().substring(8).trim().startsWith("value")==true){//SI hay valor default
        			
        			int m = arrayp[i].trim().substring(8).trim().substring(5).trim().substring(1).split("/>")[0].trim().split("\"").length;
        			valueDefault[i-1] = m!=0?arrayp[i].trim().substring(8).trim().substring(5).trim().substring(1).split("/>")[0].trim().split("\"")[1].trim():"";
//           		valueDefault[i-1] = arrayp[i].trim().substring(8).trim().substring(5).trim().substring(1).split("/>")[0].trim().split("\"")[1].trim();
           	 }
        	}else{
        		System.out.println("paso4");
//        		value[i-1] =    arrayp[i].trim().startsWith("value");
        		if(arrayp[i].trim().trim().startsWith("value")==true){//SI hay valor default
        			int m = arrayp[i].trim().trim().substring(5).trim().substring(1).split("/>")[0].trim().split("\"").length;
                    valueDefault[i-1] = m!=0?arrayp[i].trim().trim().substring(5).trim().substring(1).split("/>")[0].trim().split("\"")[1].trim():"";
           	 }
        		System.out.println("paso5");
        	}
        	
        	System.out.println("paso6");
        	
       	 
        }
        /****FIN*****/
        
        /****VALUE*****/
        
        
        
        /****FIN*****/
        
		ArrayList<String> arrayList=new ArrayList<String>();
		ArrayList<String> arraytipoDato=new ArrayList<String>();
		int posicion_temp=0;
		String cadena_temp="";
		for(int i=0;i<arrayp.length;i++){
			arrayList.add(arrayp[i].trim());
		}
		 
		for(int i=0;i<arrayList.size()-1;i++){
			posicion_temp = arrayList.get(i).lastIndexOf("<input");
			cadena_temp = arrayList.get(i).substring(posicion_temp);
			arraytipoDato.add(Util.isTipoDato(cadena_temp));
		}
		
		
		for(int i=0;i<arrayList.size()-1;i++){
			posicion_temp = arrayList.get(i).lastIndexOf("<input");
			cadena_temp = arrayList.get(i).substring(0,posicion_temp);
			arrayList.set(i, cadena_temp);
		}
		
		for(int i=1;i<arrayList.size();i++){
			posicion_temp = arrayList.get(i).indexOf("/>");
			cadena_temp = arrayList.get(i).substring(posicion_temp+2,arrayList.get(i).length());
			arrayList.set(i, cadena_temp);
		}
		

		String textArea = "";
		int n = 0;
		String valor="";
		for(String tipodato : arraytipoDato){
			
			if(tipodato.equalsIgnoreCase("string")){
				System.out.println("paso-1-");
				if(required[n]==true){
					
					valor = valueDefault[n]==null?"":valueDefault[n];
					System.out.println("paso-2-: "+valor);
					textArea="<textarea id=\"textString1\" rows=\"6\" cols=\"220\" name=\"txta\" autofocus required  onmousemove=\"trimSpaces1()\">"+valor+"</textarea>";
				}else{
					valor = valueDefault[n]==null?"":valueDefault[n];
					System.out.println("paso-3-: "+valor);
					textArea="<textarea id=\"textString1\" rows=\"6\" cols=\"220\" name=\"txta\" autofocus  onmousemove=\"trimSpaces1()\">"+valor+"</textarea>";
				}
			}
            if(tipodato.equalsIgnoreCase("number")){
            	
            	
            	if(required[n]==true){ 
            		valor = valueDefault[n]==null?"":valueDefault[n];
            		textArea="<textarea                    rows=\"6\" cols=\"220\"  name=\"txta\" autofocus required  onmousemove=\"trimSpaces1()\" onkeypress=\"return validarNumber(event,'letra')\">"+valor+"</textarea>";
				}else{ 
					valor = valueDefault[n]==null?"":valueDefault[n];
					textArea="<textarea                    rows=\"6\" cols=\"220\"  name=\"txta\" autofocus onmousemove=\"trimSpaces1()\" onkeypress=\"return validarNumber(event,'letra')\">"+valor+"</textarea>";
				}
            	
			}
            if(tipodato.equalsIgnoreCase("date")){
            	System.out.println("----3----");
            	textArea="No definido...";
			}
            n++;
		}

		String html="";
		for(int i=0;i<arrayList.size();i++){
			   	
			if(i==0){
				System.out.println("----4----");
				html += arrayList.get(i);
			}else if(i>0){
				
				if(arraytipoDato.get(i-1).equalsIgnoreCase("string")){
					if(required[i-1]==true){
						valor = valueDefault[i-1]==null?"":valueDefault[i-1];
						textArea="<textarea id=\"textString1\" rows=\"6\" cols=\"220\" name=\"txta\" autofocus  required onmousemove=\"trimSpaces1()\">"+valor+"</textarea>";	
					}else{
						valor = valueDefault[i-1]==null?"":valueDefault[i-1];
						textArea="<textarea id=\"textString1\" rows=\"6\" cols=\"220\" name=\"txta\" autofocus           onmousemove=\"trimSpaces1()\">"+valor+"</textarea>";
					}
					
					html += textArea + arrayList.get(i);
				} else
	            if(arraytipoDato.get(i-1).equalsIgnoreCase("number")){
	            	if(required[i-1]==true){
	            		valor = valueDefault[i-1]==null?"":valueDefault[i-1];
	            		textArea="<textarea  rows=\"6\" cols=\"220\" name=\"txta\" autofocus required  onmousemove=\"trimSpaces1()\" onkeypress=\"return validarNumber(event,'letra')\">"+valor+"</textarea>";	
					}else{
						valor = valueDefault[i-1]==null?"":valueDefault[i-1];
						textArea="<textarea  rows=\"6\" cols=\"220\" name=\"txta\" autofocus  onmousemove=\"trimSpaces1()\" onkeypress=\"return validarNumber(event,'letra')\">"+valor+"</textarea>";
					}
	            	
	            	
	            	html += textArea + arrayList.get(i);
				} else
	            if(arraytipoDato.get(i-1).equalsIgnoreCase("date")){System.out.println("----7----");
	            	textArea="No definido...";
	            	html += textArea + arrayList.get(i);
				}
			}
		}
		return html;
	}

	
	
	
	
	
	
	
	public static boolean searchIN(String subquery){
		boolean mensaje = false ;
		
		 String cadenaLimp="";
	      for(int i=0; i<subquery.length();i++){
	    	  if(subquery.charAt(i)!=')'){
	    		  cadenaLimp += subquery.charAt(i); 
	    	  }else{
	    		  cadenaLimp += subquery.charAt(i);
	    		  break;
	    	  }
	      }
//	      System.out.println("= "+cadenaLimp);
	      		
	      for(int i=0;i<cadenaLimp.length();i++){
	    	  
	    	  if(cadenaLimp.charAt(i)=='?'){
	    		  System.out.println("se encontro :?");
	    		  
	    		  mensaje = true; 
	    	  }
	      }
		
		return mensaje;
	}
	
	
	public static float[] dimension(int numCols, int [] pdimensiones){
		float[] medidaCeldas =new float[numCols];
		for(int i = 0; i < pdimensiones.length; i++ ){
			
			switch(pdimensiones[i]){
			
			case 1: medidaCeldas[i] = 0.05f;  break;
			case 2: medidaCeldas[i] = 0.10f;  break;
			case 3: medidaCeldas[i] = 0.15f;  break;
			case 4: medidaCeldas[i] = 0.20f;  break;
			
			case 5: medidaCeldas[i] = 0.25f;  break;
			case 6: medidaCeldas[i] = 0.30f;  break;
			case 7: medidaCeldas[i] = 0.35f;  break;
			case 8: medidaCeldas[i] = 0.40f;  break;
			
			case 9: medidaCeldas[i] = 0.45f;  break;
			case 10: medidaCeldas[i] = 0.50f;  break;
			case 11: medidaCeldas[i] = 0.55f;  break;
			case 12: medidaCeldas[i] = 0.60f;  break;
			
			case 13: medidaCeldas[i] = 0.65f;  break;
			case 14: medidaCeldas[i] = 0.70f;  break;
			case 15: medidaCeldas[i] = 0.75f;  break;
			case 16: medidaCeldas[i] = 0.80f;  break;
			
			case 17: medidaCeldas[i] = 0.85f;  break;
			case 18: medidaCeldas[i] = 0.90f;  break;
			case 19: medidaCeldas[i] = 0.95f;  break;
			case 20: medidaCeldas[i] = 1.00f;  break;
			
			case 21: medidaCeldas[i] = 1.05f;  break;
			case 22: medidaCeldas[i] = 1.10f;  break;
			case 23: medidaCeldas[i] = 1.15f;  break;
			case 24: medidaCeldas[i] = 1.20f;  break;
			
			case 25: medidaCeldas[i] = 1.25f;  break;
			case 26: medidaCeldas[i] = 1.30f;  break;
			case 27: medidaCeldas[i] = 1.35f;  break;
			case 28: medidaCeldas[i] = 1.40f;  break;
			
			case 29: medidaCeldas[i] = 1.45f;  break;
			case 30: medidaCeldas[i] = 1.50f;  break;
			
			default: medidaCeldas[i] = 0.50f;  break;
			}
		}
		return medidaCeldas;
		
		
	}
	
	public static float[] getMedidasCeldas(int[] pmedidaceldas, String ptipoDeDatos[] ){
		
		float[] medidaCeldas =new float[pmedidaceldas.length];//Se devuelve
		int[] ImedidaCeldas = new   int[pmedidaceldas.length];
		ImedidaCeldas = pmedidaceldas;
		String[] tipoDeDatos = ptipoDeDatos;
		
		float longitudCelda = 0.15f;
		for (int i = 0; i < pmedidaceldas.length; i++) {
			
			switch(ImedidaCeldas[i]){
			
			case 1: 
		        medidaCeldas[i] = 0.10f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda; 
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 2: 
		        medidaCeldas[i] = 0.11f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda; 
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 3: 
		        medidaCeldas[i] = 0.12f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 4: 
		        medidaCeldas[i] = 0.13f;
		        System.out.println("Paso:::::::::::::::::::::::");
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				System.out.println("Paso:::::::::::::::::::::::");
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 5: 
		        medidaCeldas[i] = 0.14f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 6: 
		        medidaCeldas[i] = 0.15f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 7: 
		        medidaCeldas[i] = 0.16f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 8: 
		        medidaCeldas[i] = 0.17f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 9: 
		        medidaCeldas[i] = 0.18f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 10: 
		        medidaCeldas[i] = 0.19f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;			
			
			/******/
			case 11: 
		        medidaCeldas[i] = 0.20f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda; 
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 12: 
		        medidaCeldas[i] = 0.21f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 13: 
		        medidaCeldas[i] = 0.21f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 14: 
		        medidaCeldas[i] = 0.23f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 15: 
		        medidaCeldas[i] = 0.24f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 16: 
		        medidaCeldas[i] = 0.25f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 17: 
		        medidaCeldas[i] = 0.26f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 18: 
		        medidaCeldas[i] = 0.27f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 19: 
		        medidaCeldas[i] = 0.28f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 20: 
		        medidaCeldas[i] = 0.29f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 21: 
		        medidaCeldas[i] = 0.30f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 22: 
		        medidaCeldas[i] = 0.31f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 23: 
		        medidaCeldas[i] = 0.32f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 24: 
		        medidaCeldas[i] = 0.33f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 25: 
		        medidaCeldas[i] = 0.34f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 26: 
		        medidaCeldas[i] = 0.35f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 27: 
		        medidaCeldas[i] = 0.36f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 28: 
		        medidaCeldas[i] = 0.37f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 29: 
		        medidaCeldas[i] = 0.38f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 30: 
		        medidaCeldas[i] = 0.39f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 31: 
		        medidaCeldas[i] = 0.40f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 32: 
		        medidaCeldas[i] = 0.41f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 33: 
		        medidaCeldas[i] = 0.42f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 34: 
		        medidaCeldas[i] = 0.43f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 35: 
		        medidaCeldas[i] = 0.44f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 36: 
		        medidaCeldas[i] = 0.45f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 37: 
		        medidaCeldas[i] = 0.46f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 38: 
		        medidaCeldas[i] = 0.47f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 39: 
		        medidaCeldas[i] = 0.48f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 40: 
		        medidaCeldas[i] = 0.49f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 41: 
		        medidaCeldas[i] = 0.50f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 42: 
		        medidaCeldas[i] = 0.51f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 43: 
		        medidaCeldas[i] = 0.52f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 44: 
		        medidaCeldas[i] = 0.53f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 45: 
		        medidaCeldas[i] = 0.54f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 46: 
		        medidaCeldas[i] = 0.55f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 47: 
		        medidaCeldas[i] = 0.56f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 48: 
		        medidaCeldas[i] = 0.57f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 49: 
		        medidaCeldas[i] = 0.58f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 50: 
		        medidaCeldas[i] = 0.59f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			/******/
			case 51: 
		        medidaCeldas[i] = 0.60f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 52: 
		        medidaCeldas[i] = 0.61f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 53: 
		        medidaCeldas[i] = 0.62f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 54: 
		        medidaCeldas[i] = 0.63f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 55: 
		        medidaCeldas[i] = 0.64f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 56: 
		        medidaCeldas[i] = 0.65f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 57: 
		        medidaCeldas[i] = 0.66f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 58: 
		        medidaCeldas[i] = 0.67f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 59: 
		        medidaCeldas[i] = 0.68f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 60: 
		        medidaCeldas[i] = 0.69f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			/******/
			case 61: 
		        medidaCeldas[i] = 0.70f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 62: 
		        medidaCeldas[i] = 0.71f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 63: 
		        medidaCeldas[i] = 0.72f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda; 
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 64: 
		        medidaCeldas[i] = 0.73f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 65: 
		        medidaCeldas[i] = 0.74f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 66: 
		        medidaCeldas[i] = 0.75f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 67: 
		        medidaCeldas[i] = 0.76f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 68: 
		        medidaCeldas[i] = 0.77f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 69: 
		        medidaCeldas[i] = 0.78f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 70: 
		        medidaCeldas[i] = 0.79f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
					
			/******/
			case 71: 
		        medidaCeldas[i] = 0.80f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 72: 
		        medidaCeldas[i] = 0.81f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 73: 
		        medidaCeldas[i] = 0.82f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 74: 
		        medidaCeldas[i] = 0.83f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 75: 
		        medidaCeldas[i] = 0.84f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 76: 
		        medidaCeldas[i] = 0.86f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 77: 
		        medidaCeldas[i] = 0.87f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 78: 
		        medidaCeldas[i] = 0.88f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 79: 
		        medidaCeldas[i] = 0.89f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 80: 
		        medidaCeldas[i] = 0.90f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			
			/******/
			case 81: 
		        medidaCeldas[i] = 0.91f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 82: 
		        medidaCeldas[i] = 0.92f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 83: 
		        medidaCeldas[i] = 0.93f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 84: 
		        medidaCeldas[i] = 0.94f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 85: 
		        medidaCeldas[i] = 0.95f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 86: 
		        medidaCeldas[i] = 0.96f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 87: 
		        medidaCeldas[i] = 0.97f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 88: 
		        medidaCeldas[i] = 0.98f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 89: 
		        medidaCeldas[i] = 0.99f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 90: 
		        medidaCeldas[i] = 1.00f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			
			/******/
			case 91: 
		        medidaCeldas[i] = 1.11f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 92: 
		        medidaCeldas[i] = 1.12f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 93: 
		        medidaCeldas[i] = 1.13f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 94: 
		        medidaCeldas[i] = 1.14f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 95: 
		        medidaCeldas[i] = 1.15f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 96: 
		        medidaCeldas[i] = 1.16f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 97: 
		        medidaCeldas[i] = 1.17f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 98: 
		        medidaCeldas[i] = 1.18f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 99: 
		        medidaCeldas[i] = 1.19f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 100: 
		        medidaCeldas[i] = 1.20f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			/**********100************/
			
			case 101: 
		        medidaCeldas[i] = 1.21f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 102: 
		        medidaCeldas[i] = 1.21f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 103: 
		        medidaCeldas[i] = 1.22f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 104: 
		        medidaCeldas[i] = 1.23f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 105: 
		        medidaCeldas[i] = 1.24f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 106: 
		        medidaCeldas[i] = 1.25f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 107: 
		        medidaCeldas[i] = 1.26f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 108: 
		        medidaCeldas[i] = 1.27f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 109: 
		        medidaCeldas[i] = 1.28f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 110: 
		        medidaCeldas[i] = 1.29f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;	
			
			/******/
			case 111: 
		        medidaCeldas[i] = 1.30f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 112: 
		        medidaCeldas[i] = 1.31f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 113: 
		        medidaCeldas[i] = 1.31f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break; 
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 114: 
		        medidaCeldas[i] = 1.33f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 115: 
		        medidaCeldas[i] = 1.34f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 116: 
		        medidaCeldas[i] = 1.35f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 117: 
		        medidaCeldas[i] = 1.36f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 118: 
		        medidaCeldas[i] = 1.37f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 119: 
		        medidaCeldas[i] = 1.38f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 120: 
		        medidaCeldas[i] = 1.39f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 121: 
		        medidaCeldas[i] = 1.40f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 122: 
		        medidaCeldas[i] = 1.41f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 123: 
		        medidaCeldas[i] = 1.42f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 124: 
		        medidaCeldas[i] = 1.43f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 125: 
		        medidaCeldas[i] = 1.44f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 126: 
		        medidaCeldas[i] = 1.45f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break; 
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 127: 
		        medidaCeldas[i] = 1.46f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 128: 
		        medidaCeldas[i] = 1.47f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 129: 
		        medidaCeldas[i] = 1.48f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 130: 
		        medidaCeldas[i] = 1.49f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 131: 
		        medidaCeldas[i] = 1.50f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 132: 
		        medidaCeldas[i] = 1.51f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 133: 
		        medidaCeldas[i] = 1.52f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 134: 
		        medidaCeldas[i] = 1.53f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 135: 
		        medidaCeldas[i] = 1.54f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 136: 
		        medidaCeldas[i] = 1.55f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 137: 
		        medidaCeldas[i] = 1.56f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 138: 
		        medidaCeldas[i] = 1.57f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 139: 
		        medidaCeldas[i] = 1.58f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 140: 
		        medidaCeldas[i] = 1.59f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			/******/
			case 141: 
		        medidaCeldas[i] = 1.60f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 142: 
		        medidaCeldas[i] = 1.61f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 143: 
		        medidaCeldas[i] = 1.62f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 144: 
		        medidaCeldas[i] = 1.63f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 145: 
		        medidaCeldas[i] = 1.64f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 146: 
		        medidaCeldas[i] = 1.65f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 147: 
		        medidaCeldas[i] = 1.66f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 148: 
		        medidaCeldas[i] = 1.67f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break; 
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 149: 
		        medidaCeldas[i] = 1.68f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 150: 
		        medidaCeldas[i] = 1.69f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			/******/
			case 151: 
		        medidaCeldas[i] = 1.70f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 152: 
		        medidaCeldas[i] = 1.71f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 153: 
		        medidaCeldas[i] = 1.72f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 154: 
		        medidaCeldas[i] = 1.73f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 155: 
		        medidaCeldas[i] = 1.74f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 156: 
		        medidaCeldas[i] = 1.75f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 157: 
		        medidaCeldas[i] = 1.76f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 158: 
		        medidaCeldas[i] = 1.77f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 159: 
		        medidaCeldas[i] = 1.78f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 160: 
		        medidaCeldas[i] = 1.79f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			/******/
			case 161: 
		        medidaCeldas[i] = 1.80f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 162: 
		        medidaCeldas[i] = 1.81f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 163: 
		        medidaCeldas[i] = 1.82f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 164: 
		        medidaCeldas[i] = 1.83f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 165: 
		        medidaCeldas[i] = 1.84f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 166: 
		        medidaCeldas[i] = 1.85f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 167: 
		        medidaCeldas[i] = 1.86f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 168: 
		        medidaCeldas[i] = 1.87f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 169: 
		        medidaCeldas[i] = 1.88f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 170: 
		        medidaCeldas[i] = 1.89f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
					
			/******/
			case 171: 
		        medidaCeldas[i] = 1.90f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 172: 
		        medidaCeldas[i] = 1.91f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 173: 
		        medidaCeldas[i] = 1.92f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			case 174: 
		        medidaCeldas[i] = 1.93f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 175: 
		        medidaCeldas[i] = 1.94f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 176: 
		        medidaCeldas[i] = 1.95f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 177: 
		        medidaCeldas[i] = 1.96f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 178: 
		        medidaCeldas[i] = 1.97f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 179: 
		        medidaCeldas[i] = 1.98f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 180: 
		        medidaCeldas[i] = 1.99f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			
			/******/
			case 181: 
		        medidaCeldas[i] = 2.00f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 182: 
		        medidaCeldas[i] = 2.01f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 183: 
		        medidaCeldas[i] = 2.02f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 184: 
		        medidaCeldas[i] = 2.03f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 185: 
		        medidaCeldas[i] = 2.04f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 186: 
		        medidaCeldas[i] = 2.05f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 187: 
		        medidaCeldas[i] = 2.06f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 188: 
		        medidaCeldas[i] = 2.07f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 189: 
		        medidaCeldas[i] = 2.08f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 190: 
		        medidaCeldas[i] = 2.09f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;

			
			/******/
			case 191: 
		        medidaCeldas[i] = 2.10f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 192: 
		        medidaCeldas[i] = 2.11f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 193: 
		        medidaCeldas[i] = 2.12f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 194: 
		        medidaCeldas[i] = 2.13f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 195: 
		        medidaCeldas[i] = 2.14f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 196: 
		        medidaCeldas[i] = 2.15f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 197: 
		        medidaCeldas[i] = 2.16f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 198: 
		        medidaCeldas[i] = 2.17f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 199: 
		        medidaCeldas[i] = 2.18f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			case 200: 
		        medidaCeldas[i] = 2.19f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			default: medidaCeldas[i] = 2.50f;
			if(tipoDeDatos[i].equalsIgnoreCase("NUMBER") ||  tipoDeDatos[i].equalsIgnoreCase("CHAR") || tipoDeDatos[i].equalsIgnoreCase("NUMERIC") || tipoDeDatos[i].equalsIgnoreCase("FLOAT")){
				medidaCeldas[i] = longitudCelda;
				break;
			}else if(tipoDeDatos[i].equalsIgnoreCase("DATE")){
				medidaCeldas[i] = 0.35f;
				break;
			}break;
			
			
			}
			
		}
		return medidaCeldas;
	}
	
	public static String filtrarInValores(ArrayList<String> paramArray, String despuesDelWhere){
		 String[] arrayQuery = despuesDelWhere.trim().split(" in");
		
		

		 /********INICIO**********/
		
		boolean[] TextAConValores = new boolean[paramArray.size()];
		String newQuery ="";
		int cont = 0;
		for(String s:paramArray){
			if(s.length()==2){
				System.out.println(""+s+": logitud: "+s.length());
				TextAConValores[cont]=false;
			}else{
				System.out.println(""+s+": logitud: "+s.length());
				TextAConValores[cont]=true;
			}
			cont++;
		}
		
		/*********FIN************/
		
		 String[] arrayFinal = new String[TextAConValores.length+1];
		 String[] arrayTemp = new String[2];
		 System.out.println("----------"+TextAConValores.length);
		 System.out.println("----------"+arrayQuery.length);
//		 
		 for(int i=0;i<TextAConValores.length;i++){
			 arrayTemp[0] = arrayQuery[i];
			 arrayTemp[1] = arrayQuery[i+1];
			 
			 arrayTemp = Util.cadena(arrayTemp, TextAConValores[i]);
			 arrayQuery[i] = arrayTemp[0];//update
			 arrayQuery[i+1] = arrayTemp[1];//update
			 
			 arrayFinal[i] = arrayTemp[0];
			 arrayFinal[i+1] = arrayTemp[1];
		 }
		 for(int i=0; i<arrayFinal.length;i++){
			 newQuery = newQuery+" "+arrayFinal[i];
			 System.out.println((i+1)+".-"+arrayFinal[i]);
		 }
		 
		 return newQuery;
		
	}
	public static String[] cadena(String[] arrayQuery, boolean TextAConValo){
		String[] array = null;
		boolean z = false;
		if(!TextAConValo){
			 int i;
			 for(i=0; i<arrayQuery.length-1;i++){
				  if(i==0 && !arrayQuery[i].trim().contains("and ")){
					  arrayQuery[i] =  " ";
					  z = true;
					  continue;
				  }
					 arrayQuery[i] = arrayQuery[i].substring(0,arrayQuery[i].lastIndexOf("and")).trim();
			 }       arrayQuery[i] = arrayQuery[i].trim();
			 
			 
			 
			 int a=0;
			 for(String s:arrayQuery){
				 a++;
			 }
			 for(i=1; i<arrayQuery.length;i++){
				 arrayQuery[i] = arrayQuery[i].trim().substring(3).trim();
                if(i==1 && z){
                	arrayQuery[i] = arrayQuery[i].trim().substring(3).trim();
				  }
			 }
			 
			 for(String s:arrayQuery){
				 System.out.println((a+1)+".- #"+s);
				 a++;
			 }
		}else{
			   arrayQuery[0] = arrayQuery[0] + " in";
		}
		 
		 array = arrayQuery;
		
		return array;
	}
	
	public static String filtrarBetween(String query, String[] arrayP){
		String salida = "";
		
		String[] arrayBetween = query.split("between");
		System.out.println("arrayBetween::: "+arrayBetween.length);
		
		if(arrayBetween.length>1){
			
										boolean[] txtconValor = new boolean[arrayP.length];
										String[] parametros = new String[arrayP.length];
										
										for(int i=0; i<arrayP.length;i++){
											parametros[i]=arrayP[i];
											if(arrayP[i].trim().length()==0){
												txtconValor[i] = false;
											}else{
												txtconValor[i] = true;
												
											}
										}
										
										/////////////////
										
										List<Integer> posicion2 = new ArrayList<Integer>();	
										int posicionActual =0;
										boolean e = false;
										for(int i=0; i<arrayBetween.length; i++){
											for(int j=0; j<arrayBetween[i].length();j++){
												if(arrayBetween[i].charAt(j)=='?'){
													posicionActual++;
													if(e==false){
														posicion2.add(posicionActual);	
													}
													e = true;
												}
											}
											if(e==false){
												posicion2.add(0);
											}
											e=false;//actualizar
										}
										System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
										for(Integer s: posicion2){
											System.out.println("Posicion:::"+s);
										}
										System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
										//////////////////////
										String cadena = "";
										
										
										
										
										for(int i=1; i<arrayBetween.length; i++){
											if(txtconValor[posicion2.get(i)-1]==true && txtconValor[posicion2.get(i)]==true){
												//No hacer nada
												
												if(i==1){
							//						cadena = arrayBetween[0].trim();
													arrayBetween[0] = arrayBetween[0].trim();
												}
							//					cadena = cadena + " between "+arrayBetween[i];
												arrayBetween[i]  =  " between "+arrayBetween[i];
											}else{
															if(i==1){
							//									cad = arrayBetween[0].substring(0,(" "+arrayBetween[0].trim()).lastIndexOf(" ")).toString().trim();
																arrayBetween[i-1] = arrayBetween[i-1].substring(0,(" "+arrayBetween[i-1].trim()).lastIndexOf(" ")).toString().trim();
																arrayBetween[i-1] = arrayBetween[i-1].substring(0, arrayBetween[i-1].length());
																parametros[posicion2.get(i)-1]="***";
																parametros[posicion2.get(i)]="***";
															}else{
																if(i<arrayBetween.length-1){
																	arrayBetween[i-1] = arrayBetween[i-1].substring(0,(" "+arrayBetween[i-1].trim()).lastIndexOf(" ")).toString().trim();
																	arrayBetween[i-1] = arrayBetween[i-1].substring(0, arrayBetween[i-1].length());
																	parametros[posicion2.get(i)-1]="***";
																	parametros[posicion2.get(i)]="***";
																}else{
																	arrayBetween[i-1] = arrayBetween[i-1].substring(0,(" "+arrayBetween[i-1].trim()).lastIndexOf(" ")).toString().trim();
																	arrayBetween[i-1] = arrayBetween[i-1].substring(0, arrayBetween[i-1].length()-3);
																	parametros[posicion2.get(i)-1]="***";
																	parametros[posicion2.get(i)]="***";
																}
															}
															
															String[] temp = arrayBetween[i].split(" and");
															if(temp.length == 2){
							//									cadena = cadena + cad+" "+temp[0].trim().substring(1) +" "+temp[1].trim().substring(1) ;	
																arrayBetween[i] =" "+temp[0].trim().substring(1) +" "+temp[1].trim().substring(1) ;
							//									arrayBetween[i] = arrayBetween[i].substring(0,arrayBetween[i].length());
															}else if(temp.length > 2){
							//									cadena = cadena + cad+" "+temp[0].trim().substring(1) +" "+temp[1].trim().substring(1) ;
																arrayBetween[i] = " "+temp[0].trim().substring(1) +" "+temp[1].trim().substring(1) ;
																String tempo = "";
																for(int n=2;n<temp.length;n++){
																	if(n==2){
																		tempo+=" "+temp[n]+" ";
																		continue;
																	}
																	    tempo+=" AND "+temp[n]+" ";
																}
							//									cadena = cadena +" "+ tempo+" ";
																arrayBetween[i] = " "+ tempo+" ";
															}
															 
															//Quitar el between
											}
											Util.setParam(parametros);
										}
										
										for(String s: arrayBetween){
								     		salida += s + " ";
										} 
		}else{
			salida = query;
			Util.setParam(arrayP);
			
		}
		
		
		
		return salida;
	}


	public static String[] getParam() {
		return param;
	}


	public static void setParam(String[] param) {
		Util.param = param;
	}
	
	
	
	public static String[] getSparam() {
		return Sparam;
	}


	public static void setSparam(String[] sparam) {
		Sparam = sparam;
	}


	public static boolean existeInterogacion(String Sparam){
		boolean salida = false;
		for(int i=0;i<Sparam.length();i++){
			if(Sparam.charAt(i)=='?'){
				salida = true;
				break;
			}
		}
		return salida;
	}
	
	
	public static String filtrarTxtSinValor(String despuesDelWhere, String[] pSparam){
		String salida = "";
		System.out.println("--1ok--"+despuesDelWhere);
		String despuesDelWhereTemp = despuesDelWhere.toLowerCase();
		String[] despuesDelWhereArray = despuesDelWhereTemp.split("and ");
		List<String> listaQueryConBetween = new ArrayList<String>();
		System.out.println("--2ok--"+despuesDelWhereArray[0]+" :     "+despuesDelWhereArray.length);
		
		int contadorParamTxt = 0;
		for(int i =0; i<despuesDelWhereArray.length; i++){

			if(despuesDelWhereArray[i].contains(" between") ){
				
				if(Util.existeInterogacion(despuesDelWhereArray[i].trim())){
					
					if(i==0){
						listaQueryConBetween.add(despuesDelWhereArray[i]+" and ?");
					}else{
						listaQueryConBetween.add(" and "+despuesDelWhereArray[i]+" and ?");	
					}
					i++;
					contadorParamTxt ++;
					contadorParamTxt ++;
				}else{
					if(i==0){
						listaQueryConBetween.add(despuesDelWhereArray[i]+" and "+despuesDelWhereArray[i+1]);
					}else{
						listaQueryConBetween.add(" and "+despuesDelWhereArray[i]+" and "+despuesDelWhereArray[i+1]);	
					}
					i++;
				}
				
				
			}else{
				if(i==0){
					System.out.println("Paso---------------");
					if(Util.existeInterogacion(despuesDelWhereArray[i].trim())){
						System.out.println("Paso-2-------------");
						if(pSparam[contadorParamTxt].trim().length()==0){
							System.out.println("Paso-3-------------");
							listaQueryConBetween.add("  ");
						}else{
							System.out.println("Paso-4-------------");
							listaQueryConBetween.add(despuesDelWhereArray[i]);	
						}
						contadorParamTxt ++;
					}else{
						    listaQueryConBetween.add(despuesDelWhereArray[i]);
					}
					

				}else{
					if(Util.existeInterogacion(despuesDelWhereArray[i].trim())){
						if(pSparam[contadorParamTxt].trim().length()==0){
							listaQueryConBetween.add("  ");
						}else{
							listaQueryConBetween.add(" and "+despuesDelWhereArray[i]);	
						}	
						contadorParamTxt ++;
					}else{
						listaQueryConBetween.add(" and "+despuesDelWhereArray[i]);
					}
					
					
				}
			}
		}
		System.out.println("--3ok--"+listaQueryConBetween.size());
//		System.out.println("listaQuery.size()="+listaQueryConBetween.size());
		for(String s:listaQueryConBetween){
			salida = salida +" "+s;
		}
		System.out.println("$$$$$$$$$$$$$$$$$-Inicio-$$$$$$$$$$$$$$$$$$$$");
		System.out.println(salida);
		System.out.println("$$$$$$$$$$$$$$$$$-Fin-$$$$$$$$$$$$$$$$$$$$");
		
		
		if(salida.trim().length()>0){
			if(salida.trim().substring(0,4).equalsIgnoreCase("and ")){
				 salida = salida.trim().substring(3);	
			    }	
		}else{
			System.out.println("Hay que quitar el WHERE");
		}
		 
		    
		Sparam = Util.updateSparam(pSparam);
		System.out.println("Sparam: "+Sparam==null?"null":"no null = "+Sparam.length);
		
		
		return salida;
	}
		public static  String[] updateSparam(String[] Sparam ){
			List<String> listaParam = new ArrayList<String>();
			int index=0;
			while(index < Sparam.length){
				if(Sparam[index].trim().length() > 0){
					listaParam.add(Sparam[index]);
				}
				index++;	
			}
			
			index=0;
			String[] salida = new String[listaParam.size()];
			for(String s: listaParam){
				salida[index]=s;
				index++;
			}
			
			
			
			
			return salida;
		}
	
}


