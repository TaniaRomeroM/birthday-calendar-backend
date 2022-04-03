package com.proyectocalendar.birthdaycalendar.controllers;

import com.proyectocalendar.birthdaycalendar.dao.UsuarioDao;
import com.proyectocalendar.birthdaycalendar.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired // LLama al UsuarioDao, Hace directamente una inyeccion de dependencias - min 2:20:00
    private UsuarioDao usuarioDao;
/*
    //FALTA
    @RequestMapping(value = "usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Martinez");
        usuario.setEdad(28);
        return usuario;
    }*/

    @GetMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @PostMapping(value = "usuarios")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) { // @RequestBody - Convierte el JSON que recibe a un usuario automaticamente
        usuarioDao.registrarUsuario(usuario);
        return usuario;
    }
/*
    //FALTA
    @RequestMapping(value = "editar")
    public Empleado editar() {
        Empleado empleado = new Empleado();
        return empleado;
    }

    //FALTA
    @RequestMapping(value = "buscar")
    public Empleado buscar() {
        Empleado empleado = new Empleado();
        return empleado;
    }

    @RequestMapping(value = "empleado/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id) {
        empleadoDao.eliminar(id);
    }*/
}
