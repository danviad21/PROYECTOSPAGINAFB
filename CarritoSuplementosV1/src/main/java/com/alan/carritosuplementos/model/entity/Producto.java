
package com.alan.carritosuplementos.model.entity;

import java.io.Serializable;

public class Producto implements Serializable{
    int id;
    String nombres;
    String foto;
    String descripcion;
    double precio;
    int stock;

    public Producto() {
    }

    public Producto(int id, String nombres, String foto, String descripcion, double precio, int stock) {
        this.id = id;
        this.nombres = nombres;
        this.foto = foto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombres=" + nombres + ", foto=" + foto + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + '}';
    }

    
}
