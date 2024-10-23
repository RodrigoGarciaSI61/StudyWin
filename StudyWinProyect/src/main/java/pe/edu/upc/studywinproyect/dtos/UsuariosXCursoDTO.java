package pe.edu.upc.studywinproyect.dtos;

import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.entities.Usuario;

public class UsuariosXCursoDTO {
    private Long id_usuariosxcurso;
    private Curso curso;
    private Usuario usuario;

    // Getters y setters

    public Long getId_usuariosxcurso() {
        return id_usuariosxcurso;
    }

    public void setId_usuariosxcurso(Long id_usuariosxcurso) {
        this.id_usuariosxcurso = id_usuariosxcurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
