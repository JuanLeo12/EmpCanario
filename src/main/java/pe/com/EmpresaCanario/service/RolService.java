package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Rol;

public interface RolService {
    public List<Rol> findAll();

    public List<Rol> findAllCustom();

    public Optional<Rol> findById(long id);

    public Rol add(Rol c);

    public Rol update(Rol c);

    public Rol delete(Rol c);
}
