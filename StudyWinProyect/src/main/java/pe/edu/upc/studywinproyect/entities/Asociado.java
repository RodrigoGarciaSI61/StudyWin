package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

//No se toca a menos que se modifique la base de datos
@Entity
@Table(name = "Asociado")
public class Asociado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asociado;
    @Column(name="empresa",length = 100,nullable = false)
    private String empresa;
    @Column(name="descripcion",length = 100,nullable = false)
    private String descripcion;
    @Column(name="fecha_inicio",nullable = false)
    private LocalDate fecha_inicio;
    @Column(name="fecha_fin",nullable = true)
    private LocalDate fecha_fin;
    @Column(name = "ruc", nullable = false, length = 10)
    private String RUC;

    public Asociado() {
    }

    public Asociado(int id_asociado, String empresa, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, String RUC) {
        this.id_asociado = id_asociado;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.RUC = RUC;
    }

    public int getId_asociado() {
        return id_asociado;
    }

    public void setId_asociado(int id_asociado) {
        this.id_asociado = id_asociado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
}
