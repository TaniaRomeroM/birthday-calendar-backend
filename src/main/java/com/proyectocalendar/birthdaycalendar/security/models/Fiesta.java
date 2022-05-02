package com.proyectocalendar.birthdaycalendar.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "fiesta")
public class Fiesta {

    @Id // Para mapear la clave primaria
    @Column(name = "fiesta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fiestaId;

    @Column(name = "contacto_id")
    private Long contactoId;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(name = "fechafiesta")
    private LocalDate fechaFiesta;

    @Column(name = "tipo")
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
}
