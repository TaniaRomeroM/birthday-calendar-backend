package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.UsuarioDao;
import com.proyectocalendar.birthdaycalendar.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired // LLama al UsuarioDao
    private UsuarioDao usuarioDao;

    @PostMapping(value = "login")
    public String verificarCredenciales(@RequestBody Usuario usuario) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        if (usuarioDao.verificarCredenciales(usuario)) {
            return "OK";
        } else {
            return "FALSE";
        }
    }
}
