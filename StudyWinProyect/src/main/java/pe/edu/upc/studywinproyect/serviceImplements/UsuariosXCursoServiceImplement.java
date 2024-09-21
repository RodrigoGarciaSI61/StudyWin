package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;
import pe.edu.upc.studywinproyect.repositories.IUsuariosXCursoRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuariosXCursoService;

import java.util.List;

@Service
public class UsuariosXCursoServiceImplement implements IUsuariosXCursoService {
    @Autowired
    private IUsuariosXCursoRepository uxcR;

    @Override
    public List<UsuariosXCurso> list() {
        return uxcR.findAll();
    }

    @Override
    public void insert(UsuariosXCurso usuariosXCurso) {
        uxcR.save(usuariosXCurso);
    }

    @Override
    public UsuariosXCurso listID(Long id) {
        return uxcR.findById(id).orElse(new UsuariosXCurso());
    }

    @Override
    public void update(UsuariosXCurso usuariosXCurso) {
        uxcR.save(usuariosXCurso);
    }

    @Override
    public void delete(Long id) {
        uxcR.deleteById(id);
    }

    @Override
    public List<String[]> usuariossincurso() {
        return uxcR.usuariossincurso();
    }

    @Override
    public List<String[]> cursoscantusers() {
        return uxcR.cursoscantusers();
    }
}

