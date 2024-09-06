package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.AsociadoDTO;
import pe.edu.upc.studywinproyect.entities.Asociado;
import pe.edu.upc.studywinproyect.serviceInterfaces.IAsociadoService;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/asociado")
@PreAuthorize("hasAuthority('ADMINISTRADOR')")
public class AsociadoController {
    @Autowired
    private IAsociadoService aS;
    //Como programador quiero listar los asociados para gestionarlos
    @GetMapping
    public List<AsociadoDTO> listar() {
        return aS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AsociadoDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a los asociados para gestionarlos
    @PostMapping
    public void registrar(@RequestBody AsociadoDTO dto) {
        ModelMapper m=new ModelMapper();
        Asociado u=m.map(dto, Asociado.class);
        aS.insert(u);
    }
    //Como programador quiero listar por id a los asociados
    @GetMapping("/{id}")
    public AsociadoDTO listarporID(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        AsociadoDTO dto=m.map(aS.listID(id),AsociadoDTO.class);
        return dto;
    }
    //Como progrmador quiero modificar a los asociados para gestionarlos
    @PutMapping
    public void modificar(@RequestBody AsociadoDTO dto){
        ModelMapper m = new ModelMapper();
        Asociado ro=m.map(dto,Asociado.class);
        aS.update(ro);
    }
    //Como programador quiero eliminar a los asociados para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        aS.delete(id);
    }
    //Como programador quiero buscar a los asociados por fecha para gestionarlos
    @GetMapping("/busquedabyfecha")
    public List<AsociadoDTO> buscar(@RequestParam LocalDate f){
        return aS.buscarFecha(f).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AsociadoDTO.class);
        }).collect(Collectors.toList());
    }
    //
    @GetMapping("/busquedabynombre")
    public List<AsociadoDTO> buscar(@RequestParam String e){
        return aS.findByEmpresaContaining(e).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,AsociadoDTO.class);
        }).collect(Collectors.toList());
    }
}
