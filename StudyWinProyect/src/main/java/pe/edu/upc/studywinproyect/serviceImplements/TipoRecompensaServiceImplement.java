package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;
import pe.edu.upc.studywinproyect.repositories.ITipoRecompensaRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.ITipoRecompensaService;

import java.util.List;

@Service
public class TipoRecompensaServiceImplement implements ITipoRecompensaService {
    @Autowired
    private ITipoRecompensaRepository trR;

    @Override
    public List<TipoRecompensa> list() {
        return trR.findAll();
    }

    @Override
    public void insert(TipoRecompensa tiporecompensa) {
        trR.save(tiporecompensa);
    }

    @Override
    public void update(TipoRecompensa tiporecompensa) {
        trR.save(tiporecompensa);
    }

    @Override
    public void delete(int id) {
        trR.deleteById(id);
    }
}
