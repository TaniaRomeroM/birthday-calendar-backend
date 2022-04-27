package com.proyectocalendar.birthdaycalendar.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectocalendar.birthdaycalendar.security.models.Rol;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity // Para decir que es una entidad, hace referencia a la BBDD, Para que Hibernate sepa que esa Clase es una Tabla
@Table(name = "usuario")
public class Usuario {

    @Id // Para mapear la clave primaria
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity	--> Genera la clave principal basado en si hay un campo de autoincremento.
    private Long usuarioId;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "fechanac")
    private LocalDate fechanac;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "nombreusuario", unique = true)
    private String nombreUsuario;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, LocalDate fechanac, String email, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
