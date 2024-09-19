package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.EnabledUsersDTO;
import pe.edu.upc.studywinproyect.dtos.UsuarioDTO;
import pe.edu.upc.studywinproyect.dtos.UsuarioporIEDTO;
import pe.edu.upc.studywinproyect.entities.Usuario;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuarioService;

import java.util.ArrayList;
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
    //como programador quiero listar la cantidad de usuarios inhabilitados y la cantidad de usuarios habilitados para poder gestionarlos,
    @GetMapping("/enabledUsers")
    public List<EnabledUsersDTO> enabledUsers(){
        List<String[]> lista=uS.enabledUsers();
        List<EnabledUsersDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            EnabledUsersDTO dto=new EnabledUsersDTO();
            dto.setEstado_usuario(columna[0]);
            if(columna[1]!=null){
                dto.setCantUsuarios(Integer.parseInt(columna[1]));
            }else{
                dto.setCantUsuarios(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
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
    //Como programador quiero listar la cantidad de usuarios por institución educativa para gestionarlo    @GetMapping("/usuariosxIE")
    @GetMapping("/usuariosxIE")
    public List<UsuarioporIEDTO> usuariosxIE(){
        List<String[]> lista=uS.UsuariosporIE();
        List<UsuarioporIEDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            UsuarioporIEDTO dto=new UsuarioporIEDTO();
            dto.setNombreIE(columna[0]);
            if (columna[1] != null) {
                dto.setCantidad_usuarios(Integer.parseInt(columna[1]));
            }else{
                dto.setCantidad_usuarios(0);
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
