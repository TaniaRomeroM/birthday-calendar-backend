package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    //List<UsuarioDTO> getUsuarios();

    UsuarioDTO getUsuarioByNombreUsuario(String nombreUsuario);

    List<UsuarioDTO> getUsuarioById (Long usuarioId);

    UsuarioDTO editarUsuario(UsuarioDTO usuarioDTO);

    //UsuarioDTO eliminarUsuario(Long usuarioId);

}