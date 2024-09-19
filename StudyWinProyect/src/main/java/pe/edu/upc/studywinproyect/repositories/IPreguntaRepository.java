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
    //Como programador, quiero listar las preguntas con la mayor cantidad de puntos en cada cuestionario académico para identificar las preguntas más valiosas en cada cuestionario.
    @Query(value=" SELECT p.id_pregunta, p.pregunta, p.puntos, p.respuesta, c.id_cuestionario, c.nombre AS nombre_cuestionario\n" +
            " FROM pregunta p\n" +
            " JOIN cuestionario_academico c ON p.id_cuestionario = c.id_cuestionario\n" +
            " JOIN (\n" +
            "    SELECT id_cuestionario, MAX(puntos) AS max_puntos\n" +
            "    FROM pregunta\n" +
            "    GROUP BY id_cuestionario\n" +
            ") max_p ON p.id_cuestionario = max_p.id_cuestionario AND p.puntos = max_p.max_puntos;",nativeQuery=true)
    public List<String[]> preguntasmayorcantpuntos();


}
