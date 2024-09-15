package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

import java.io.Serializable;

//No se toca a menos que se modifique la base de datos
@Entity
@Table(name = "Pregunta")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pregunta;
    @Column(name="pregunta",length = 200,nullable = false)
    private String pregunta;
    @Column(name="puntos",nullable = false)
    private int puntos;
    @Column(name="respuesta",length = 200,nullable = false)
    private String respuesta;
    @ManyToOne
    @JoinColumn(name = "id_cuestionario")
    private Cuestionario_academico cuestionario;
    public Pregunta() {}

    public Pregunta(int id_pregunta, String pregunta, int puntos, String respuesta, Cuestionario_academico cuestionario) {
        this.id_pregunta = id_pregunta;
        this.pregunta = pregunta;
        this.puntos = puntos;
        this.respuesta = respuesta;
        this.cuestionario = cuestionario;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Cuestionario_academico getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario_academico cuestionario) {
        this.cuestionario = cuestionario;
    }
}
