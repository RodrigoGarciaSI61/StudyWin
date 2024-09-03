package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    @Query("SELECT u FROM Usuario u WHERE u.nombres = :nombres OR u.apellidos = :apellidos")
    List<Usuario> buscar(@Param("nombres") String nombres, @Param("apellidos") String apellidos);
}
