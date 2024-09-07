package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.entities.Recompensa;

import java.util.List;

public interface IRecompensaService {

    public List<Recompensa> list();

    public void insert(Recompensa r);

    public void update(Recompensa r);

    public void delete(int id);

    public List<Recompensa> buscarNombre(String nombre);
    //Como usuario quiero listar la cantidad de recompensas por asociados para gestionarlos
    public List<String[]> recompesaxasociado();

}
