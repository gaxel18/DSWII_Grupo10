package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "artesanos")
public class Artesano {
    @Id
    private Integer artesanoid;
    @Column(name = "nombrecia")
    private String nombrecia;
    @Column(name = "nombrecontacto")
    private String nombrecontacto;
    @Column(name = "contacto")
    private String contacto;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "region")
    private String region;
    @Column(name = "codigopostal")
    private String codigopostal;
    @Column(name = "pais")
    private String pais;
    @Column(name = "numero")
    private String numero;
    @Column(name = "fax")
    private String fax;
    @Column(name = "paginaweb")
    private String paginaweb;
}
