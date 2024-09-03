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
    //Como programador quiero listar por id a los usuarios
    @Override
    public Usuario listID(int id) {
        return uR.findById(id).orElse(new Usuario());
    }
    //Como progrmador quiero modificar a los usuarios para gestionarlos
    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }
    //Como programador quiero eliminar a los usuarios para gestionarlos
    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }
    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    @Override
    public List<Usuario> buscar(String nombre,String apellidos) {
        return uR.buscar(nombre, apellidos);
    }
}
