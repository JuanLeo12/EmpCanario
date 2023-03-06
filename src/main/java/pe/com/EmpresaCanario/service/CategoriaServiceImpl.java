package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Categoria;
import pe.com.EmpresaCanario.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository repositorio;
    
    @Override
    public List<Categoria> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Categoria> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Categoria> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Categoria add(Categoria c) {
        return repositorio.save(c);
    }

    @Override
    public Categoria update(Categoria c) {
        Categoria objcliente=repositorio.getById(c.getIdcategoria());
        BeanUtils.copyProperties(c, objcliente);
        return repositorio.save(objcliente);
    }

    @Override
    public Categoria delete(Categoria c) {
        Categoria objcliente=repositorio.getById(c.getIdcategoria());
        objcliente.setEstado(false);
        return repositorio.save(objcliente);
    }
}
