package com.servicebar.backend.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
public class Producto {
    @Id @Column("idProducto")
    private long idProducto;
    public long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }
    private String nombre;
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private double precio;
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Column("stockMin")
    private int stockMin;
    public int getStockMin() {
        return stockMin;
    }
    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    @Column("stockAct")
    private int stockAct;
    public int getStockAct() {
        return stockAct;
    }
    public void setStockAct(int stockAct) {
        this.stockAct = stockAct;
    }

    @Column("stockMin")
    private int stockMax;
    public int getStockMax() {
        return stockMax;
    }
    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    @Column("urlImagen")
    private String urlImagen;

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
