package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    //Como programador quiero listar los usuarios para gestionarlos
    public List<Usuario> list();
    //Como programador quiero guardar alos usuarios para gestionarlos
    public void insert(Usuario usuario);
}
