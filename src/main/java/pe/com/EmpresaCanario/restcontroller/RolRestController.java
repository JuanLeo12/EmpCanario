package pe.com.EmpresaCanario.restcontroller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.EmpresaCanario.entity.Rol;
import pe.com.EmpresaCanario.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {
    @Autowired
    private RolService servicio;

    @GetMapping
    public List<Rol> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Rol> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Rol> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Rol add(@RequestBody Rol p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id,@RequestBody Rol p) {
        p.setIdrol(id);
        return servicio.add(p);
    }
    
    @DeleteMapping("/{id}")
    public Rol delete(@PathVariable Long id) {
        Rol objproducto=new Rol();
        objproducto.setEstado(false);
        return servicio.delete(Rol.builder().idrol(id).build());
    }
}
