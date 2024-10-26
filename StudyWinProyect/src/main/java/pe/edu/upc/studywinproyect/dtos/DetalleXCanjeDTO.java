package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Canje;
import pe.edu.upc.studywinproyect.entities.Recompensa;

public class DetalleXCanjeDTO {
    private int id_detalle_canje;
    private Recompensa recompensa;
    private Canje canje;
    private int cantidadProductoCanje;

    public int getId_detalle_canje() {
        return id_detalle_canje;
    }

    public void setId_detalle_canje(int id_detalle_canje) {
        this.id_detalle_canje = id_detalle_canje;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public Canje getCanje() {
        return canje;
    }

    public void setCanje(Canje canje) {
        this.canje = canje;
    }

    public int getCantidadProductoCanje() {
        return cantidadProductoCanje;
    }

    public void setCantidadProductoCanje(int cantidadProductoCanje) {
        this.cantidadProductoCanje = cantidadProductoCanje;
    }
}
