package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Cuestionario_academico;
import pe.edu.upc.studywinproyect.repositories.ICuestionario_academicosRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICuestionario_academicoService;

import java.util.List;

@Service
public class Cuestionario_academicoServiceImplement implements ICuestionario_academicoService {
    @Autowired
    private ICuestionario_academicosRepository cR;
    //Como programador quiero listar los cuestionarios academicos para gestionarlos
    @Override
    public List<Cuestionario_academico> list() {
        return cR.findAll();
    }
    //Como programador quiero guardar a los cuestionarios academicospara gestionarlos
    @Override
    public void insert(Cuestionario_academico cuestionario_academico) {
        cR.save(cuestionario_academico);
    }
    //Como progrmador quiero modificar a los cuestionarios academicos para gestionarlos
    @Override
    public void update(Cuestionario_academico cuestionario_academico) {
        cR.save(cuestionario_academico);
    }
    //Como programador quiero eliminar a los cuestionarios academicos para gestionarlos
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
    //Como usuario quiero listar la cantidad de cuestionarios academicos por curso
    @Override
    public List<String[]> cuestionario_academicoxcurso() {
        return cR.cuestionarioxcurso();
    }
    //Como programador quiero listar la Cantidad de cuestionarios resueltos por usuario
    @Override
    public List<String[]> cuestionariosresueltos() {
        return cR.cuestionariosresueltos();
    }

}
