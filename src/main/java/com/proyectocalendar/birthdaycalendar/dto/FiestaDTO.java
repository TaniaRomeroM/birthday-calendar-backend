package com.proyectocalendar.birthdaycalendar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class FiestaDTO {

    private Long fiestaId;

    private Long contactoId;

    private Long usuarioId;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate fechaFiesta;

    private String tipo;

    public Long getFiestaId() {
        return fiestaId;
    }

    public void setFiestaId(Long fiestaId) {
        this.fiestaId = fiestaId;
    }

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

    public LocalDate getFechaFiesta() {
        return fechaFiesta;
    }

    public void setFechaFiesta(LocalDate fechaFiesta) {
        this.fechaFiesta = fechaFiesta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FiestaDTO{" +
                "fiestaId=" + fiestaId +
                ", contactoId=" + contactoId +
                ", usuarioId=" + usuarioId +
                ", fechaFiesta=" + fechaFiesta +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}