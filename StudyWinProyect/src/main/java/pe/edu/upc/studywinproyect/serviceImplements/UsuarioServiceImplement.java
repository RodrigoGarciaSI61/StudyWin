package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Usuario;
import pe.edu.upc.studywinproyect.repositories.IUsuarioRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    //Como programador quiero listar los usuarios para gestionarlos
    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }
    //Como programador quiero guardar alos usuarios para gestionarlos
    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }
    //como programador quiero listar la cantidad de usuarios inhabilitados y la cantidad de usuarios habilitados para poder gestionarlos,
    @Override
    public List<String[]> enabledUsers() {
        return uR.EnabledUsers();
    }
    //Como progrmador quiero modificar a los usuarios para gestionarlos
    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }
    //Como programador quiero eliminar a los usuarios para gestionarlos
    @Override
    public void delete(Long id) {
        uR.deleteById(id);
    }
    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    @Override
    public List<Usuario> buscarporNombre(String nombre,String apellidos) {
        return uR.buscar(nombre, apellidos);
    }
    //Como usuario quiero buscar por DNI a los usuarios para gestionarlo
    @Override
    public List<Usuario> buscarporDni(String dni) {
        return uR.buscarporDni(dni);
    }
    //Como programador quiero listar la cantidad de usuarios por institución educativa para gestionarlo
    @Override
    public List<String[]> UsuariosporIE() {
        return uR.UsuariosxIE();
    }

}
