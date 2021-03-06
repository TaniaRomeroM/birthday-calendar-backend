package com.proyectocalendar.birthdaycalendar.security.controllers;

import com.proyectocalendar.birthdaycalendar.dto.Message;
import com.proyectocalendar.birthdaycalendar.security.dto.JwtDTO;
import com.proyectocalendar.birthdaycalendar.security.dto.LoginUsuario;
import com.proyectocalendar.birthdaycalendar.security.dto.NuevoUsuario;
import com.proyectocalendar.birthdaycalendar.security.enums.RolNombre;
import com.proyectocalendar.birthdaycalendar.security.jwt.JwtProvider;
import com.proyectocalendar.birthdaycalendar.security.models.Rol;
import com.proyectocalendar.birthdaycalendar.security.models.Usuario;
import com.proyectocalendar.birthdaycalendar.security.service.RolService;
import com.proyectocalendar.birthdaycalendar.security.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
//@CrossOrigin
@CrossOrigin({"*"})
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserSecurityService userSecurityService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<Message> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        // si no hay errores en la validacion
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Campos err??neos o email inv??lido"), HttpStatus.BAD_REQUEST);
        }
        if(userSecurityService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity<>(new Message("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        }
        if(userSecurityService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity<>(new Message("Email ya existente"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getApellido(), nuevoUsuario.getFechanac(),
                nuevoUsuario.getEmail(), nuevoUsuario.getNombreUsuario(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        Optional<Rol> optionalRol = rolService.getByRolNombre(RolNombre.ROLE_USER);
        if (optionalRol.isPresent()) {
            roles.add(optionalRol.get()); //el .get se usa para devolver el rol, ya que el metodo devuelve un Optional<Rol>
        }

        if (nuevoUsuario.getRoles().contains("admin")) {
            Optional<Rol> optionalAdminRol = rolService.getByRolNombre(RolNombre.ROLE_ADMIN);
            if (optionalAdminRol.isPresent()) {
                roles.add(optionalAdminRol.get());
            }
        }

        // se agregan los roles que correspondan al usuario
        usuario.setRoles(roles);
        userSecurityService.save(usuario);
        return new ResponseEntity<>(new Message("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(/*"Campos erroneos",*/ HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);

        //UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt);
        return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
    }
}