package com.servicebar.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table()
public class Carrito {
    @Id @Column("idCarrito")
    private long idCarrito;

    public long getIdCarrito() {
        return idCarrito;
    }
    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    @Column("idCliente")
    private long idCliente;
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Column("idProducto")
    private long idProducto;
    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
}
