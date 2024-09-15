package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

public class RecompensaDTO {

    private int id_recompensa;
    private String nombre;
    private String descripcion;
    private int puntos;
    private int stock;
    private TipoRecompensa tipoRecompensa;
    private Asociado Asociado;

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TipoRecompensa getTipo_recompensa() {
        return tipoRecompensa;
    }

    public void setTipo_recompensa(TipoRecompensa tipo_Recompensa) {
        tipoRecompensa = tipo_Recompensa;
    }

    public Asociado getAsociado() {
        return Asociado;
    }

    public void setAsociado(Asociado asociado) {
        Asociado = asociado;
    }
}
