package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import pe.com.EmpresaCanario.entity.Usuario;

public interface UsuarioService {
    public List<Usuario> findAll();

    public List<Usuario> findAllCustom();

    public Optional<Usuario> findById(long id);

    public Usuario add(Usuario p);

    public Usuario update(Usuario p);

    public Usuario delete(Usuario p);
}
