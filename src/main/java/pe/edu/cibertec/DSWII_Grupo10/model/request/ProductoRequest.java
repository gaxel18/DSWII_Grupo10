package pe.edu.cibertec.DSWII_Grupo10.model.request;

import lombok.Data;

@Data
public class ProductoRequest {
    private Integer productoid;
    private String productoname;
    private String precio;
    private Double stock;
    private Integer categoria;
    private Integer usuario;
}