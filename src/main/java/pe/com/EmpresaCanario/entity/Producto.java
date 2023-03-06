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
@Entity(name="Producto")
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproducto;
    @ManyToOne
    @JoinColumn(name="id_categoria", nullable=false)
    private Categoria categoria;
    @Column(name="nombre")
    private String nombre;
    @Column(name="largo")
    private float largo;
    @Column(name="alto")
    private float alto;
    @Column(name="stock")
    private int stock;
    @Column(name="precio")
    private float precio;
    @Column(name="estado")
    private boolean estado;
}
