/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.RolDao;
import dao.RolDaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import model.Rol;

@ManagedBean(name = "rolBean")
@SessionScoped
public class rolBean implements Serializable {

    /**
	 * 
	 */
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
