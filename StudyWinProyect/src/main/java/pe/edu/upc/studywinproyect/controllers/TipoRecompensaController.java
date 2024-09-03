package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.TipoRecompensaDTO;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;
import pe.edu.upc.studywinproyect.serviceInterfaces.ITipoRecompensaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_recompensas")
public class TipoRecompensaController {
    @Autowired
    private ITipoRecompensaService trS;

    // US042: Como programador quiero listar los tipos de recompensas registrados para gestionarlos
    @GetMapping
    public List<TipoRecompensaDTO> listar(){
        return trS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,TipoRecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    // US043: Como programador quiero registrar un tipo de recompensa para gestionarlo
    @PostMapping
    public void registrar(@RequestBody TipoRecompensaDTO dto){
        ModelMapper m=new ModelMapper();
        TipoRecompensa tr=m.map(dto,TipoRecompensa.class);
        trS.insert(tr);
    }

    // US044: Como programador  quiero modificar un tipo de recompensa para gestionarlo
    @PatchMapping
    public void modificar(@RequestBody TipoRecompensaDTO dto){
        ModelMapper m=new ModelMapper();
        TipoRecompensa tr=m.map(dto,TipoRecompensa.class);
        trS.update(tr);
    }

    // US045: Como programador  quiero eliminar un tipo de recompensa para gestionarlo
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        trS.delete(id);
    }
}
