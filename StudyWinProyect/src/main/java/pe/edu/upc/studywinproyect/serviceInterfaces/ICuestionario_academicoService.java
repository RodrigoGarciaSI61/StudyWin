package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Cuestionario_academico;

import java.util.List;

public interface ICuestionario_academicoService {
    // Como programador quiero listar todos los cuestionarios academicos
    public List<Cuestionario_academico> list();

    // Como programador quiero insertar un nuevo cuestionario academicos
    public void insert(Cuestionario_academico cuestionario_academico);

    // Como programador quiero actualizar un cuestionario academico
    public void update(Cuestionario_academico cuestionario_academico);

    // Como programador quiero eliminar un cuestionario academico
    public void delete(int id);
    //Como usuario quiero listar los cuestionarios por curso para gestionarlos
    public List<String[]> cuestionario_academicoxcurso();
    //Como programador quiero listar la Cantidad de cuestionarios resueltos por usuario
    public List<String[]> cuestionariosresueltos();
}
