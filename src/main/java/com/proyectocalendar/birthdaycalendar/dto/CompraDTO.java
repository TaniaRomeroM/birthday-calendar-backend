package com.proyectocalendar.birthdaycalendar.dto;

import javax.validation.constraints.NotBlank;

public class CompraDTO {

    private Long compraId;

    private Long fiestaId;

    @NotBlank
    private String nombre;

    public Long getCompraId() {
        return compraId;
    }

    public void setCompraId(Long compraId) {
        this.compraId = compraId;
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
        return "CompraDTO{" +
                "compraId=" + compraId +
                ", fiestaId=" + fiestaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}