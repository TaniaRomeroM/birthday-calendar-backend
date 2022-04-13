package com.proyectocalendar.birthdaycalendar.dao;

import com.proyectocalendar.birthdaycalendar.models.Contacto;

import java.util.List;

public interface ContactoDao {

    List<Contacto> getContactos();

    List<Contacto> getContactosPorUsuario(Long usuarioId);

    void addContacto(Contacto contacto);

    void eliminarContacto(Long contactoId);

    List<Contacto> getContacto(Long contactoId);
}
