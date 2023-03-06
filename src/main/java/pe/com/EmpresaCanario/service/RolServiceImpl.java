package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Rol;
import pe.com.EmpresaCanario.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repositorio;
    
    @Override
    public List<Rol> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Rol> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Rol> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Rol add(Rol p) {
        return repositorio.save(p);
    }

    @Override
    public Rol update(Rol p) {
        Rol objproducto=repositorio.getById(p.getIdrol());
        BeanUtils.copyProperties(p, objproducto);
        return repositorio.save(objproducto);
    }

    @Override
    public Rol delete(Rol p) {
        Rol objproducto=repositorio.getById(p.getIdrol());
        objproducto.setEstado(false);
        return repositorio.save(objproducto);
    }
}
