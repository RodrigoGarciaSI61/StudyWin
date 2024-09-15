package pe.edu.upc.studywinproyect.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

//No se toca a menos que se modifique la base de datos
@Entity
@Table(name = "Cuestionario_academico")
public class Cuestionario_academico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cuestionario;
    @Column(name = "nombre",nullable = false,length = 40)
    private String nombres;
    @Column(name = "descripcion",nullable = false,length = 40)
    private String descripcion;
    @Column(name="tiempo_limite",nullable = false )
    private int tiempo_limite;
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public Cuestionario_academico() {
    }

    public Cuestionario_academico(int id_cuestionario, String nombres, String descripcion, int tiempo_limite, Curso curso) {
        this.id_cuestionario = id_cuestionario;
        this.nombres = nombres;
        this.descripcion = descripcion;
        this.tiempo_limite = tiempo_limite;
        this.curso = curso;
    }

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo_limite() {
        return tiempo_limite;
    }

    public void setTiempo_limite(int tiempo_limite) {
        this.tiempo_limite = tiempo_limite;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
