package com.proyectocalendar.birthdaycalendar.security.repository;

import com.proyectocalendar.birthdaycalendar.security.enums.RolNombre;
import com.proyectocalendar.birthdaycalendar.security.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}