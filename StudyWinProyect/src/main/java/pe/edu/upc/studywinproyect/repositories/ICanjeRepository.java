package pe.edu.upc.studywinproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.studywinproyect.entities.Canje;

import java.time.LocalDate;
import java.util.List;

public interface ICanjeRepository extends JpaRepository<Canje, Integer> {
    public List<Canje> findByPurchaseDateDevice(LocalDate fecha);
}
