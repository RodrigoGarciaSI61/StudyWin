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
    //Como programador, quiero listar la cantidad total de productos canjeados por recompensa, junto con el nombre de la recompensa, para gestionar el inventario.
    @Query(value = " SELECT r.id_recompensa,r.nombre AS nombre_recompensa, SUM(dc.cantidad_producto_canje) AS total_productos_canjeados\n" +
            " FROM detalle_canje dc\n" +
            " JOIN recompensa r ON dc.id_recompensa = r.id_recompensa\n" +
            " GROUP BY r.id_recompensa,r.nombre;\n",nativeQuery = true)
    public List<String[]> productoscanjeados();
    //Como programador, quiero obtener la cantidad total de productos canjeados por departamento para poder analizar el comportamiento de consumo en diferentes regiones geográficas.
    @Query(value = " SELECT c.departamento, SUM(dc.cantidad_producto_canje) AS total_productos_canjeados\n" +
            " FROM detalle_canje dc\n" +
            " JOIN canje c ON dc.id_canje = c.id_canje\n" +
            " GROUP BY c.departamento;",nativeQuery = true)
    public List<String[]> cantcanjeadosxdepartamento();
}
