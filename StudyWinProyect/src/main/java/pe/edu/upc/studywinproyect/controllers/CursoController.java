package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CursoDTO;
import pe.edu.upc.studywinproyect.dtos.CursoDTO;
import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICursoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private ICursoService cS;
    //Como programador quiero listar los cursos para gestionarlos
    @GetMapping
    public List<CursoDTO> listar() {
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CursoDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a los cursos para gestionarlos
    @PostMapping
    public void registrar(@RequestBody CursoDTO dto) {
        ModelMapper m=new ModelMapper();
        Curso u=m.map(dto, Curso.class);
        cS.insert(u);
    }
    //Como programador quiero listar por id a los cursos
    @GetMapping("/{id}")
    public CursoDTO listarporID(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CursoDTO dto=m.map(cS.listID(id),CursoDTO.class);
        return dto;
    }
    //Como progrmador quiero modificar a los cursos para gestionarlos
    @PutMapping
    public void modificar(@RequestBody CursoDTO dto){
        ModelMapper m = new ModelMapper();
        Curso ro=m.map(dto,Curso.class);
        cS.update(ro);
    }
    //Como programador quiero eliminar a los cursos para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
}
