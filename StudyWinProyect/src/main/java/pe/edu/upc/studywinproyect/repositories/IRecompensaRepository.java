package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Recompensa;

import java.util.List;

@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Integer> {

    public List<Recompensa> findByNombre(String nombre);
    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    @Query(value="SELECT A.id_asociado, A.empresa, A.RUC, COUNT(R.id_recompensa) AS cantidad_recompensas\n" +
            "FROM Asociado A\n" +
            "LEFT JOIN Recompensa R ON A.id_asociado = R.id_asociado\n" +
            "GROUP BY A.id_asociado, A.empresa, A.RUC;",nativeQuery = true)
    public List<String[]> recompesaxasociado();
}
