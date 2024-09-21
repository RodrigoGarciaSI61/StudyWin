package pe.edu.upc.studywinproyect.dtos;

public class CantCanjeadosxDepartamentoDTO {
    private String departamento;
    private int total_productos_canjeados;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getTotal_productos_canjeados() {
        return total_productos_canjeados;
    }

    public void setTotal_productos_canjeados(int total_productos_canjeados) {
        this.total_productos_canjeados = total_productos_canjeados;
    }
}
