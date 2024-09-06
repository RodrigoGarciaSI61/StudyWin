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
    @Query("SELECT c FROM Curso c WHERE c.categoria=:categoria")
    public List<Curso> buscarporCategoria(String categoria);

}
