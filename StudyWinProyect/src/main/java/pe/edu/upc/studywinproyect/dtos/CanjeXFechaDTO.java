package pe.edu.upc.studywinproyect.dtos;
import java.time.LocalDate;

public class CanjeXFechaDTO {
    private LocalDate Fecha;
    private int cantidad_canjes;

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public int getCantidad_canjes() {
        return cantidad_canjes;
    }

    public void setCantidad_canjes(int cantidad_canjes) {
        this.cantidad_canjes = cantidad_canjes;
    }
}
