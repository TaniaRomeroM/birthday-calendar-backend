package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.ContactoDTO;
import com.proyectocalendar.birthdaycalendar.dto.Message;
import com.proyectocalendar.birthdaycalendar.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin({"*"})
public class ContactoController {

    @Autowired // LLama al ContactoDao, Hace directamente una inyeccion de dependencias
    private ContactoService contactoService;

    @GetMapping(value = "contactos/{nombreUsuario}")
    public ResponseEntity<List<ContactoDTO>> getContactosPorNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<ContactoDTO>>(contactoService.getContactosPorUsuario(nombreUsuario), HttpStatus.OK);
    }

    @GetMapping(value = "contactos/hoy/{nombreUsuario}")
    public ResponseEntity<List<ContactoDTO>> getContactosHoy(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<List<ContactoDTO>>(contactoService.getContactosHoy(nombreUsuario), HttpStatus.OK);
    }

    @GetMapping(value = "contacto/{id}")
    public ResponseEntity<List<ContactoDTO>> getContacto(@PathVariable("id") Long contactoId) {
        return new ResponseEntity<List<ContactoDTO>>(contactoService.getContacto(contactoId), HttpStatus.OK);
    }

    @PostMapping(value = "contactos/add")
    public ResponseEntity<?> addContacto (@Valid @RequestBody ContactoDTO contactoDTO, BindingResult bindingResult) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos erróneos"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ContactoDTO>(contactoService.addContacto(contactoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "contactos/eliminar/{id}")
    public ResponseEntity<ContactoDTO> eliminarContacto(@PathVariable("id") Long contactoId) {
        return new ResponseEntity<ContactoDTO>(contactoService.eliminarContacto(contactoId), HttpStatus.OK);
    }
}
