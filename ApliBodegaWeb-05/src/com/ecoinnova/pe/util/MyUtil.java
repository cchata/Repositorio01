/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author lude
 */
public class MyUtil {
    
    public static String baseUrl()
    {
//        return "http://localhost:8080/AprendiendoJSF-04";
    	return protocol()+"://"+serverName()+":"+serverPort()+""+nombreApp();
    }

    public static String basepathlogin()
    {
        return "/AprendiendoJSF-04/faces/";
//        return "/AprendiendoJSF-04/";
    }
    
    public static String basepath()
    {
        return "/faces/views/";
//    	return "/views/";
    }
    
    public static String nombreApp()
    {//Devuelve:  /AprendiendoJSF-04
    	
        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }
    
    public static String serverName()
    {//Devuelve:localhost 
    	
        return FacesContext.getCurrentInstance().getExternalContext().getRequestServerName();
    }
    
    public static String serverPort()
    {//Devuelve: 8080,8090
    	
        return FacesContext.getCurrentInstance().getExternalContext().getRequestServerPort()+"";
    }

    public static String servletPath()
    {//Devuelve: /faces
    	
        return FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
    }

    public static String protocol()
    {//Devuelve: http
    	
        return FacesContext.getCurrentInstance().getExternalContext().getRequestScheme();
    }
    public static void systemOutPrintln(String cadena){
    	System.out.println(cadena);
    }
    
}