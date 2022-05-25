package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;

public interface UsuarioService {

    //List<UsuarioDTO> getUsuarios();

    UsuarioDTO getUsuarioByNombreUsuario(String nombreUsuario);

    //List<UsuarioDTO> getUsuarioById (Long usuarioId);

    //UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO);

    //boolean verificarCredenciales(UsuarioDTO usuarioDTO);

    UsuarioDTO eliminarUsuario(Long usuarioId);

}