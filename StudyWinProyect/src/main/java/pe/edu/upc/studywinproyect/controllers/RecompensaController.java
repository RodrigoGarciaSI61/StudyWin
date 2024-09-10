package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.studywinproyect.dtos.RecompensaDTO;
import pe.edu.upc.studywinproyect.dtos.RecompensaxasociadoDTO;

import pe.edu.upc.studywinproyect.dtos.RecompensaxtipoDTO;
import pe.edu.upc.studywinproyect.entities.Recompensa;
import pe.edu.upc.studywinproyect.entities.TipoRecompensa;
import pe.edu.upc.studywinproyect.serviceInterfaces.IRecompensaService;

import java.util.ArrayList;
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
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<RecompensaDTO> buscarpornombre(@RequestParam String n){
        return rS.buscarNombre(n).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RecompensaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/recompensaxasociado")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<RecompensaxasociadoDTO> recompesaxasociado(){
        List<String[]> lista=rS.recompesaxasociado();
        List<RecompensaxasociadoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            RecompensaxasociadoDTO dto=new RecompensaxasociadoDTO();
            dto.setId_asociado(Integer.parseInt(columna[0]));
            dto.setEmpresa(columna[1]);
            dto.setRUC(columna[2]);
            if (columna[3] != null) {
                dto.setCantidad_recompensas(Integer.parseInt(columna[3]));
            }else {
                dto.setCantidad_recompensas(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/recompensaxtipo")
    @PreAuthorize("hasAuthority('CLIENTE')")
    public List<RecompensaxtipoDTO> obtenertipo(){
        List<String[]> lista=rS.recompensaxtipo();
        List<RecompensaxtipoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            RecompensaxtipoDTO dto=new RecompensaxtipoDTO();
            dto.setNombre(columna[0]);
            dto.setTipo(columna[1]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
