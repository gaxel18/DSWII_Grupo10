package pe.edu.cibertec.DSWII_Grupo10.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductoDto implements DtoEntity {
    private Integer productoid;
    private String productoname;
    private String precio;
    private Double stock;
    private CategoriaDto categoria;
    private UsuarioDto usuario;
}
