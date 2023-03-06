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
import pe.com.EmpresaCanario.entity.Usuario;
import pe.com.EmpresaCanario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    
    @Autowired
    private UsuarioService servicio;

    @GetMapping
    public List<Usuario> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Usuario> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Usuario add(@RequestBody Usuario r) {
        return servicio.add(r);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id,@RequestBody Usuario r) {
        r.setIdusuario(id);
        return servicio.add(r);
    }
    
    @DeleteMapping("/{id}")
    public Usuario delete(@PathVariable Long id) {
        Usuario objregistro=new Usuario();
        objregistro.setEstado(false);
        return servicio.delete(Usuario.builder().idusuario(id).build());
    }
}
