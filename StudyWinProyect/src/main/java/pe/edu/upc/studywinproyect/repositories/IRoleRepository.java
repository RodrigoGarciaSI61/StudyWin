package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
