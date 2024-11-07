package pe.edu.upc.studywinproyect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.dtos.CanjeDTO;
import pe.edu.upc.studywinproyect.dtos.RoleDTO;
import pe.edu.upc.studywinproyect.entities.Role;
import pe.edu.upc.studywinproyect.serviceInterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/rol")
public class RoleController {
    @Autowired
    private IRoleService rS;
    @PostMapping
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m=new ModelMapper();
        Role u=m.map(dto, Role.class);
        rS.insert(u);
    }
    @GetMapping
    public List<RoleDTO> listar() {
        return rS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RoleDTO.class);
        }).collect(Collectors.toList());
    }
}
