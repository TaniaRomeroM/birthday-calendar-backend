package com.proyectocalendar.birthdaycalendar.security.models;

import javax.persistence.*;

@Entity
@Table(name = "fiestacompra")
public class Compra {

    @Id // Para mapear la clave primaria
    @Column(name = "fcompra_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compraId;

    @Column(name = "fiesta_id")
    private Long fiestaId;

    @Column(name = "nombre")
    private String Nombre;

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
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
