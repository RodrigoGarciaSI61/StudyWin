package pe.edu.upc.studywinproyect.dtos;

public class UsuariosXCursoDTO {
    private Long id_usuariosxcurso;
    private Long id_usuario;
    private int id_curso;
    // Getters y setters
    public Long getId_usuariosxcurso() {
        return id_usuariosxcurso;
    }

    public void setId_usuariosxcurso(Long id_usuariosxcurso) {
        this.id_usuariosxcurso = id_usuariosxcurso;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
}
