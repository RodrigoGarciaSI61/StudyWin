package pe.edu.upc.studywinproyect.dtos;

public class ProductosCanjeadosDTO {
    private int id_recompensa;
    private String nombre_recompensa;
    private int total_productos_canjeados;

    public int getId_recompensa() {
        return id_recompensa;
    }

    public void setId_recompensa(int id_recompensa) {
        this.id_recompensa = id_recompensa;
    }

    public String getNombre_recompensa() {
        return nombre_recompensa;
    }

    public void setNombre_recompensa(String nombre_recompensa) {
        this.nombre_recompensa = nombre_recompensa;
    }

    public int getTotal_productos_canjeados() {
        return total_productos_canjeados;
    }

    public void setTotal_productos_canjeados(int total_productos_canjeados) {
        this.total_productos_canjeados = total_productos_canjeados;
    }
}
