package com.proyectocalendar.birthdaycalendar.security.models;

import javax.persistence.*;

@Entity
@Table(name = "fiestainvitado")
public class Invitado {

    @Id // Para mapear la clave primaria
    @Column(name = "finvitado_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invitadoId;

    @Column(name = "fiesta_id")
    private Long fiestaId;

    @Column(name = "nombre")
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
}
