package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.lang.String;
import java.time.LocalDate;


//No se toca a menos que se modifique la base de datos
@Entity
@Table(name = "Canje")
public class Canje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_canje;
    @Column(name="fecha",nullable = false)
    private LocalDate fecha;
    @Column(name="departamento",length = 100,nullable = false)
    private String departamento;
    @Column(name="distrito",length = 100,nullable = false)
    public String distrito;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Canje() {
    }

    public Canje(int id_canje, LocalDate fecha, String departamento, String distrito, Usuario usuario) {
        this.id_canje = id_canje;
        this.fecha = fecha;
        this.departamento = departamento;
        this.distrito = distrito;
        this.usuario = usuario;
    }

    public int getId_canje() {
        return id_canje;
    }

    public void setId_canje(int id_canje) {
        this.id_canje = id_canje;
    }

    public LocalDate getPurchaseDateDevice() {
        return fecha;
    }

    public void setPurchaseDateDevice(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
