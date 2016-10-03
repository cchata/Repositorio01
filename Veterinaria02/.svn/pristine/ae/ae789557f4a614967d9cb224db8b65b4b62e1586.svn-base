/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao.imp.ram;

import ar.edu.unju.fi.apu.modelo.dominio.Propietario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Dios salva
 */
public class TablaPropietarios {
    public static List<Propietario> tablaPropietarios;
    
    
    public static void llenarTabla(){
        tablaPropietarios = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1979, 0, 21);
        tablaPropietarios.add(new Propietario("Direccion01", "(54) 388 5111222", "11111111", "Perez", "Juan",calendar.getTime() , true));
        calendar.set(2000, 5, 10);
        tablaPropietarios.add(new Propietario("Direccion02", "(54) 388 5333444", "22222222", "Torres", "Pedro",calendar.getTime() , true));
    }
    
    
}
