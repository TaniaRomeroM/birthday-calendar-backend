package com.proyectocalendar.birthdaycalendar.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectocalendar.birthdaycalendar.models.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/* Esta clase se encarga de generar la seguridad (utiliza SpringSecurity), implementa los privilegios de cada usuario
   y la clase Usuario se encarga de acceder a la bd */
public class UsuarioAplicacion implements UserDetails {

    // El usuario_id no es necesario porque no vamos a ir a una entidad
    private String nombre;
    private String apellido;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechanac;
    private String email;
    private String nombreUsuario;
    private String password;
    // GrantedAuthority: clase espeifica de security core
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioAplicacion(String nombre, String apellido, LocalDate fechanac, String email, String nombreUsuario, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.authorities = authorities;
    }

    /* Asigna los privilegios a cada usuario. Recibe un Usuario y construye el usuario de la aplicacion con los roles
       convertidos en authorities */
    public static UsuarioAplicacion build(Usuario usuario) {
        // Obtiene los roles del usuario de bd y los convierte a Granted authorities de spring
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                        .getRolNombre().name())).collect(Collectors.toList());

        // Crea el usuario de la aplicacion con los datos del usuario y las authorities
        return new UsuarioAplicacion(usuario.getNombre(), usuario.getApellido(), usuario.getFechanac(), usuario.getEmail(), usuario.getNombreUsuario(), usuario.getPassword(), authorities);
    }

    // Los siguientes metodos son necesarios al implementar UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        this.fechanac = fechanac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}