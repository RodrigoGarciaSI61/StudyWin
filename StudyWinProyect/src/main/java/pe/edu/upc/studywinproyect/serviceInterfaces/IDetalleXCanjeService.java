package pe.edu.upc.studywinproyect.serviceInterfaces;

import pe.edu.upc.studywinproyect.entities.DetalleXCanje;

import java.util.List;

public interface IDetalleXCanjeService {
    // Como programador quiero listar todos los detalles de canje
    public List<DetalleXCanje> list();

    // Como programador quiero insertar un nuevo detalle de canje
    public void insert(DetalleXCanje detalleXCanje);

    // Como programador quiero actualizar un detalle de canje existente
    public void update(DetalleXCanje detalleXCanje);

    // Como programador quiero eliminar un detalle de canje por su ID
    public void delete(int id);

    // Como programador quiero buscar detalles de canje por ID de canje
    public List<DetalleXCanje> findByCanjeId(int idCanje);

    // Como programador quiero buscar detalles de canje por ID de recompensa
    public List<DetalleXCanje> findByRecompensaId(int idRecompensa);
    //Como programador, quiero listar la cantidad total de productos canjeados por recompensa, junto con el nombre de la recompensa, para gestionar el inventario.
    public List<String[]> productoscanjeados();
    //Como programador, quiero obtener la cantidad total de productos canjeados por departamento para poder analizar el comportamiento de consumo en diferentes regiones geográficas.
    public List<String[]> cantcanjeadosxdepartamento();
}
