package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CuestionarioXCursoDTO;
import pe.edu.upc.studywinproyect.dtos.Cuestionario_academicoDTO;
import pe.edu.upc.studywinproyect.dtos.CuestionariosresueltosDTO;
import pe.edu.upc.studywinproyect.entities.Cuestionario_academico;
import pe.edu.upc.studywinproyect.serviceInterfaces.ICuestionario_academicoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuestionarios")
public class Cuestionario_academicoController {
    @Autowired
    private ICuestionario_academicoService cS;
    //Como programador quiero listar los cuestionarios academicos para gestionarlos
    @GetMapping
    public List<Cuestionario_academicoDTO> listar() {
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,Cuestionario_academicoDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a los cuestionarios academicos para gestionarlos
    @PostMapping
    public void registrar(@RequestBody Cuestionario_academicoDTO dto) {
        ModelMapper m=new ModelMapper();
        Cuestionario_academico u=m.map(dto, Cuestionario_academico.class);
        cS.insert(u);
    }
    //Como progrmador quiero modificar a los cuestionarios academicos para gestionarlos
    @PutMapping
    public void modificar(@RequestBody Cuestionario_academicoDTO dto){
        ModelMapper m = new ModelMapper();
        Cuestionario_academico ro=m.map(dto,Cuestionario_academico.class);
        cS.update(ro);
    }
    //Como programador quiero eliminar a los cuestionarios academicos para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }
    //Como programador quiero listar los canjes por usuario para gestionarlos
    @GetMapping("/cuestionarioxcurso")
    public List<CuestionarioXCursoDTO> cuestionarioxcurso(){
        List<String[]> lista=cS.cuestionario_academicoxcurso();
        List<CuestionarioXCursoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CuestionarioXCursoDTO dto=new CuestionarioXCursoDTO();
            dto.setId_curso(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setCategoria(columna[2]);
            if (columna[3] != null) {
                dto.setCantidad_cuestionarios(Integer.parseInt(columna[3]));
            }else {
                dto.setCantidad_cuestionarios(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    //Como programador quiero listar la Cantidad de cuestionarios resueltos por usuario
    @GetMapping("/resueltos")
    public List<CuestionariosresueltosDTO> cuestionarioresuelto(){
        List<String[]> lista=cS.cuestionariosresueltos();
        List<CuestionariosresueltosDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CuestionariosresueltosDTO dto=new CuestionariosresueltosDTO();
            dto.setId_usuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            if (columna[3] != null) {
                dto.setCuestionarios_resueltos(Integer.parseInt(columna[3]));
            }else {
                dto.setCuestionarios_resueltos(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
