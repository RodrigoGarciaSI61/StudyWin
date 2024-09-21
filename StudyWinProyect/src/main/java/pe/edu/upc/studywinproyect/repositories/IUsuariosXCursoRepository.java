package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;

import java.util.List;

@Repository
public interface IUsuariosXCursoRepository extends JpaRepository<UsuariosXCurso, Long> {
    //Como programador, quiero listar los usuarios que no están inscritos en ningún curso para identificar aquellos que necesitan ser asignados a uno.
    @Query(value=" SELECT u.id_usuario, u.nombres, u.apellidos, u.email\n" +
            " FROM usuario u\n" +
            " LEFT JOIN usuariosxcurso uc ON u.id_usuario = uc.id_usuario\n" +
            " WHERE uc.id_usuario IS NULL;\n",nativeQuery=true)
    public List<String[]> usuariossincurso();
    //Como programador, quiero listar la cantidad de usuarios inscritos por curso para poder analizar la participación.
    @Query(value=" SELECT c.id_curso, c.nombre AS nombre_curso, COUNT(uxc.id_usuario) AS cantidad_usuarios\n" +
            " FROM usuariosxcurso uxc\n" +
            " JOIN curso c ON uxc.id_curso = c.id_curso\n" +
            " GROUP BY c.id_curso, c.nombre;",nativeQuery = true)
    public List<String[]>  cursoscantusers();
}
