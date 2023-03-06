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
import pe.com.EmpresaCanario.repository.ProductoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ProductoJpaTest {

    private static Producto objproducto;
    @Autowired
    private ProductoRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objproducto=new Producto();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objproducto=null;
        System.out.println("@AfterAll -->Final()");
    }
    
    @Test
    public void Mensaje(){
        System.out.println("Prueba Inicial");
        System.out.println("@Test -->PruabaInicial");
    }
    
    @Test
    public void findAllTest(){
        List<Producto> producto=repositorio.findAll();
        assertNotNull(producto);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Producto> producto=repositorio.findAllCustom();
        assertNotNull(producto);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Producto> producto=repositorio.findById(id);
        assertNotNull(producto);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objproducto.setLargo(80);
        objproducto.setAlto(80);
        objproducto.setStock(12);
        objproducto.setPrecio(40);
        objproducto.setEstado(true);
        
        Producto producto= repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objproducto.setIdproducto(2);
        
        objproducto.setLargo(80);
        objproducto.setAlto(80);
        objproducto.setStock(12);
        objproducto.setPrecio(60);
        objproducto.setEstado(true);
        
        Producto producto= repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objproducto.setIdproducto(3);
        
        objproducto.setLargo(80);
        objproducto.setAlto(80);
        objproducto.setStock(125);
        objproducto.setPrecio(60);
        objproducto.setEstado(false);
        
        Producto producto= repositorio.save(objproducto);
        assertNotNull(producto);
        System.out.println("@Test --> deleteTest()");
    }
}
