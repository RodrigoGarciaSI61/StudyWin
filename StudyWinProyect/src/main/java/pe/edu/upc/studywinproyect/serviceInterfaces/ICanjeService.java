package pe.edu.upc.studywinproyect.serviceInterfaces;
import pe.edu.upc.studywinproyect.entities.Canje;

import java.time.LocalDate;
import java.util.List;

public interface ICanjeService {
    //Como programador quiero listar los canjes para gestionarlos
    public List<Canje> list();
    //Como programador quiero guardar a los canjes para gestionarlos
    public void insert(Canje canje);
    //Como programador quiero listar por id a los canjes
    public Canje listID(int id);
    //Como progrmador quiero modificar a los canjes para gestionarlos
    public void update(Canje canje);
    //Como programador quiero eliminar a los canjes para gestionarlos
    public void delete(int id);
    //Como usuario quiero buscar por fecha a los canjes para gestionarlos
    List<Canje> buscarFecha(LocalDate fecha);
    //Como usuario quiero buscar por departamento a los canjes para gestionarlos
    List<Canje> buscarDepartamento(String departamento);
}
