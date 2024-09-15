package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Cuestionario_academico;

public class PreguntaDTO {
    private int id_pregunta;
    private String pregunta;
    private int puntos;
    private String respuesta;
    private Cuestionario_academico cuestionario;

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
