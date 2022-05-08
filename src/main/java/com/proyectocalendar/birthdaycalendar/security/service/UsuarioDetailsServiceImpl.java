package com.proyectocalendar.birthdaycalendar.security.service;

import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import com.proyectocalendar.birthdaycalendar.security.models.UsuarioAplicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Convierte la clase Usuario en un UsuarioAplicacion
@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService { // Implementa la interface de springSecurity

    @Autowired
    UserSecurityService userSecurityService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        // El .get se usa para devolver el usuario, ya que el metodo devuelve un Optional<Usuario>. Funcionan asi los Optional
        Usuario usuario = userSecurityService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioAplicacion.build(usuario);
    }
}