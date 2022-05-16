package com.proyectocalendar.birthdaycalendar.dto;

import javax.validation.constraints.NotBlank;

public class InvitadoDTO {

    private Long invitadoId;

    private Long fiestaId;

    @NotBlank
    private String nombre;

    public Long getInvitadoId() {
        return invitadoId;
    }

    public void setInvitadoId(Long invitadoId) {
        this.invitadoId = invitadoId;
    }

    public Long getFiestaId() {
        return fiestaId;
    }

    public void setFiestaId(Long fiestaId) {
        this.fiestaId = fiestaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "InvitadoDTO{" +
                "invitadoId=" + invitadoId +
                ", fiestaId=" + fiestaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
