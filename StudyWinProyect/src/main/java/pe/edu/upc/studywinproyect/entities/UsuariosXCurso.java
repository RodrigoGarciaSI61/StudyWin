package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "UsuariosXCurso")
public class UsuariosXCurso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuariosxcurso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    public UsuariosXCurso() {
        // Constructor
    }

    public UsuariosXCurso(Long id_usuariosxcurso, Usuario usuario, Curso curso) {
        this.id_usuariosxcurso = id_usuariosxcurso;
        this.usuario = usuario;
        this.curso = curso;
    }

    public Long getId_usuariosxcurso() {
        return id_usuariosxcurso;
    }

    public void setId_usuariosxcurso(Long id_usuariosxcurso) {
        this.id_usuariosxcurso = id_usuariosxcurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}