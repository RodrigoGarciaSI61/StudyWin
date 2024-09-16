package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Curso;

import java.util.List;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {

    //Como programador quiero buscar a los cursos por nombre para gestionarlos
    @Query("SELECT c FROM Curso c WHERE c.nombre=:nombre")
    public List<Curso> buscarporNombre(String nombre);
    //Como programador quiero buscar a los cursos por categoria para gestionarlos
    @Query("SELECT c FROM Curso c WHERE c.categoria LIKE %:categoria")
    public List<Curso> buscarporCategoria(String categoria);
    //Como programador quiero listar la cantidad de cursos por categoria para gestionarlos
    @Query(value=" SELECT categoria, COUNT(*) AS cantidad_cursos\n" +
            " FROM Curso\n" +
            " GROUP BY categoria\n" +
            " ORDER BY cantidad_cursos DESC ",nativeQuery=true)
    public List<String[]> cursosxcategoria();
    }

