package com.proyectocalendar.birthdaycalendar.dto;

import javax.validation.constraints.NotBlank;

public class SugerenciaDTO {

    private Long sugerenciaId;

    private Long usuarioId;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String estadoSugerencia;

    public Long getSugerenciaId() {
        return sugerenciaId;
    }

    public void setSugerenciaId(Long sugerenciaId) {
        this.sugerenciaId = sugerenciaId;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoSugerencia() {
        return estadoSugerencia;
    }

    public void setEstadoSugerencia(String estadoSugerencia) {
        this.estadoSugerencia = estadoSugerencia;
    }

    @Override
    public String toString() {
        return "SugerenciaDTO{" +
                "sugerenciaId=" + sugerenciaId +
                ", usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estadoSugerencia='" + estadoSugerencia + '\'' +
                '}';
    }
}
