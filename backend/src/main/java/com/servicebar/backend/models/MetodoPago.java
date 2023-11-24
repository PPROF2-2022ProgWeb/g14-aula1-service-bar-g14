package com.servicebar.backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("metodoPago")
public class MetodoPago {
    @Id @Column("idMetodoPago")
    private long idMetodoPago;
    public long getIdMetodoPago() {
        return idMetodoPago;
    }
    public void setIdMetodoPago(long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
