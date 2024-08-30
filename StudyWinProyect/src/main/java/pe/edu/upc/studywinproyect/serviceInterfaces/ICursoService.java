package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.entities.Usuario;

import java.util.List;

public interface ICursoService {
    //Como programador quiero listar los cursos para gestionarlos
    public List<Curso> list();
    //Como programador quiero guardar a los cursos para gestionarlos
    public void insert(Curso curso);
    //Como programador quiero listar por id a los cursos
    public Curso listID(int id);
    //Como progrmador quiero modificar a los cursos para gestionarlos
    public void update(Curso curso);
    //Como programador quiero eliminar a los cursos para gestionarlos
    public void delete(int id);
}
