package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import com.proyectocalendar.birthdaycalendar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class UsuarioController {

    @Autowired // LLama al UsuarioDao, Hace directamente una inyeccion de dependencias
    private UsuarioService usuarioService;

    @GetMapping(value = "usuarios")
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        return new ResponseEntity<List<UsuarioDTO>>(usuarioService.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping(value = "usuarios/find/{nombreUsuario}")
    public ResponseEntity<UsuarioDTO> getUsuarioByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<UsuarioDTO>(usuarioService.getUsuarioByNombreUsuario(nombreUsuario), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')") // Para que solo pueda hacer esta peticion el admin
    @GetMapping(value = "usuario/find/{id}")
    public ResponseEntity<List<UsuarioDTO>> getUsuarioById(@PathVariable("id") Long usuarioId) {
        return new ResponseEntity<List<UsuarioDTO>>(usuarioService.getUsuarioById(usuarioId), HttpStatus.OK);
    }

    @PostMapping(value = "usuarios/editar")
    public ResponseEntity<UsuarioDTO> editarUsuario (@RequestBody UsuarioDTO usuarioDTO) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        return new ResponseEntity<UsuarioDTO>(usuarioService.editarUsuario(usuarioDTO), HttpStatus.OK);
    }

    @DeleteMapping(value = "usuarios/eliminar/{id}")
    public  ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable("id") Long usuarioId) {
        return new ResponseEntity<UsuarioDTO>(usuarioService.eliminarUsuario(usuarioId), HttpStatus.OK);
    }

}
