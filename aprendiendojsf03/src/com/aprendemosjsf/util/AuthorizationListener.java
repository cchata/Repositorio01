/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

public class AuthorizationListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
    	System.out.println("Despues......");
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        boolean isLoginPage = (currentPage.lastIndexOf("login.xhtml") > -1) ? true : false;
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        Object usuario = sesion.getAttribute("usuario");
        
        if (!isLoginPage && usuario == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    	System.out.println("Antes......");
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}