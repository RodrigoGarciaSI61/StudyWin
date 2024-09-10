package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Recompensa;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

import java.util.List;

@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Integer> {

    //US037: Como programador quiero buscar una recompensa por su nombre para gestionarla.
    public List<Recompensa> findByNombre(String nombre);

    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    @Query(value="SELECT A.id_asociado, A.empresa, A.RUC, COUNT(R.id_recompensa) AS cantidad_recompensas\n" +
            "FROM Asociado A\n" +
            "LEFT JOIN Recompensa R ON A.id_asociado = R.id_asociado\n" +
            "GROUP BY A.id_asociado, A.empresa, A.RUC;",nativeQuery = true)
    public List<String[]> recompesaxasociado();

    //US036: Como programador quiero listar las recompensas por tipo para gestionarlas.
    @Query(value = "SELECT R.nombre, T.Tipo\n" +
            "FROM Recompensa R\n" +
            "JOIN tipo_recompensa T\n" +
            "ON R.id_tipo = T.id_tipo_recompensa;",nativeQuery = true)
    public List<String[]> recompensaxtipo();
}
