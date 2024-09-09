package pe.edu.upc.studywinproyect.serviceInterfaces;
import pe.edu.upc.studywinproyect.entities.Asociado;

import java.time.LocalDate;
import java.util.List;

public interface IAsociadoService {
    //Como programador quiero listar los asociados para gestionarlos
    public List<Asociado> list();
    //Como programador quiero guardar a los asociados para gestionarlos
    public void insert(Asociado asociado);
    //Como programador quiero listar por id a los asociados
    public Asociado listID(int id);
    //Como progrmador quiero modificar a los asociados para gestionarlos
    public void update(Asociado asociado);
    //Como programador quiero eliminar a los asociados para gestionarlos
    public void delete(int id);
    //Como usuario quiero buscar por fecha a los asociados para gestionarlos
    List<Asociado> buscarFecha(LocalDate fecha_inicio);
    //Como usuario quiero buscar por nombre a los asociados para gestionarlos
    public List<Asociado> findByEmpresaContaining(String empresa);
}
