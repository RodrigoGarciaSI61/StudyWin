package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    //Como programador quiero listar los usuarios para gestionarlos
    public List<Usuario> list();
    //Como programador quiero guardar a los usuarios para gestionarlos
    public void insert(Usuario usuario);
    //como programador quiero listar la cantidad de usuarios inhabilitados y la cantidad de usuarios habilitados para poder gestionarlos,
    public List<String[]> enabledUsers();
    //Como progrmador quiero modificar a los usuarios para gestionarlos
    public void update(Usuario usuario);
    //Como programador quiero eliminar a los usuarios para gestionarlos
    public void delete(Long id);
    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    public List<Usuario> buscarporNombre(String nombre, String apellidos);
    //Como usuario quiero buscar por DNI a los usuarios para gestionarlo
    public List<Usuario> buscarporDni(String dni);
    //Como programador quiero listar la cantidad de usuarios por institución educativa para gestionarlo
    public List<String[]> UsuariosporIE();

}
