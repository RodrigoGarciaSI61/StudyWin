package pe.edu.upc.studywinproyect.dtos;

public class CursosXCategoriaDTO {
    private String categoria;
    private int cantidad_cursos;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidad_cursos() {
        return cantidad_cursos;
    }

    public void setCantidad_cursos(int cantidad_cursos) {
        this.cantidad_cursos = cantidad_cursos;
    }
}
