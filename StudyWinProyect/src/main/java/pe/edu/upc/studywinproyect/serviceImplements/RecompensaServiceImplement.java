package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.Recompensa;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;
import pe.edu.upc.studywinproyect.repositories.IRecompensaRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IRecompensaService;

import java.util.List;

@Service
public class RecompensaServiceImplement implements IRecompensaService {
    @Autowired
    private IRecompensaRepository rR;

    @Override
    public List<Recompensa> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Recompensa r) {
        rR.save(r);
    }

    @Override
    public void update(Recompensa r) {
        rR.save(r);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public List<Recompensa> buscarNombre(String nombre) {
        return rR.findByNombre(nombre);
    }

    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    @Override
    public List<String[]> recompesaxasociado() {
        return rR.recompesaxasociado();
    }

    @Override
    public List<String[]> recompensaxtipo() {
        return rR.recompensaxtipo();
    }
}
