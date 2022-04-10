package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.ContactoDao;
import com.proyectocalendar.birthdaycalendar.models.Contacto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class ContactoController {

    @Autowired // LLama al ContactoDao, Hace directamente una inyeccion de dependencias - min 2:20:00
    private ContactoDao contactoDao;


    @GetMapping(value = "contactos")
    public List<Contacto> getContactos() {
        return contactoDao.getContactos();
    }

    @GetMapping(value = "contactos/{id}")
    public List<Contacto> getContactosPorUsuario(@PathVariable("id") Long usuarioId) {
        return contactoDao.getContactosPorUsuario(usuarioId);
    }

    //@RequestMapping(value = "contactos/add", method = RequestMethod.POST)
    @PostMapping(value = "contactos/add")
    public Contacto addContacto (@RequestBody Contacto contacto) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        //contacto.setUsuarioId(1);
        contactoDao.addContacto(contacto);
        return contacto;
    }

    @DeleteMapping(value = "contactos/eliminar/{id}")
    public void eliminarContacto(@PathVariable("id") Long contactoId) {
        contactoDao.eliminarContacto(contactoId);
    }

    @GetMapping(value = "contacto/{id}")
    public List<Contacto> getContacto(@PathVariable("id") Long contactoId) {
        return contactoDao.getContacto(contactoId);
    }
}
