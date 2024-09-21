package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CantCanjeadosxDepartamentoDTO;
import pe.edu.upc.studywinproyect.dtos.DetalleXCanjeDTO;
import pe.edu.upc.studywinproyect.dtos.ProductosCanjeadosDTO;
import pe.edu.upc.studywinproyect.entities.DetalleXCanje;
import pe.edu.upc.studywinproyect.serviceInterfaces.IDetalleXCanjeService;

import java.util.ArrayList;
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
    //Como programador, quiero listar la cantidad total de productos canjeados por recompensa, junto con el nombre de la recompensa, para gestionar el inventario.
    @GetMapping("/productoscanjeados")
    public List<ProductosCanjeadosDTO> productosCanjeados(){
        List<String[]> lista=detalleXCanjeService.productoscanjeados();
        List<ProductosCanjeadosDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ProductosCanjeadosDTO dto=new ProductosCanjeadosDTO();
            dto.setId_recompensa(Integer.parseInt(columna[0]));
            dto.setNombre_recompensa(columna[1]);
            if (columna[2] != null) {
                dto.setTotal_productos_canjeados(Integer.parseInt(columna[2]));
            }else{
                dto.setTotal_productos_canjeados(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    //Como programador, quiero obtener la cantidad total de productos canjeados por departamento para poder analizar el comportamiento de consumo en diferentes regiones geográficas.
    @GetMapping("/cantcanjeadosxdepartamento")
    public List<CantCanjeadosxDepartamentoDTO> cantcanjeadosxdepartamento(){
        List<String[]> lista=detalleXCanjeService.cantcanjeadosxdepartamento();
        List<CantCanjeadosxDepartamentoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CantCanjeadosxDepartamentoDTO dto=new CantCanjeadosxDepartamentoDTO();
            dto.setDepartamento(columna[0]);
            if (columna[1] != null) {
                dto.setTotal_productos_canjeados(Integer.parseInt(columna[2]));
            }else{
                dto.setTotal_productos_canjeados(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
