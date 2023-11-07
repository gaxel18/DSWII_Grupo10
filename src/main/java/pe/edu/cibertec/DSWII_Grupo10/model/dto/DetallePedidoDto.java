package pe.edu.cibertec.DSWII_Grupo10.model.dto;

import lombok.Data;


@Data
public class DetallePedidoDto implements DtoEntity {
    private Integer detalleid;
    private Integer cantidad;
    private Double precioUnitario;
    private PedidoDto pedido;
    private ProductoDto producto;
}
