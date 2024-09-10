package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

public class RecompensaDTO {

    private int id_recompensa;
    private String nombre;
    private String descripcion;
    private int precio_puntos;
    private int stock;
    private TipoRecompensa tipoRecompensa;
    private Asociado Asociado;

    public TipoRecompensa getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(TipoRecompensa tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public Asociado getAsociado() {
        return Asociado;
    }

    public void setAsociado(Asociado asociado) {
        Asociado = asociado;
    }

    private TipoRecompensa tipo_recompensa;

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public int getId_tipo_recompensa() {
        return id_recompensa;
    }

    public void setId_tipo_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
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
