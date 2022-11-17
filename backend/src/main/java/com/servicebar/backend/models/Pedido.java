package com.servicebar.backend.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Pedido {
    @Id @Column("idPedido")
    private long idPedido;
    public long getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }
    @Column("idCliente")
    private long idCliente;
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Column("idProducto")
    private long idProducto;
    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    @Column("fechaHora")
    private Date fechaHora;
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
