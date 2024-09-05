package pe.edu.upc.studywinproyect.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.studywinproyect.entities.Asociado;

import java.time.LocalDate;
import java.util.List;

public interface IAsociadoRepository extends JpaRepository<Asociado, Integer> {
    @Query("SELECT a FROM Asociado a WHERE a.fecha_inicio > :fecha")
    public List<Asociado> findByFecha_inicioAfter(@Param("fecha") LocalDate fecha);
    @Query("SELECT a FROM Asociado a WHERE a.empresa LIKE %:empresa%")
    public List<Asociado> findByEmpresaContaining(@Param("empresa") String empresa);


}
