package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.studywinproyect.entities.Pregunta;

import java.util.List;

public interface IPreguntaRepository extends JpaRepository<Pregunta, Integer> {
    //Como usuario quiero listar los preguntas por cuestionarios para gestionarlos
    @Query(value=" SELECT C.id_cuestionario, C.nombre, C.tiempo_limite, COUNT(P.id_pregunta) AS cantidad_preguntas\n" +
            " FROM Cuestionario_academico C\n" +
            " LEFT JOIN Pregunta P ON C.id_cuestionario = P.id_cuestionario\n" +
            " GROUP BY C.id_cuestionario, C.nombre, C.tiempo_limite;",nativeQuery = true)
    public List<String[]> preguntasxcuestionario();
}
