package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Venta;
import pe.com.EmpresaCanario.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository repositorio;
    
    @Override
    public List<Venta> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Venta> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Venta> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Venta add(Venta f) {
        return repositorio.save(f);
    }

    @Override
    public Venta update(Venta f) {
        Venta objfactura=repositorio.getById(f.getIdventa());
        BeanUtils.copyProperties(f, objfactura);
        return repositorio.save(objfactura);
    }

    @Override
    public Venta delete(Venta f) {
        Venta objfactura=repositorio.getById(f.getIdventa());
        objfactura.setEstado(false);
        return repositorio.save(objfactura);
    }
    
}
