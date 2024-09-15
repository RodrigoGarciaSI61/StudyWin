package pe.edu.upc.studywinproyect.dtos;

public class RecompesapopularDTO {
    private String nombre;
    private String descripcion;
    private int puntos;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getQuantityRecompensas() {
        return quantityRecompensas;
    }

    public void setQuantityRecompensas(int quantityRecompensas) {
        this.quantityRecompensas = quantityRecompensas;
    }
}
