package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

import java.util.List;

public interface ITipoRecompensaService {
    public List<TipoRecompensa> list();

    public void insert(TipoRecompensa tiporecompensa);

    public void update(TipoRecompensa tiporecompensa);

    public void delete(int id);
}
