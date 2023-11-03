package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "artesanias")
public class Artesania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoid;
    @Column(name = "productoname")
    private String productoname;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fechaVencimiento")
    private Date fechaVencimiento;
}
