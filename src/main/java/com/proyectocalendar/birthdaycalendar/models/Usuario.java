package com.proyectocalendar.birthdaycalendar.models;

import javax.persistence.*;
import java.util.Date;

@Entity // Para decir que es una entidad, hace referencia a la BBDD, Para que Hibernate sepa que esa Clase es una Tabla
@Table(name = "usuario")
public class Usuario {

    @Id // Para mapear la clave primaria
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity	--> Genera la clave principal basado en si hay un campo de autoincremento.
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechanac")
    private Date fechanac;

    @Column(name = "email")
    private String email;

    @Column(name = "nombreusuario")
    private String nombreusuario;

    @Column(name = "password")
    private String password;


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

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
