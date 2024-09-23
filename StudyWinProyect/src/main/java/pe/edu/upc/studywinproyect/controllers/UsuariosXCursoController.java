package pe.edu.upc.studywinproyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CantUsersinCursoDTO;
import pe.edu.upc.studywinproyect.dtos.UsuariosSinCursoDTO;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuariosXCursoService;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuariosxcurso")
public class UsuariosXCursoController {
    @Autowired
    private IUsuariosXCursoService uxcService;

    @GetMapping("/list")
    public List<UsuariosXCurso> list() {
        return uxcService.list();
    }

    @PostMapping("/insert")
    public void insert(@RequestBody UsuariosXCurso usuariosXCurso) {
        uxcService.insert(usuariosXCurso);
    }

    @GetMapping("/list/{id}")
    public UsuariosXCurso listID(@PathVariable Long id) {
        return uxcService.listID(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody UsuariosXCurso usuariosXCurso) {
        uxcService.update(usuariosXCurso);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
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