package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.repositories.ICursoRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICursoService;
import java.util.List;

@Service
public class CursoServiceImplement implements ICursoService {
    @Autowired
    private ICursoRepository cR;
    //Como programador quiero listar los cursos para gestionarlos
    @Override
    public List<Curso> list() {
        return cR.findAll();
    }
    //Como programador quiero guardar a los cursos para gestionarlos
    @Override
    public void insert(Curso curso) {
        cR.save(curso);
    }
    //Como programador quiero listar por id a los cursos
    @Override
    public Curso listID(int id) {
        return cR.findById(id).orElse(new Curso());
    }
    //Como progrmador quiero modificar a los cursos para gestionarlos
    @Override
    public void update(Curso curso) {
        cR.save(curso);
    }
    //Como programador quiero eliminar a los cursos para gestionarlos
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
    //Como programador quiero buscar a los cursos por nombre para gestionarlos
    @Override
    public List<Curso> buscarporNombre(String nombre) {
        return cR.buscarporNombre(nombre);
    }

    @Override
    public List<Curso> buscarporCategoria(String categoria) {
        return cR.buscarporCategoria(categoria);
    }
}
