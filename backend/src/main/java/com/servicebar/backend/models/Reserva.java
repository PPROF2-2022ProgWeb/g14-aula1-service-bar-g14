package com.servicebar.backend.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Reserva {
    @Id @Column("idReserva")
    private long idReserva;
    public long getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }
    private Date fecha;
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    @Column("cantidadPersonas")
    private int cantidadPersonas;
    public int getCantidadPersonas() {
        return cantidadPersonas;
    }
    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Column("idCliente")
    private long idCliente;
    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
}
