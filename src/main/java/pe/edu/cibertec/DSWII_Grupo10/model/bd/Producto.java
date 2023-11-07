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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoid;
    @Column(name = "productoname")
    private String productoname;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "stock")
    private Integer stock;

    @Column(name = "fechaCreacio")
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "categoriaid")
    private Categoria categoria;
}
