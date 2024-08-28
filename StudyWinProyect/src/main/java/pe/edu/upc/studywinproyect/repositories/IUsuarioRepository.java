package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.studywinproyect.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
