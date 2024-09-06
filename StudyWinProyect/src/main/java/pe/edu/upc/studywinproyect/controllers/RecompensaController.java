package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.RecompensaDTO;
import pe.edu.upc.studywinproyect.entities.Recompensa;
import pe.edu.upc.studywinproyect.serviceInterfaces.IRecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
public class RecompensaController {

    @Autowired
    private IRecompensaService rS;

    @GetMapping
    public List<RecompensaDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RecompensaDTO dto){
        ModelMapper m=new ModelMapper();
        Recompensa r=m.map(dto,Recompensa.class);
        rS.insert(r);
    }

    @PatchMapping
    public void modificar(@RequestBody RecompensaDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensa re = m.map(dto, Recompensa.class);
        rS.update(re);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        rS.delete(id);
    }

    @GetMapping("/busquedabynombre")
    public List<RecompensaDTO> buscarpornombre(@RequestParam String n){
        return rS.buscarNombre(n).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RecompensaDTO.class);
        }).collect(Collectors.toList());
    }
}
