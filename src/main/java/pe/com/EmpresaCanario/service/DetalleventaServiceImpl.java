package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Detalleventa;
import pe.com.EmpresaCanario.repository.DetalleventaRepository;

@Service
public class DetalleventaServiceImpl implements DetalleventaService{

    @Autowired
    private DetalleventaRepository repositorio;
    
    @Override
    public List<Detalleventa> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Detalleventa> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Detalleventa> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Detalleventa add(Detalleventa d) {
        return repositorio.save(d);
    }

    @Override
    public Detalleventa update(Detalleventa d) {
        Detalleventa objdetalle=repositorio.getById(d.getIddetalleventa());
        BeanUtils.copyProperties(d, objdetalle);
        return repositorio.save(objdetalle);
    }

    @Override
    public Detalleventa delete(Detalleventa d) {
        Detalleventa objdetalle=repositorio.getById(d.getIddetalleventa());
        objdetalle.setEstado(false);
        return repositorio.save(objdetalle);
    }
}
