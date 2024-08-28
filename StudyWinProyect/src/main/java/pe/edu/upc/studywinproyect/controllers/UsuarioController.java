package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.UsuarioDTO;
import pe.edu.upc.studywinproyect.entities.Usuario;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        uS.insert(u);
    }
}
