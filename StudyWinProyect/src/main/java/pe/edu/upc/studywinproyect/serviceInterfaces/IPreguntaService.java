package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Pregunta;

import java.util.List;

public interface IPreguntaService {
    // Como programador quiero listar todas las preguntas
    public List<Pregunta> list();

    // Como programador quiero insertar una nueva pregunta
    public void insert(Pregunta pregunta);

    // Como programador quiero actualizar una pregunta
    public void update(Pregunta pregunta);

    // Como programador quiero eliminar una pregunta
    public void delete(int id);
    //Como usuario quiero listar las preguntas por cuestionarios academics para gestionarlos
    public List<String[]> preguntaxcuestionario();
    //Como programador, quiero listar las preguntas con la mayor cantidad de puntos en cada cuestionario académico para identificar las preguntas más valiosas en cada cuestionario.
    public List<String[]> preguntasmayorcantpuntos();
}
