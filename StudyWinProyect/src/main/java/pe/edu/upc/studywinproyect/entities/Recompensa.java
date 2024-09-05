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

    @Column(name = "precio_puntos", nullable = false)
    private int precio_puntos;

    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoRecompensa tipo_recompensa;

    public Recompensa() {
    }

    public Recompensa(int id_recompensa, String nombre, String descripcion, int precio_puntos, int stock, TipoRecompensa tipo_recompensa) {
        this.id_recompensa = id_recompensa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_puntos = precio_puntos;
        this.stock = stock;
        this.tipo_recompensa = tipo_recompensa;
    }

    public int getId_tipo_recompensa() {
        return id_recompensa;
    }

    public void setId_tipo_recompensa(int id_recompensa) {
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

    public int getPrecio_puntos() {
        return precio_puntos;
    }

    public void setPrecio_puntos(int precio_puntos) {
        this.precio_puntos = precio_puntos;
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
}
