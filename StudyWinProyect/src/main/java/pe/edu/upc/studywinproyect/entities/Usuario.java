package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(name = "nombres",nullable = false,length = 40)
    private String nombres;

    @Column(name="apellidos",nullable = false,length = 40)
    private String apellidos;

    @Column(name="dni",nullable = false,length = 10 )
    private String dni;

    @Column(name="email",nullable = false,length = 100 )
    private String email;

    @Column(name="contrasena",nullable = false,length = 50 )
    private String contrasena;

    @Column(name="puntos_usuario",nullable = false )
    private int puntos_usuario;

    @Column(name="institucion_educativa",nullable = false, length = 50)
    private String institucion_educativa;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombres, String apellidos, String dni, String email, String contrasena, int puntos_usuario, String institucion_educativa) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.contrasena = contrasena;
        this.puntos_usuario = puntos_usuario;
        this.institucion_educativa = institucion_educativa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getPuntos_usuario() {
        return puntos_usuario;
    }

    public void setPuntos_usuario(int puntos_usuario) {
        this.puntos_usuario = puntos_usuario;
    }

    public String getInstitucion_educativa() {
        return institucion_educativa;
    }

    public void setInstitucion_educativa(String institucion_educativa) {
        this.institucion_educativa = institucion_educativa;
    }
}
