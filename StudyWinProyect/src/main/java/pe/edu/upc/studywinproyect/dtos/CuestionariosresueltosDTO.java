package pe.edu.upc.studywinproyect.dtos;

public class CuestionariosresueltosDTO {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private int cuestionarios_resueltos;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCuestionarios_resueltos() {
        return cuestionarios_resueltos;
    }

    public void setCuestionarios_resueltos(int cuestionarios_resueltos) {
        this.cuestionarios_resueltos = cuestionarios_resueltos;
    }
}
