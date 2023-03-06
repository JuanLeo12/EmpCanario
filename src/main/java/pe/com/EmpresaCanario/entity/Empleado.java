package pe.com.EmpresaCanario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="Empleado")
@Table(name="empleado")
public class Empleado {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idempleado;
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
    @Column(name="estado")
    private boolean estado;
}
