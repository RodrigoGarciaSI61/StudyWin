package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Canje;
import pe.edu.upc.studywinproyect.entities.Recompensa;

public class DetalleXCanjeDTO {
    private int id_detalle_canje;
    private Recompensa id_recompensa;
    private Canje id_canje;
    private int cantidadProductoCanje;

    public int getId_detalle_canje() {
        return id_detalle_canje;
    }

    public void setId_detalle_canje(int id_detalle_canje) {
        this.id_detalle_canje = id_detalle_canje;
    }

    public Recompensa getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(Recompensa id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public Canje getId_canje() {
        return id_canje;
    }

    public void setId_canje(Canje id_canje) {
        this.id_canje = id_canje;
    }

    public int getCantidadProductoCanje() {
        return cantidadProductoCanje;
    }

    public void setCantidadProductoCanje(int cantidadProductoCanje) {
        this.cantidadProductoCanje = cantidadProductoCanje;
    }
}
