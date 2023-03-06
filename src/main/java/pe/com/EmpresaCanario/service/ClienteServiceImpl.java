package pe.com.EmpresaCanario.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.EmpresaCanario.entity.Cliente;
import pe.com.EmpresaCanario.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repositorio;
    
    @Override
    public List<Cliente> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<Cliente> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<Cliente> findById(long id) {
        return repositorio.findById(id);
    }

    @Override
    public Cliente add(Cliente c) {
        return repositorio.save(c);
    }

    @Override
    public Cliente update(Cliente c) {
        Cliente objcliente=repositorio.getById(c.getIdcliente());
        BeanUtils.copyProperties(c, objcliente);
        return repositorio.save(objcliente);
    }

    @Override
    public Cliente delete(Cliente c) {
        Cliente objcliente=repositorio.getById(c.getIdcliente());
        objcliente.setEstado(false);
        return repositorio.save(objcliente);
    }
    
}
