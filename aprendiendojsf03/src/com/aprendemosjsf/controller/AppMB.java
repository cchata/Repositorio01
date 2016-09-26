package com.aprendemosjsf.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.aprendemosjsf.util.MyUtil;

@SessionScoped
@ManagedBean(name = "appMB")
public class AppMB implements Serializable {

	private static final long serialVersionUID = 1L;

	public AppMB() {
	}

	public String getBaseUrl() {
		return MyUtil.baseurl();
	}

	public String getBasePath() {
		return MyUtil.basepath();
	}
}
