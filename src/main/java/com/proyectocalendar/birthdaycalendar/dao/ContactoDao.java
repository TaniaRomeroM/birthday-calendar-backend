package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;

import java.util.List;

public interface ContactoDao {

    List<ContactoDTO> getContactos();

    List<ContactoDTO> getContactosPorUsuario(Long usuarioId);

    List<ContactoDTO> getContacto(Long contactoId);

    //void addContacto(Contacto contacto);
    ContactoDTO addContacto(ContactoDTO contactoDTO);

    ContactoDTO eliminarContacto(Long contactoId);

}
