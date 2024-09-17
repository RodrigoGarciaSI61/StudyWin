package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.entities.Recompensa;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;

import java.util.List;

public interface IRecompensaService {

    public List<Recompensa> list();

    public void insert(Recompensa r);

    public void update(Recompensa r);

    public void delete(int id);

    public List<Recompensa> buscarNombre(String nombre);

    public List<String[]> recompensaagotada();

    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    public List<String[]> recompesaxasociado();

    //US036: Como programador quiero listar la cantidad de recompensas por tipo para gestionarlas.
    public List<String[]> recompensaxtipo();

    //US048: Como programador quiero listar las recompensas más populares para mejorar la oferta.
    public List<String[]> rpopulares();

}
