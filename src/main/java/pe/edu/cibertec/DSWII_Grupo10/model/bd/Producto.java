package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer productoid;
    @Column(name = "productoname")
    private String productoname;
    @Column(name = "cantidadporunidad")
    private String cantidad;
    @Column(name = "preciounitario")
    private Double preciounitario;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "ordernadas")
    private Integer ordenadas;
    @Column(name = "reorderlevel")
    private Integer reorderlevel;
    @Column(name = "descontinuado")
    private Boolean descontinuado;
    @ManyToOne
    @JoinColumn(name = "artesanoid")
    private Artesano artesano;
    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
}
