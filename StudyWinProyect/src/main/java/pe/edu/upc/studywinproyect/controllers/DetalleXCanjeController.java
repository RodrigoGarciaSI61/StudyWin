package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.DetalleXCanjeDTO;
import pe.edu.upc.studywinproyect.entities.DetalleXCanje;
import pe.edu.upc.studywinproyect.serviceInterfaces.IDetalleXCanjeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detalle_canje")
public class DetalleXCanjeController {
    @Autowired
    private IDetalleXCanjeService detalleXCanjeService;

    // Listar todos los detalles de canje
    @GetMapping
    public List<DetalleXCanjeDTO> listar() {
        return detalleXCanjeService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleXCanjeDTO.class);
        }).collect(Collectors.toList());
    }

    // Registrar un nuevo detalle de canje
    @PostMapping
    public void registrar(@RequestBody DetalleXCanjeDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleXCanje detalleXCanje = m.map(dto, DetalleXCanje.class);
        detalleXCanjeService.insert(detalleXCanje);
    }

    // Modificar un detalle de canje existente
    @PutMapping
    public void modificar(@RequestBody DetalleXCanjeDTO dto) {
        ModelMapper m = new ModelMapper();
        DetalleXCanje detalleXCanje = m.map(dto, DetalleXCanje.class);
        detalleXCanjeService.update(detalleXCanje);
    }

    // Eliminar un detalle de canje por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        detalleXCanjeService.delete(id);
    }

    // Buscar detalles de canje por ID de canje
    @GetMapping("/buscarPorCanje/{idCanje}")
    public List<DetalleXCanjeDTO> buscarPorCanje(@PathVariable("idCanje") Integer idCanje) {
        return detalleXCanjeService.findByCanjeId(idCanje).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleXCanjeDTO.class);
        }).collect(Collectors.toList());
    }

    // Buscar detalles de canje por ID de recompensa
    @GetMapping("/buscarPorRecompensa/{idRecompensa}")
    public List<DetalleXCanjeDTO> buscarPorRecompensa(@PathVariable("idRecompensa") Integer idRecompensa) {
        return detalleXCanjeService.findByRecompensaId(idRecompensa).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleXCanjeDTO.class);
        }).collect(Collectors.toList());
    }
}
