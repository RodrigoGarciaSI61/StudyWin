package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

public class RecompensaDTO {

    private int id_tipo_recompensa;

    private String nombre;

    private String descripcion;

    private int precio_puntos;

    private int stock;

    private TipoRecompensa tipo_recompensa;

    public int getId_tipo_recompensa() {
        return id_tipo_recompensa;
    }

    public void setId_tipo_recompensa(int id_tipo_recompensa) {
        this.id_tipo_recompensa = id_tipo_recompensa;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TipoRecompensa getTipo_recompensa() {
        return tipo_recompensa;
    }

    public void setTipo_recompensa(TipoRecompensa tipo_recompensa) {
        this.tipo_recompensa = tipo_recompensa;
    }
}
