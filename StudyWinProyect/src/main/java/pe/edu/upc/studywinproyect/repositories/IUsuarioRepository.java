package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.studywinproyect.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findOneByemail(String email);

    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    @Query("SELECT u FROM Usuario u WHERE u.nombres = :nombres OR u.apellidos = :apellidos")
    List<Usuario> buscar(@Param("nombres") String nombres, @Param("apellidos") String apellidos);
    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);
    //Como usuario quiero buscar por DNI a los usuarios para gestionarlo
    @Query("SELECT u FROM Usuario u WHERE u.dni=:dni")
    public List<Usuario> buscarporDni(String dni);
    //Como usuario quiero buscar por institucion educativa a los usuarios para gestionarlo
    @Query("SELECT u FROM Usuario u WHERE u.institucion_educativa=:institucion_educativa")
    public List<Usuario> buscarporIE(String institucion_educativa);
}
