package pe.edu.cibertec.DSWII_Grupo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Producto;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    Optional<Producto> findByProductname(String productoName);

    List<Producto> findByProductnameContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM productos c WHERE c.productoname LIKE %:filtro%")
    List<Producto> filtrarProductosPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM productos WHERE productoname LIKE %:filtro%",
            nativeQuery = true)
    List<Producto> filtrarProductosPorNombreSQL(@Param("filtro") String filtro);

    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosEnRangoDeCantidad();

    @Query(value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_creacion) = 2022", nativeQuery = true)
    List<Producto> findProductosConFechaDeVencimiento2022();

}
