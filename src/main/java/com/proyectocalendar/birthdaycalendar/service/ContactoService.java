package com.proyectocalendar.birthdaycalendar.service;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;

import java.util.List;

public interface ContactoService {

    List<ContactoDTO> getContactos();

    List<ContactoDTO> getContactosPorUsuario(Long usuarioId);

    List<ContactoDTO> getContactosHoy(String nombreUsuario);

    List<ContactoDTO> getContactosPorUsuario(String nombreUsuario);

    List<ContactoDTO> getContacto(Long contactoId);

    ContactoDTO addContacto(ContactoDTO contactoDTO);

    ContactoDTO eliminarContacto(Long contactoId);

}
