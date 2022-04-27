package com.proyectocalendar.birthdaycalendar.security.service;

import com.proyectocalendar.birthdaycalendar.security.enums.RolNombre;
import com.proyectocalendar.birthdaycalendar.security.models.Rol;
import com.proyectocalendar.birthdaycalendar.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre (RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }
}