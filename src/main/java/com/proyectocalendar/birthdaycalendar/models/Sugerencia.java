package com.proyectocalendar.birthdaycalendar.models;

import com.proyectocalendar.birthdaycalendar.enums.EstadoSugerencia;

import javax.persistence.*;

@Entity
@Table(name = "sugerencia")
public class Sugerencia {

    @Id // Para mapear la clave primaria
    @Column(name = "sugerencia_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sugerenciaId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoSugerencia estadoSugerencia;

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

    public EstadoSugerencia getEstadoSugerencia() {
        return estadoSugerencia;
    }

    public void setEstadoSugerencia(EstadoSugerencia estadoSugerencia) {
        this.estadoSugerencia = estadoSugerencia;
    }
}
