package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Contacto;

import java.util.List;

public interface ContactoDao {

    List<Contacto> getContactos();

    List<Contacto> getContactosPorUsuario(Long usuarioId);

    List<Contacto> getContacto(Long contactoId);

    void addContacto(Contacto contacto);

    Contacto eliminarContacto(Long contactoId);

}
