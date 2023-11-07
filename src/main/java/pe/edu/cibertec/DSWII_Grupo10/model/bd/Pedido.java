package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedidoid;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaPedido")
    private Date fechaPedido;

    @ManyToOne
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;
}

