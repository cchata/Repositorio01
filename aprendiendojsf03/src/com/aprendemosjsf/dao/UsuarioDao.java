/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aprendemosjsf.dao;

import java.util.List;
import com.aprendemosjsf.model.Usuario;

public interface UsuarioDao {
    public Usuario findByUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    public List<Usuario> findAll();
    public boolean create(Usuario usuario);
    public boolean update(Usuario usuario);
    public boolean delete(Integer id);
}
