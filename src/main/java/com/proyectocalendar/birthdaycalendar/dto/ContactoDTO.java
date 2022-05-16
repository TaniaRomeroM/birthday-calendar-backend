package com.proyectocalendar.birthdaycalendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ContactoDTO {

    private Long contactoId;

    private Long usuarioId;

    @NotBlank
    private String nombre;

    private String apellido;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechanac;

    @Email
    private String email;

    public Long getContactoId() {
        return contactoId;
    }

    public void setContactoId(Long contactoId) {
        this.contactoId = contactoId;
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

    @Override
    public String toString() {
        return "ContactoDTO{" +
                "contactoId=" + contactoId +
                ", usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechanac=" + fechanac +
                ", email='" + email + '\'' +
                '}';
    }
}