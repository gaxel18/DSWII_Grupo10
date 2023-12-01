package pe.edu.cibertec.DSWII_Grupo10.model.request;

import lombok.Data;

@Data
public class ProductoRequest {
    private Integer productoid;
    private String productoname;
    private Double precioporunidad;
    private Boolean descontinuado;
    private Integer supplierid;
    private Integer categoria;
}