package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    void registrarUsuario(Usuario usuario);

    boolean verificarCredenciales(Usuario usuario);

    Usuario eliminarUsuario(Long usuarioId);
}
