/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aprendemosjsf.model.Rol;


import com.aprendemosjsf.dao.*;
import com.aprendemosjsf.daoimpl.*;

@SessionScoped
@ManagedBean(name="rolBean")
public class rolBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<SelectItem> selectOneItemsRol;

    public rolBean() {
    }

    public List<SelectItem> getSelectOneItemsRol() {
        this.selectOneItemsRol = new ArrayList<SelectItem>();
        RolDao rolDao = new RolDaoImpl();
        List<Rol> roles = rolDao.selectItems();
        for (Rol rol : roles) {
            SelectItem selectItem = new SelectItem(rol.getId(), rol.getNombre());
            this.selectOneItemsRol.add(selectItem);
        }
        return selectOneItemsRol;
    }
}
