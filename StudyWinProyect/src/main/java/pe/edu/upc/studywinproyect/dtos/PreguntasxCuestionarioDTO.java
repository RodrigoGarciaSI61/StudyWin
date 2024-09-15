package pe.edu.upc.studywinproyect.dtos;

public class PreguntasxCuestionarioDTO {
    private int id_cuestionario;
    private String nombre;
    private int tiempo_limite;
    private int cantidad_preguntas;

    public int getId_cuestionario() {
        return id_cuestionario;
    }

    public void setId_cuestionario(int id_cuestionario) {
        this.id_cuestionario = id_cuestionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo_limite() {
        return tiempo_limite;
    }

    public void setTiempo_limite(int tiempo_limite) {
        this.tiempo_limite = tiempo_limite;
    }

    public int getCantidad_preguntas() {
        return cantidad_preguntas;
    }

    public void setCantidad_preguntas(int cantidad_preguntas) {
        this.cantidad_preguntas = cantidad_preguntas;
    }
}
