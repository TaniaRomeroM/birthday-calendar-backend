package com.proyectocalendar.birthdaycalendar.dto;

public class CompraDTO {

    private Long compraId;
    private Long fiestaId;
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