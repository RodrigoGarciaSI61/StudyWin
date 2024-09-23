package pe.edu.upc.studywinproyect.dtos;
import pe.edu.upc.studywinproyect.entities.Usuario;

import java.lang.String;
import java.time.LocalDate;


public class CanjeDTO {

    private int id_canje;
    private LocalDate fecha;
    private String departamento;
    private String distrito;
    private Usuario usuario;

    public int getId_canje() {
        return id_canje;
    }

    public void setId_canje(int id_canje) {
        this.id_canje = id_canje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public LocalDate getPurchaseDateDevice() {
        return fecha;
    }

    public void setPurchaseDateDevice(LocalDate fecha) {
        this.fecha = fecha;
    }
}
