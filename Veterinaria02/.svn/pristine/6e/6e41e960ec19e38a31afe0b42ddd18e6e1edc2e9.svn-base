/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.dao.IPropietarioDAO;
import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dios salva
 */
public class PropietarioDAOImp implements IPropietarioDAO{

    @Override
    public void crear(Propietario propietario) {
        propietario.setEstado(true);
        TablaPropietarios.tablaPropietarios.add(propietario);
    }

    @Override
    public void modificar(Propietario propietario) {
        for(Propietario p:TablaPropietarios.tablaPropietarios){
            if(p.getDni().equals(propietario.getDni())){
                TablaPropietarios.tablaPropietarios.set(TablaPropietarios.tablaPropietarios.indexOf(p), propietario);
            }
        }
    }

    @Override
    public List<Propietario> obtenerTodos() {
        List<Propietario> propietarios = new ArrayList<Propietario>();
        for(Propietario p:TablaPropietarios.tablaPropietarios){
            if(p.isEstado()==true){
                propietarios.add(p);
            }
        }
        return propietarios;
    }
    
}
