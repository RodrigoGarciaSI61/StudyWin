package pe.edu.upc.studywinproyect.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.studywinproyect.entities.Canje;
import java.time.LocalDate;
import java.util.List;

public interface ICanjeRepository extends JpaRepository<Canje, Integer> {
    public List<Canje> findByPurchaseDateDevice(LocalDate fecha);
    //Como usuario quiero buscar por departamento a los canjes para gestionarlos
    @Query("SELECT c FROM Canje c WHERE c.departamento LIKE %:departamento%")
    List<Canje> buscarDepartamento(String departamento);
    //Como usuario quiero listar los canjes por usuario para gestionarlos
    @Query(value="SELECT U.id_usuario, U.email, U.apellidos, COUNT(C.id_canje) AS cantidad_canjes\n" +
            "FROM Usuario U\n" +
            "LEFT JOIN Canje C ON U.id_usuario = C.id_usuario\n" +
            "GROUP BY U.id_usuario, U.nombres, U.apellidos;",nativeQuery = true)
    public List<String[]> canjexusuario();
    ////Como programador quiero listar la cantidad de canjes por fecha para gestionarlo
    @Query(value=" SELECT purchase_date_device, COUNT(*) AS cantidad_canjes\n" +
            " FROM Canje\n" +
            " GROUP BY purchase_date_device\n" +
            " ORDER BY purchase_date_device;",nativeQuery = true)
    public List<String[]> canjesxFecha();


}
