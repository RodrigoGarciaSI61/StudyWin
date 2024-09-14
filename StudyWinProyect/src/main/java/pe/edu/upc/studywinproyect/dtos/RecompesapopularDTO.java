package pe.edu.upc.studywinproyect.dtos;

public class RecompesapopularDTO {
    private String nombre;
    private String descripcion;
    private int precio_puntos;
    private int quantityRecompensas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio_puntos() {
        return precio_puntos;
    }

    public void setPrecio_puntos(int precio_puntos) {
        this.precio_puntos = precio_puntos;
    }

    public int getQuantityRecompensas() {
        return quantityRecompensas;
    }

    public void setQuantityRecompensas(int quantityRecompensas) {
        this.quantityRecompensas = quantityRecompensas;
    }
}
