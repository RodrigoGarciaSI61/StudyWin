package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoRecompensa")
public class TipoRecompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoRecompensa;

    @Column(name = "Tipo", nullable = false, length = 25)
    private String Tipo;

    public TipoRecompensa() {
    }

    public TipoRecompensa(int idTipoRecompensa, String tipo) {
        this.idTipoRecompensa = idTipoRecompensa;
        this.Tipo = tipo;
    }

    public int getIdTipoRecompensa() {
        return idTipoRecompensa;
    }

    public void setIdTipoRecompensa(int idTipoRecompensa) {
        this.idTipoRecompensa = idTipoRecompensa;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }
}
