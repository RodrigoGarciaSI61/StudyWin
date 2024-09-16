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
    //Como programador quiero listar la Cantidad de cuestionarios resueltos por usuario
    @Query(value=" SELECT u.id_usuario, u.nombres, u.apellidos, COUNT(DISTINCT c.id_cuestionario) AS cuestionarios_resueltos\n" +
            " FROM Usuario u\n" +
            " JOIN UsuariosXCurso uc ON u.id_usuario = uc.id_usuario\n" +
            " JOIN Curso cu ON uc.id_curso = cu.id_curso\n" +
            " JOIN Cuestionario_academico c ON cu.id_curso = c.id_curso\n" +
            " JOIN Pregunta p ON c.id_cuestionario = p.id_cuestionario\n" +
            " GROUP BY u.id_usuario, u.nombres, u.apellidos\n" +
            " ORDER BY cuestionarios_resueltos DESC ;",nativeQuery = true)
    public List<String[]> cuestionariosresueltos();
}
