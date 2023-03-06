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
import pe.com.EmpresaCanario.entity.Detalleventa;
import pe.com.EmpresaCanario.service.DetalleventaService;

@RestController
@RequestMapping("/detalleventa")
public class DetalleventaRestController {
    @Autowired
    private DetalleventaService servicio;

    @GetMapping
    public List<Detalleventa> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Detalleventa> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Detalleventa> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Detalleventa add(@RequestBody Detalleventa d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public Detalleventa update(@PathVariable Long id,@RequestBody Detalleventa d) {
        d.setIddetalleventa(id);
        return servicio.add(d);
    }
    
    @DeleteMapping("/{id}")
    public Detalleventa delete(@PathVariable Long id) {
        Detalleventa objdetalle=new Detalleventa();
        objdetalle.setEstado(false);
        return servicio.delete(Detalleventa.builder().iddetalleventa(id).build());
    }
}
