package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Usuario;
import pe.com.EmpresaCanario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repositorio;
    
    @Override
    public List<Usuario> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Usuario> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Usuario add(Usuario r) {
        return repositorio.save(r);
    }

    @Override
    public Usuario update(Usuario r) {
        Usuario objregistro=repositorio.getById(r.getIdusuario());
        BeanUtils.copyProperties(r, objregistro);
        return repositorio.save(objregistro);
    }

    @Override
    public Usuario delete(Usuario r) {
        Usuario objregistro=repositorio.getById(r.getIdusuario());
        objregistro.setEstado(false);
        return repositorio.save(objregistro);
    }
    
}
