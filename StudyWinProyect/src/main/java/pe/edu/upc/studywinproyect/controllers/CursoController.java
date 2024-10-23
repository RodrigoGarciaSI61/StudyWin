package pe.edu.upc.studywinproyect.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.studywinproyect.dtos.CursoDTO;
import pe.edu.upc.studywinproyect.dtos.CursosXCategoriaDTO;
import pe.edu.upc.studywinproyect.entities.Curso;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICursoService;

import java.util.ArrayList;
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
    //Como programador quiero buscar a los cursos por nombre para gestionarlos
    @GetMapping("/busquedabynombre")
    public List<CursoDTO> buscarpornombre(@RequestParam String n){
        return cS.buscarporNombre(n).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,CursoDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero buscar a los cursos por nombre para gestionarlos
    @GetMapping("/busquedabycategoria")
    public List<CursoDTO> buscarporCategoria(@RequestParam String c){
        return cS.buscarporCategoria(c).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,CursoDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero listar la cantidad de cursos por categoria para gestionarlos
    @GetMapping("/cursoxcategoria")
    public List<CursosXCategoriaDTO> cursosxcategoria(){
        List<String[]> lista=cS.cursosxcategoria();
        List<CursosXCategoriaDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CursosXCategoriaDTO dto=new CursosXCategoriaDTO();
            dto.setCategoria(columna[0]);
            if (columna[1] != null) {
                dto.setCantidad_cursos(Integer.parseInt(columna[1]));
            }else {
                dto.setCantidad_cursos(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
