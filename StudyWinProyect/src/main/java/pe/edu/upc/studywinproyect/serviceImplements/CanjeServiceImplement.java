package pe.edu.upc.studywinproyect.serviceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Canje;
import pe.edu.upc.studywinproyect.repositories.ICanjeRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICanjeService;
import java.time.LocalDate;
import java.util.List;

@Service
public class CanjeServiceImplement implements ICanjeService {
    @Autowired
    private ICanjeRepository cR;
    //Como programador quiero listar los canjes para gestionarlos
    @Override
    public List<Canje> list() {
        return cR.findAll();
    }
    //Como programador quiero guardar a los canjes para gestionarlos
    @Override
    public void insert(Canje curso) {
        cR.save(curso);
    }
    //Como programador quiero listar por id a los canjes
    @Override
    public Canje listID(int id) {
        return cR.findById(id).orElse(new Canje());
    }
    //Como progrmador quiero modificar a los canjes para gestionarlos
    @Override
    public void update(Canje curso) {
        cR.save(curso);
    }
    //Como programador quiero eliminar a los canjes para gestionarlos
    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
    //Como usuario quiero buscar por fecha a los canjes para gestionarlos
    @Override
    public List<Canje> buscarFecha(LocalDate fecha) {
        return cR.findByfecha(fecha);
    }
    //Como usuario quiero buscar por departamento a los canjes para gestionarlos
    @Override
    public List<Canje> buscarDepartamento(String departamento) {
        return cR.buscarDepartamento(departamento);
    }
    //Como usuario quiero listar la cantidad de canjes por usuario
    @Override
    public List<String[]> canjexusuario() {
        return cR.canjexusuario();
    }

    @Override
    public List<String[]> canjexFecha() {
        return cR.canjesxFecha();
    }
}
