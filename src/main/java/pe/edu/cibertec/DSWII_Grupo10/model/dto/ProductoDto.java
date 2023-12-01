package pe.edu.cibertec.DSWII_Grupo10.model.dto;

import lombok.Data;

@Data
public class ProductoDto implements DtoEntity {
    private Integer productoid;
    private String productoname;
    private String cantidad;
    private Double preciounitario;
    private CategoriaDto categoria;
    private ArtesanoDto artesano;
}
