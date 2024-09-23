package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.studywinproyect.entities.Recompensa;

import java.util.List;

@Repository
public interface IRecompensaRepository extends JpaRepository<Recompensa, Integer> {

    //US037: Como programador quiero buscar una recompensa por su nombre para gestionarla.
    public List<Recompensa> findByNombre(String nombre);

    //US047: Como programador quiero listar las recompensas agotadas para gestionar el inventario.
    @Query(value = "SELECT R.id_recompensa, R.nombre, R.stock \n" +
            " FROM Recompensa R \n" +
            " WHERE stock = 0;",nativeQuery = true)
    public List<String[]> recompensasagotadas();

    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    @Query(value="SELECT A.id_asociado, A.empresa, A.RUC, COUNT(R.id_recompensa) AS cantidad_recompensas\n" +
            "FROM Asociado A\n" +
            "LEFT JOIN Recompensa R ON A.id_asociado = R.id_asociado\n" +
            "GROUP BY A.id_asociado, A.empresa, A.RUC;",nativeQuery = true)
    public List<String[]> recompesaxasociado();

    //US036: Como programador quiero listar las recompensas por tipo para gestionarlas.
    @Query(value = " SELECT tr.Tipo AS Tipo_de_Recompensa, COUNT(R.id_recompensa) AS Cantidad_de_Recompensas\n" +
            " FROM recompensa r\n" +
            " JOIN tipo_recompensa tr ON r.id_tipo = tr.id_tipo_recompensa\n" +
            " GROUP BY TR.Tipo\n" +
            " ORDER BY TR.Tipo;",nativeQuery = true)
    public List<String[]> recompensaxtipo();
    
    //US048: Como programador quiero listar las recompensas más populares para mejorar la oferta.
    @Query(value = "SELECT \n" +
            "    r.nombre AS Recompensa,\n" +
            "    r.descripcion AS Descripcion,\n" +
            "    r.puntos AS Puntos,\n" +
            "    SUM(dc.cantidad_producto_canje) AS Total_Canjes\n" +
            " FROM \n" +
            "    Recompensa r\n" +
            " JOIN \n" +
            "    Detalle_Canje dc ON r.id_recompensa = dc.id_recompensa\n" +
            " JOIN \n" +
            "    Canje c ON dc.id_canje = c.id_canje\n" +
            " GROUP BY \n" +
            "    r.id_recompensa, r.nombre, r.descripcion, r.puntos\n" +
            " ORDER BY \n" +
            "    Total_Canjes DESC\n" +
            " LIMIT 10;", nativeQuery = true)
    public List<String[]> recompensaspopulares();
}
