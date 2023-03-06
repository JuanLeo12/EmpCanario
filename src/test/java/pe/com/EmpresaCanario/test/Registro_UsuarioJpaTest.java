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
import pe.com.EmpresaCanario.entity.Producto;
import pe.com.EmpresaCanario.entity.Usuario;
import pe.com.EmpresaCanario.repository.ProductoRepository;
import pe.com.EmpresaCanario.repository.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class Registro_UsuarioJpaTest {

    private static Usuario objregistrousuario;
    @Autowired
    private UsuarioRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objregistrousuario=new Usuario();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objregistrousuario=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Usuario> registro_usuario=repositorio.findAll();
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Usuario> registro_usuario=repositorio.findAllCustom();
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Usuario> registro_usuario=repositorio.findById(id);
        assertNotNull(registro_usuario);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objregistrousuario.setNombre("Diego");
        objregistrousuario.setApepaterno("Davila");
        objregistrousuario.setApematerno("Davila");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setCelular("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(true);
        
        Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objregistrousuario.setIdusuario(3);
        
        objregistrousuario.setNombre("Juan Leonardo");
        objregistrousuario.setApepaterno("Albornoz Alejo");
        objregistrousuario.setApematerno("Albornoz Alejo");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setCelular("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(true);
        
        Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objregistrousuario.setIdusuario(2);
        
        objregistrousuario.setNombre("Juan Leonardo");
        objregistrousuario.setApepaterno("Albornoz Alejo");
        objregistrousuario.setApematerno("Alejo");
        objregistrousuario.setDni("87654321");
        objregistrousuario.setCorreo("jalb@gmail.com");
        objregistrousuario.setCelular("987654321");
        objregistrousuario.setDireccion("Av.Leon Prado");
        objregistrousuario.setContrasena("123juan");
        objregistrousuario.setEstado(false);
        
        Usuario registro_usuario= repositorio.save(objregistrousuario);
        assertNotNull(registro_usuario);
        System.out.println("@Test --> deleteTest()");
    }
}
