package pe.edu.upc.studywinproyect.dtos;

public class CuestionarioXCursoDTO {
    private int id_curso;
    private String nombre;
    private String categoria;
    private int cantidad_cuestionarios;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad_cuestionarios() {
        return cantidad_cuestionarios;
    }

    public void setCantidad_cuestionarios(int cantidad_cuestionarios) {
        this.cantidad_cuestionarios = cantidad_cuestionarios;
    }
}
