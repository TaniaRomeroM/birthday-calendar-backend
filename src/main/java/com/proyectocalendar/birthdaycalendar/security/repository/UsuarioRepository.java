package com.proyectocalendar.birthdaycalendar.security.repository;

import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario); // El nombre de este metodo tiene que coincidir con el nombre del campo
    boolean existsByEmail(String email);
}