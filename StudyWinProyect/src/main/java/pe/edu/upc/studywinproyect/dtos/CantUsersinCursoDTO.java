package pe.edu.upc.studywinproyect.dtos;

public class CantUsersinCursoDTO {
    private int idcurso;
    private String nombre_curso;
    private int cant_users;

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public int getCant_users() {
        return cant_users;
    }

    public void setCant_users(int cant_users) {
        this.cant_users = cant_users;
    }
}
