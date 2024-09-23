package pe.edu.upc.studywinproyect.dtos;

public class DetalleXCanjeDTO {
    private int id_detalle_canje;
    private int id_recompensa;
    private int id_canje;
    private int cantidadProductoCanje;
        public int getId_detalle_canje() {
        return id_detalle_canje;
    }

    public void setId_detalle_canje(int id_detalle_canje) {
        this.id_detalle_canje = id_detalle_canje;
    }

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public int getId_canje() {
        return id_canje;
    }

    public void setId_canje(int id_canje) {
        this.id_canje = id_canje;
    }

    public int getCantidadProductoCanje() {
        return cantidadProductoCanje;
    }

    public void setCantidadProductoCanje(int cantidadProductoCanje) {
        this.cantidadProductoCanje = cantidadProductoCanje;
    }
}
