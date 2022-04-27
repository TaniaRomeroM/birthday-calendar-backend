package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.UsuarioDao;
import com.proyectocalendar.birthdaycalendar.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"*"})
public class UsuarioController {

    @Autowired // LLama al UsuarioDao, Hace directamente una inyeccion de dependencias - min 2:20:00
    private UsuarioDao usuarioDao;

    @GetMapping(value = "usuarios")
    public ResponseEntity<List<UsuarioDTO>> getUsuarios() {
        return new ResponseEntity<List<UsuarioDTO>>(usuarioDao.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping(value = "usuarios/find/{nombreUsuario}")
    public ResponseEntity<UsuarioDTO> getUsuarioByNombreUsuario(@PathVariable("nombreUsuario") String nombreUsuario) {
        return new ResponseEntity<UsuarioDTO>(usuarioDao.getUsuarioByNombreUsuario(nombreUsuario), HttpStatus.OK);
    }

    /*@PostMapping(value = "usuarios/add")
    public ResponseEntity<UsuarioDTO>  registrarUsuario(@RequestBody UsuarioDTO usuarioDTO) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        char [] psw = usuarioDTO.getPassword().toCharArray();
        //String hash = argon2.hash(1,1024, 1, usuario.getPassword()); // 1: nº iteraciones; 1024: uso de memoria
        String hash = argon2.hash(1,1024, 1, psw); // 1: nº iteraciones; 1024: uso de memoria
        usuarioDTO.setPassword(hash);
        return new ResponseEntity<UsuarioDTO>(usuarioDao.registrarUsuario(usuarioDTO), HttpStatus.CREATED);
    }*/

    @DeleteMapping(value = "usuarios/eliminar/{id}")
    public  ResponseEntity<UsuarioDTO> eliminarUsuario(@PathVariable("id") Long usuarioId) {
        /*Usuario usuario = usuarioDao.eliminarUsuario(usuarioId);
        return usuario;*/
        return new ResponseEntity<UsuarioDTO>(usuarioDao.eliminarUsuario(usuarioId), HttpStatus.OK);
    }

}
