package pe.com.EmpresaCanario.entity;

import java.io.Serializable;
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
@Entity(name="Usuario")
@Table(name="usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idusuario;
    @ManyToOne
    @JoinColumn(name="id_rol", nullable=false)
    private Rol rol;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apepaterno")
    private String apepaterno;
    @Column(name="apematerno")
    private String apematerno;
    @Column(name="dni")
    private String dni;
    @Column(name="correo")
    private String correo;
    @Column(name="celular")
    private String celular;
    @Column(name="direccion")
    private String direccion;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="estado")
    private boolean estado;
    
}
