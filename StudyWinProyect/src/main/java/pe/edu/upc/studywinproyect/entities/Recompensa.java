package pe.edu.upc.studywinproyect.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Recompensa")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_recompensa;
    @Column(name = "nombre", nullable = false, length = 25)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "puntos", nullable = false)
    private int puntos;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "imagen",nullable = false)
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "tipo_recompensa")
    private TipoRecompensa tipo_recompensa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asociado")
    private Asociado asociado;

    public Recompensa() {
    }

    public Recompensa(int id_recompensa, String nombre, int puntos, String descripcion, int stock, TipoRecompensa tipo_recompensa, pe.edu.upc.studywinproyect.entities.Asociado asociado, String imagen) {
        this.id_recompensa = id_recompensa;
        this.nombre = nombre;
        this.puntos = puntos;
        this.descripcion = descripcion;
        this.stock = stock;
        this.tipo_recompensa = tipo_recompensa;
        this.asociado = asociado;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public TipoRecompensa getTipo_recompensa() {
        return tipo_recompensa;
    }

    public void setTipo_recompensa(TipoRecompensa tipo_recompensa) {
        this.tipo_recompensa = tipo_recompensa;
    }

    public Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }
}
