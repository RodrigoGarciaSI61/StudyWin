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
}
