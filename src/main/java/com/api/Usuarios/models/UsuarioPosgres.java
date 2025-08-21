package com.api.Usuarios.models;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "usuariosPosgres")
public class UsuarioPosgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String nombre;

    private String email;

    public UsuarioPosgres() {

    }

    public UsuarioPosgres(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getters y Setters




}
