package com.servicebar.backend.models;

import java.util.List;

public class InfoUsuarioRespuesta {
    private Long id;
    private String email;
    private List<String> roles;

    private long idCliente;

    private String nombre;

    public InfoUsuarioRespuesta(Long id, String email, List<String> roles, long idCliente, String nombre) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}