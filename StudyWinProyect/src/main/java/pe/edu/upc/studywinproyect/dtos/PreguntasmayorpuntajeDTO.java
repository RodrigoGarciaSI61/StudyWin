package pe.edu.upc.studywinproyect.dtos;

public class PreguntasmayorpuntajeDTO {
    private int IdPregunta;
    private String Pregunta;
    private int puntos;
    private String respuesta;
    private int id_cuestionario;
    private String nombrecuestionario;

    public int getIdPregunta() {
        return IdPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        IdPregunta = idPregunta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public void setPregunta(String pregunta) {
        Pregunta = pregunta;
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

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNombrecuestionario() {
        return nombrecuestionario;
    }

    public void setNombrecuestionario(String nombrecuestionario) {
        this.nombrecuestionario = nombrecuestionario;
    }
}
