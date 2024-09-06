package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CanjeDTO;
import pe.edu.upc.studywinproyect.entities.Canje;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICanjeService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/canje")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class CanjeController {
    @Autowired
    private ICanjeService cS;
    //Como programador quiero listar los canjes para gestionarlos
    @GetMapping
    public List<CanjeDTO> listar() {
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CanjeDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a los canjes para gestionarlos
    @PostMapping
    public void registrar(@RequestBody CanjeDTO dto) {
        ModelMapper m=new ModelMapper();
        Canje u=m.map(dto, Canje.class);
        cS.insert(u);
    }
    //Como programador quiero listar por id a los canjes
    @GetMapping("/{id}")
    public CanjeDTO listarporID(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CanjeDTO dto=m.map(cS.listID(id),CanjeDTO.class);
        return dto;
    }
    //Como progrmador quiero modificar a los canjes para gestionarlos
    @PutMapping
    public void modificar(@RequestBody CanjeDTO dto){
        ModelMapper m = new ModelMapper();
        Canje ro=m.map(dto,Canje.class);
        cS.update(ro);
    }
    //Como programador quiero eliminar a los canjes para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    //Como programador quiero buscar a los canjes por fecha para gestionarlos
    @GetMapping("/busquedas")
    public List<CanjeDTO> buscar(@RequestParam LocalDate f){
        return cS.buscarFecha(f).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CanjeDTO.class);
        }).collect(Collectors.toList());
    }
}