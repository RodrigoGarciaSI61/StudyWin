package pe.edu.upc.studywinproyect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.studywinproyect.entities.UsuariosXCurso;
import pe.edu.upc.studywinproyect.serviceInterfaces.IUsuariosXCursoService;

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
}