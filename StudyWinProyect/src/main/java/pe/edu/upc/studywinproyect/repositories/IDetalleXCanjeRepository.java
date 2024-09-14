package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.DetalleXCanje;

import java.util.List;

@Repository
public interface IDetalleXCanjeRepository extends JpaRepository<DetalleXCanje, Integer> {

    // Buscar detalles de canje por id de canje
    @Query("SELECT d FROM DetalleXCanje d WHERE d.canje.id_canje = :idCanje")
    List<DetalleXCanje> findByCanjeId(int idCanje);

    // Buscar detalles de canje por id de recompensa
    @Query("SELECT d FROM DetalleXCanje d WHERE d.recompensa.id_recompensa = :idRecompensa")
    List<DetalleXCanje> findByRecompensaId(int idRecompensa);

    // Listar todos los detalles de canje
    @Query("SELECT d FROM DetalleXCanje d")
    List<DetalleXCanje> findAllDetalles();
}
