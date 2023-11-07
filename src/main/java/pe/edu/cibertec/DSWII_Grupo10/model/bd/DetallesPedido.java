package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "detallespedido")
public class DetallesPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleid;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precioUnitario")
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "pedidoid")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "productiid")
    private Producto producto;
}