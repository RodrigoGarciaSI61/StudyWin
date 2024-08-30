package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Curso;
@Repository
public interface ICursoRepository extends JpaRepository<Curso, Integer> {
}
