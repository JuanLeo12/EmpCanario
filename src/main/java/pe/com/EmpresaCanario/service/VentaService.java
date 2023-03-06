package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Venta;

public interface VentaService {
    public List<Venta> findAll();

    public List<Venta> findAllCustom();

    public Optional<Venta> findById(long id);

    public Venta add(Venta f);

    public Venta update(Venta f);

    public Venta delete(Venta f);
}
