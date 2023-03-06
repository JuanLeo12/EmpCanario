package pe.com.EmpresaCanario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.EmpresaCanario.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
    @Query("select c from Rol c where c.estado='1'")
        List<Rol> findAllCustom();
        
}
