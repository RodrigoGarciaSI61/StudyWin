package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.PreguntasmayorpuntajeDTO;
import pe.edu.upc.studywinproyect.dtos.PreguntasxCuestionarioDTO;
import pe.edu.upc.studywinproyect.dtos.PreguntaDTO;
import pe.edu.upc.studywinproyect.entities.Pregunta;
import pe.edu.upc.studywinproyect.serviceInterfaces.IPreguntaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
    @Autowired
    private IPreguntaService pS;
    //Como programador quiero listar las preguntas para gestionarlos
    @GetMapping
    public List<PreguntaDTO> listar() {
        return pS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PreguntaDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a las preguntas para gestionarlos
    @PostMapping
    public void registrar(@RequestBody PreguntaDTO dto) {
        ModelMapper m=new ModelMapper();
        Pregunta u=m.map(dto, Pregunta.class);
        pS.insert(u);
    }
    //Como progrmador quiero modificar a las preguntas para gestionarlos
    @PutMapping
    public void modificar(@RequestBody PreguntaDTO dto){
        ModelMapper m = new ModelMapper();
        Pregunta ro=m.map(dto,Pregunta.class);
        pS.update(ro);
    }
    //Como programador quiero eliminar a las preguntas para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }
    //Como programador quiero listar las preguntas por cuestionario para gestionarlos
    @GetMapping("/preguntaxcuestionario")
    public List<PreguntasxCuestionarioDTO> preguntaxcuestionario(){
        List<String[]> lista=pS.preguntaxcuestionario();
        List<PreguntasxCuestionarioDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            PreguntasxCuestionarioDTO dto=new PreguntasxCuestionarioDTO();
            dto.setId_cuestionario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setTiempo_limite(Integer.parseInt(columna[2]));
            if (columna[3] != null) {
                dto.setCantidad_preguntas(Integer.parseInt(columna[3]));
            }else {
                dto.setCantidad_preguntas(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/preguntamayorpuntxcuestionario")
    public List<PreguntasmayorpuntajeDTO> preguntasmayorpuntaje(){
        List<String[]> lista=pS.preguntasmayorcantpuntos();
        List<PreguntasmayorpuntajeDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            PreguntasmayorpuntajeDTO dto=new PreguntasmayorpuntajeDTO();
            dto.setIdPregunta(Integer.parseInt(columna[0]));
            dto.setPregunta(columna[1]);
            dto.setPuntos(Integer.parseInt(columna[2]));
            dto.setRespuesta(columna[3]);
            dto.setId_cuestionario(Integer.parseInt(columna[4]));
            dto.setNombrecuestionario(columna[5]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
