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
}
