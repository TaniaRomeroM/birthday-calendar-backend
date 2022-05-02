package com.proyectocalendar.birthdaycalendar.security.service;

import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import com.proyectocalendar.birthdaycalendar.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional // Mantiene coherencia si hay varios accesos a bd. Si uno falla, se hace rollback y se queda como estaba
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // El nombre del metodo da igual, donde importa es en el repository, ya que usa JPARepository
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void save (Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}