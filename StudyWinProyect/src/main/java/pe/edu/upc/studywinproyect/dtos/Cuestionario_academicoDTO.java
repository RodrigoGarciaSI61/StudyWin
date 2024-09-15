package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Curso;

public class Cuestionario_academicoDTO {
    private int id_cuestionario;
    private String nombres;
    private String descripcion;
    private int tiempo_limite;
    private Curso curso;

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
