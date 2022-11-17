package com.servicebar.backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table
public class Usuario {
    @Id
    @Column("idUsuario")
    private long idUsuario;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column("idCliente")
    private long idCliente;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @MappedCollection(idColumn = "idUsuario")
    private Set<RoleRef> roles = new HashSet<>();


    public Set<RoleRef> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        var ref = new RoleRef();
        ref.setRoleId(role.getId());
        this.roles.add(ref);
    }
}
