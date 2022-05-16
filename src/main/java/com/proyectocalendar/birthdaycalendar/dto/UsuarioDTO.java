package com.proyectocalendar.birthdaycalendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioDTO {

    private Long usuarioId;

    @NotBlank
    private String nombre;

    private String apellido;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechanac;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechanac=" + fechanac +
                ", email='" + email + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}