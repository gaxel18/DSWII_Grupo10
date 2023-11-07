package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioid;
    @Column(name = "usuarioname")
    private String usuarioname;
    @Column(name = "usuarioape")
    private String usuarioape;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "FechaRegistro")
    private Date FechaRegistro;
}
