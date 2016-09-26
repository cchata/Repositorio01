/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.unju.fi.apu.dao;

import ar.edu.unju.fi.apu.modelo.dominio.Usuario;

/**
 *
 * @author Dios salva
 */
public interface IUsuarioDAO {
    /**
     * Valida la existencia de un usuario
     * @param nombreUsuario
     * @param password
     * @return null si no existe. 
     */
    Usuario validarUsuario(String nombreUsuario, String password);
    void modificar(Usuario unUsuario);
    Usuario obtenerUsuario(String nombreUsuario);
}
