package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Pregunta;
import pe.edu.upc.studywinproyect.repositories.IPreguntaRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IPreguntaService;

import java.util.List;


@Service
public class PreguntaServiceImplement implements IPreguntaService {
    @Autowired
    private IPreguntaRepository pR;
    //Como programador quiero listar las preguntas para gestionarlos
    @Override
    public List<Pregunta> list() {
        return pR.findAll();
    }
    //Como programador quiero guardar a las preguntas para gestionarlos
    @Override
    public void insert(Pregunta pregunta) {
        pR.save(pregunta);
    }
    //Como programador quiero modificar a las preguntas para gestionarlos
    @Override
    public void update(Pregunta pregunta) {
        pR.save(pregunta);
    }
    //Como programador quiero eliminar a las preguntas para gestionarlos
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }
    //Como usuario quiero listar la cantidad de preguntas por cuestionarios
    @Override
    public List<String[]> preguntaxcuestionario() {
        return pR.preguntasxcuestionario();
    }
    //Como programador, quiero listar las preguntas con la mayor cantidad de puntos en cada cuestionario académico para identificar las preguntas más valiosas en cada cuestionario.
    @Override
    public List<String[]> preguntasmayorcantpuntos() {
        return pR.preguntasmayorcantpuntos();
    }
}
