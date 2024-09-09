package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UsuariosXCurso")
public class UsuariosXCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuariosxcurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    private Curso curso;

    public UsuariosXCurso() {
        // Constructor
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