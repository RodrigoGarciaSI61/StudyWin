package pe.edu.upc.studywinproyect.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.studywinproyect.entities.DetalleXCanje;
import pe.edu.upc.studywinproyect.repositories.IDetalleXCanjeRepository;
import pe.edu.upc.studywinproyect.serviceInterfaces.IDetalleXCanjeService;

import java.util.List;

@Service
public class DetalleXCanjeServiceImplement implements IDetalleXCanjeService {
    @Autowired
    private IDetalleXCanjeRepository detalleXCanjeRepository;

    @Override
    public List<DetalleXCanje> list() {
        return detalleXCanjeRepository.findAll();
    }

    @Override
    public void insert(DetalleXCanje detalleXCanje) {
        detalleXCanjeRepository.save(detalleXCanje);
    }

    @Override
    public void update(DetalleXCanje detalleXCanje) {
        detalleXCanjeRepository.save(detalleXCanje);
    }

    @Override
    public void delete(int id) {
        detalleXCanjeRepository.deleteById(id);
    }

    @Override
    public List<DetalleXCanje> findByCanjeId(int idCanje) {
        return detalleXCanjeRepository.findByCanjeId(idCanje);
    }

    @Override
    public List<DetalleXCanje> findByRecompensaId(int idRecompensa) {
        return detalleXCanjeRepository.findByRecompensaId(idRecompensa);
    }
}
