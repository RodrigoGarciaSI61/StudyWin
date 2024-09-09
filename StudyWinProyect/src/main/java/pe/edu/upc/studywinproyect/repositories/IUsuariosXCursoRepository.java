package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;

@Repository
public interface IUsuariosXCursoRepository extends JpaRepository<UsuariosXCurso, Long> {
}
