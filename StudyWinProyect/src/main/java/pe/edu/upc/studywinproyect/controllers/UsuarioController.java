package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Como programador quiero listar los usuarios para gestionarlos
    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    //Como programador quiero guardar a los usuarios para gestionarlos
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getContrasena());
        u.setContrasena(encodedPassword);
        uS.insert(u);
    }
    //Como programador quiero listar por id a los usuarios
    @GetMapping("/{id}")
    public UsuarioDTO listarporID(@PathVariable("id") Long id){
        ModelMapper m=new ModelMapper();
        UsuarioDTO dto=m.map(uS.listID(id),UsuarioDTO.class);
        return dto;
    }
    //Como progrmador quiero modificar a los usuarios para gestionarlos
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario ro=m.map(dto,Usuario.class);
        uS.update(ro);
    }
    //Como programador quiero eliminar a los usuarios para gestionarlos
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }
    //Como usuario quiero buscar por nombre a los usuarios para gestionarlo
    @GetMapping("/busquedabynombre")
    public List<UsuarioDTO> buscar(@RequestParam String n, @RequestParam String a){
        return uS.buscarporNombre(n,a).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    //Como usuario quiero buscar por DNI a los usuarios para gestionarlo
    @GetMapping("/busquedabydni")
    public List<UsuarioDTO> buscarporDni(@RequestParam String dni){
        return uS.buscarporDni(dni).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    //Como usuario quiero buscar por institucion educativa a los usuarios para gestionarlo
    @GetMapping("/busquedabyIE")
    public List<UsuarioDTO> buscarporIE(@RequestParam String IE){
        return uS.buscarporIE(IE).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
