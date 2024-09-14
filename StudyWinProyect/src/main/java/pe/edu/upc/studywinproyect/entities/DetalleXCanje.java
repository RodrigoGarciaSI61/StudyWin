package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle_Canje")
public class DetalleXCanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle_canje;

    @ManyToOne
    @JoinColumn(name = "id_recompensa")
    private Recompensa recompensa;

    @ManyToOne
    @JoinColumn(name = "id_canje")
    private Canje canje;

    @Column(name = "cantidad_producto_canje", nullable = false)
    private int cantidadProductoCanje;

    public DetalleXCanje() {
    }

    public DetalleXCanje(int id_detalle_canje, Recompensa recompensa, Canje canje, int cantidadProductoCanje) {
        this.id_detalle_canje = id_detalle_canje;
        this.recompensa = recompensa;
        this.canje = canje;
        this.cantidadProductoCanje = cantidadProductoCanje;
    }

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
