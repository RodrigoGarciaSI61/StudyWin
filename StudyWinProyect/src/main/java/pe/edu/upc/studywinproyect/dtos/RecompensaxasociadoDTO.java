package pe.edu.upc.studywinproyect.dtos;

public class RecompensaxasociadoDTO {
    private int id_asociado;
    private String empresa;
    private String ruc;
    private int cantidad_recompensas;

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

    public String getRUC() {
        return ruc;
    }

    public void setRUC(String ruc) {
        this.ruc = ruc;
    }

    public int getCantidad_recompensas() {
        return cantidad_recompensas;
    }

    public void setCantidad_recompensas(int cantidad_recompensas) {
        this.cantidad_recompensas = cantidad_recompensas;
    }
}
