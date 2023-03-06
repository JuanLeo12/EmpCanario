package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Detalleventa;

public interface DetalleventaRepository extends JpaRepository<Detalleventa, Long> {
    @Query("select d from Detalleventa d where d.estado='1'")
        List<Detalleventa> findAllCustom();
}