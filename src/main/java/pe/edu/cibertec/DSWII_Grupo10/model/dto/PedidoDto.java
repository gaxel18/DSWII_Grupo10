package pe.edu.cibertec.DSWII_Grupo10.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PedidoDto implements DtoEntity {
    private Integer pedidoid;
    private Date fechaPedido;
}

