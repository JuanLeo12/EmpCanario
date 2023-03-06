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
import pe.com.EmpresaCanario.entity.Venta;
import pe.com.EmpresaCanario.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaRestController {
    @Autowired
    private VentaService servicio;

    @GetMapping
    public List<Venta> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<Venta> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<Venta> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public Venta add(@RequestBody Venta f) {
        return servicio.add(f);
    }

    @PutMapping("/{id}")
    public Venta update(@PathVariable Long id,@RequestBody Venta f) {
        f.setIdventa(id);
        return servicio.add(f);
    }
    
    @DeleteMapping("/{id}")
    public Venta delete(@PathVariable Long id) {
        Venta objfactura=new Venta();
        objfactura.setEstado(false);
        return servicio.delete(Venta.builder().idventa(id).build());
    }
}
