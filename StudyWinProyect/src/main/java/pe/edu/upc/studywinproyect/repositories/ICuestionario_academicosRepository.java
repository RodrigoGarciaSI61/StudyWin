package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.studywinproyect.entities.Cuestionario_academico;

import java.util.List;

public interface ICuestionario_academicosRepository extends JpaRepository<Cuestionario_academico,Integer> {
    //Como programador quiero listar los cuestionarios por curso para gestionarlos
    @Query(value="SELECT C.id_curso, C.nombre, C.categoria, COUNT(cu.id_cuestionario) AS cantidad_cuestionarios\n" +
            "FROM Curso C\n" +
            "LEFT JOIN Cuestionario_academico Cu ON C.id_curso = Cu.id_curso\n" +
            "GROUP BY C.id_curso, C.nombre, C.categoria;",nativeQuery = true)
    public List<String[]> cuestionarioxcurso();
}
