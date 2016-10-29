/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoinnova.pe.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import com.ecoinnova.pe.util.*;

/**
 *
 * @author lude
 */
@ManagedBean
@ApplicationScoped
public class AppUtilController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppUtilController() {
		System.out.println("Llamando al constructor AppUtilController()");
	}

	public String getBaseUrl() {
		return MyUtil.baseUrl();
	}

	public String getBasePath() {
		return MyUtil.basepath();
	}
}