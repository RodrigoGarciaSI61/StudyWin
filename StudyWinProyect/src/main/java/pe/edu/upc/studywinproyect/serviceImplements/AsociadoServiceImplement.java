package pe.edu.upc.studywinproyect.serviceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.repositories.IAsociadoRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IAsociadoService;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AsociadoServiceImplement implements IAsociadoService {
    @Autowired
    private IAsociadoRepository aR;
    //Como programador quiero listar los canjes para gestionarlos
    @Override
    public List<Asociado> list() {
        return aR.findAll();
    }
    //Como programador quiero guardar a los canjes para gestionarlos
    @Override
    public void insert(Asociado curso) {
        aR.save(curso);
    }
    //Como programador quiero listar por id a los canjes
    @Override
    public Asociado listID(int id) {
        return aR.findById(id).orElse(new Asociado());
    }
    //Como progrmador quiero modificar a los canjes para gestionarlos
    @Override
    public void update(Asociado curso) {
        aR.save(curso);
    }
    //Como programador quiero eliminar a los canjes para gestionarlos
    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public List<Asociado> buscarFecha(LocalDate fecha_inicio) {
        return aR.findByFecha_inicioAfter(fecha_inicio);
    }

    @Override
    public List<Asociado> findByEmpresaContaining(String empresa) {
        return aR.findByEmpresaContaining(empresa);
    }

}
