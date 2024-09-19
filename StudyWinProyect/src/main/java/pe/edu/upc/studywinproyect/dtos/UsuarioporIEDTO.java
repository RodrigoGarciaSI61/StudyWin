package pe.edu.upc.studywinproyect.dtos;

public class UsuarioporIEDTO {
    private String nombreIE;
    private int cantidad_usuarios;

    public String getNombreIE() {
        return nombreIE;
    }

    public void setNombreIE(String nombreIE) {
        this.nombreIE = nombreIE;
    }

    public int getCantidad_usuarios() {
        return cantidad_usuarios;
    }

    public void setCantidad_usuarios(int cantidad_usuarios) {
        this.cantidad_usuarios = cantidad_usuarios;
    }
}
