package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioDao {

    List<UsuarioDTO> getUsuarios();

    UsuarioDTO getUsuarioByNombreUsuario(String nombreUsuario);

    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO);

    boolean verificarCredenciales(UsuarioDTO usuarioDTO);

    UsuarioDTO eliminarUsuario(Long usuarioId);

}