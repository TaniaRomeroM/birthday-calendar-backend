package com.proyectocalendar.birthdaycalendar.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // Para decir que es una entidad, hace referencia a la BBDD, Para que Hibernate sepa que esa Clase es una Tabla
@Table(name = "usuario")
public class Usuario {

    @Id // Para mapear la clave primaria
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity	--> Genera la clave principal basado en si hay un campo de autoincremento.
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "fechanac")
    private LocalDate fechanac;

    @Column(name = "email")
    private String email;

    @Column(name = "nombreusuario")
    private String nombreusuario;

    @Column(name = "password")
    private String password;


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

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
