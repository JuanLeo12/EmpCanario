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
import pe.com.EmpresaCanario.entity.Detalleventa;
import pe.com.EmpresaCanario.entity.Venta;
import pe.com.EmpresaCanario.entity.Producto;
import pe.com.EmpresaCanario.repository.DetalleventaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class DetalleJpaTest {

    private static Detalleventa objdetalle;
    private static Venta objfactura;
    private static Producto objproducto;
    
    @Autowired
    private DetalleventaRepository repositorio;
    
    @BeforeAll
    public static void Inicio(){
        objdetalle=new Detalleventa();
        objfactura=new Venta();
        objproducto=new Producto();
        System.out.println("@BeforeAll -->Inicio");
        
    }
    
    @AfterAll
    public static void Final(){
        objdetalle=null;
        objfactura=null;
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
        List<Detalleventa> detalle=repositorio.findAll();
        assertNotNull(detalle);
        System.out.println("@Test -->findAllTest()");
    }
    
    @Test
    public void findAllCustomTest(){
        List<Detalleventa> detalle=repositorio.findAllCustom();
        assertNotNull(detalle);
        System.out.println("@Test -->findAllCustomTest()");
    }
    
    @Test
    public void findByIdTest(){
        long id=1;
        Optional<Detalleventa> detalle=repositorio.findById(id);
        assertNotNull(detalle);
        System.out.println("@Test -->findByIdTest()");
    }
    
    @Test
    @Rollback(false)
    public void addTest(){
        
        objfactura.setIdventa(2);
        objdetalle.setVenta(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(true);
        
        Detalleventa detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> addTest()");
    }
    
    @Test
    @Rollback(false)
    public void updateTest(){
        
        objdetalle.setIddetalleventa(2);
        
        objfactura.setIdventa(2);
        objdetalle.setVenta(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(true);
        
        Detalleventa detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> updateTest()");
    }
    
    @Test
    @Rollback(false)
    public void deleteTest(){
        
        objdetalle.setIddetalleventa(1);
        
        objfactura.setIdventa(2);
        objdetalle.setVenta(objfactura);
        
        objproducto.setIdproducto(1);
        objdetalle.setProducto(objproducto);
        
        
        objdetalle.setCantidad(500);
        objdetalle.setPrecio(99);
        objdetalle.setEstado(false);
        
        Detalleventa detalle= repositorio.save(objdetalle);
        assertNotNull(detalle);
        System.out.println("@Test --> deleteTest()");
    }
}
