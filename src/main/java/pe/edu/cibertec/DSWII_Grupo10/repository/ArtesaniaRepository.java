package pe.edu.cibertec.DSWII_Grupo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Artesania;

import java.util.List;
import java.util.Optional;


@Repository
public interface ArtesaniaRepository extends JpaRepository<Artesania, Integer> {

    Optional<Artesania> findByProductname(String productoName);

    List<Artesania> findByProductnameContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM artesanias c WHERE c.productoname LIKE %:filtro%")
    List<Artesania> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM artesanias WHERE productoname LIKE %:filtro%",
            nativeQuery = true)
    List<Artesania> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);

    List<Artesania> findByNombre(String nombre);

    @Query("SELECT p FROM Artesania p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Artesania> findProductosEnRangoDeCantidad();

    @Query(value = "SELECT * FROM Artesania p WHERE YEAR(p.fecha_vencimiento) = 2024", nativeQuery = true)
    List<Artesania> findProductosConFechaDeVencimiento2024();

}
