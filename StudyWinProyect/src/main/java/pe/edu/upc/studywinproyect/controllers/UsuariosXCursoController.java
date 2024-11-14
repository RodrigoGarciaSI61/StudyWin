package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.*;
import pe.edu.upc.studywinproyect.entities.Canje;
import pe.edu.upc.studywinproyect.entities.Usuario;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuariosXCursoService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuariosxcurso")
public class UsuariosXCursoController {
    @Autowired
    private IUsuariosXCursoService uxcService;

    @GetMapping()
    public List<UsuariosXCursoDTO> list() {
        return uxcService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuariosXCursoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody UsuariosXCurso dto) {
        ModelMapper m=new ModelMapper();
        UsuariosXCurso u=m.map(dto, UsuariosXCurso.class);
        uxcService.insert(u);
    }

    @GetMapping("/{id}")
    public UsuariosXCursoDTO listID(@PathVariable("id") Long id) {
        ModelMapper m=new ModelMapper();
        UsuariosXCursoDTO dto=m.map(uxcService.listID(id), UsuariosXCursoDTO.class);
        return dto;


    }

    @PutMapping
    public void update(@RequestBody UsuariosXCursoDTO dto) {
        ModelMapper m = new ModelMapper();
        UsuariosXCurso ro=m.map(dto,UsuariosXCurso.class);
        uxcService.update(ro);
    }
    @PreAuthorize("hasAuthority('DEVELOPER')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        uxcService.delete(id);
    }
    //Como programador, quiero listar los usuarios que no están inscritos en ningún curso para identificar aquellos que necesitan ser asignados a uno.
    @GetMapping("/usuariosSinCurso")
    public List<UsuariosSinCursoDTO> usuariosSinCurso() {
        List<String[]> lista=uxcService.usuariossincurso();
        List<UsuariosSinCursoDTO> listDTO=new ArrayList<UsuariosSinCursoDTO>();
        for(String[] columna:lista){
            UsuariosSinCursoDTO dto=new UsuariosSinCursoDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setApellido(columna[2]);
            dto.setCorreo(columna[3]);
            listDTO.add(dto);
        }
        return listDTO;
    }
    //Como programador, quiero listar la cantidad de usuarios inscritos por curso para poder analizar la participación.
    @GetMapping("/cantuserscurso")
    public List<CantUsersinCursoDTO> usuariosCantCurso() {
        List<String[]> lista=uxcService.cursoscantusers();
        List<CantUsersinCursoDTO> listDTO=new ArrayList<CantUsersinCursoDTO>();
        for(String[] columna:lista){
            CantUsersinCursoDTO dto=new CantUsersinCursoDTO();
            dto.setIdcurso(Integer.parseInt(columna[0]));
            dto.setNombre_curso(columna[1]);
            if(columna[2]!=null){
                dto.setCant_users(Integer.parseInt(columna[2]));
            }else{
                dto.setCant_users(0);
            }
            listDTO.add(dto);
        }
        return listDTO;
    }
}