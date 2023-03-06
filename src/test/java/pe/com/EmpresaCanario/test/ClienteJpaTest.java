package pe.com.EmpresaCanario.test;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import pe.com.EmpresaCanario.entity.Cliente;
import pe.com.EmpresaCanario.entity.Usuario;
import pe.com.EmpresaCanario.repository.ClienteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ClienteJpaTest {

    private static Cliente objcliente;
    private static Usuario objregistro;
    @Autowired
    private ClienteRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objcliente=new Cliente();
        objregistro=new Usuario();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objcliente=null;
        objregistro=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Cliente> cliente=repositorio.findAll();
        assertNotNull(cliente);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Cliente> cliente=repositorio.findAllCustom();
        assertNotNull(cliente);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Cliente> cliente=repositorio.findById(id);
        assertNotNull(cliente);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objregistro.setIdusuario(5);
        objcliente.setUsuario(objregistro);
        
        objcliente.setEstado(true);
        
        Cliente cliente= repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objcliente.setIdcliente(2);
        
        objregistro.setIdusuario(7);
        objcliente.setUsuario(objregistro);
        
        objcliente.setEstado(true);
        
        Cliente cliente= repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objcliente.setIdcliente(2);
        
        objregistro.setIdusuario(7);
        objcliente.setUsuario(objregistro);
        
        objcliente.setEstado(false);
        
        Cliente cliente= repositorio.save(objcliente);
        assertNotNull(cliente);
        System.out.println("@Test --> deleteTest()");
    }
    
}
