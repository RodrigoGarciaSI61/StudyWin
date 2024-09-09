package pe.edu.upc.studywinproyect.dtos;

public class CanjexUsuarioDTO {
    private int id_usuario;
    private String email;
    private String apellidos;
    private int catidad_canjes;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCatidad_canjes() {
        return catidad_canjes;
    }

    public void setCatidad_canjes(int catidad_canjes) {
        this.catidad_canjes = catidad_canjes;
    }
}
