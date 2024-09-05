package pe.edu.upc.studywinproyect.dtos;
import java.time.LocalDate;
public class AsociadoDTO {
    private int id_asociado;
    private String empresa;
    private String descripcion;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public int getId_asociado() {
        return id_asociado;
    }

    public void setId_asociado(int id_asociado) {
        this.id_asociado = id_asociado;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
