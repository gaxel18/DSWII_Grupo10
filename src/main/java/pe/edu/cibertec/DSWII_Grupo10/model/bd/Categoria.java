package pe.edu.cibertec.DSWII_Grupo10.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaid;
    @Column(name = "categorianame")
    private String categorianame;
    @Column(name = "descripcion")
    private String descripcion;
}