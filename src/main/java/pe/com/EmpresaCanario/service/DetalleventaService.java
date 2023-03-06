package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Detalleventa;


public interface DetalleventaService {
    public List<Detalleventa> findAll();

    public List<Detalleventa> findAllCustom();

    public Optional<Detalleventa> findById(long id);

    public Detalleventa add(Detalleventa d);

    public Detalleventa update(Detalleventa d);

    public Detalleventa delete(Detalleventa d);
}
