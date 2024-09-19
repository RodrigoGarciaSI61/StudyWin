package pe.edu.upc.studywinproyect.dtos;

public class EnabledUsersDTO {
    private String estado_usuario;
    private int cantUsuarios;

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public void setCantUsuarios(int cantUsuarios) {
        this.cantUsuarios = cantUsuarios;
    }
}
