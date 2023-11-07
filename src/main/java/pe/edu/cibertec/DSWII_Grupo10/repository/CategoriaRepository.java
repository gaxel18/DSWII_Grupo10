package pe.edu.cibertec.DSWII_Grupo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Categoria;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByCategoryname(String categoriaName);

    List<Categoria> findByCategorynameContainingIgnoreCase(String filtro);

    @Query("SELECT c FROM Categoria c WHERE c.categorianame LIKE %:filtro%")
    List<Categoria> filtrarCategoriasPorNombre(@Param("filtro") String filtro);

    @Query(value = "SELECT * FROM categorias WHERE categorianame LIKE %:filtro%",
            nativeQuery = true)
    List<Categoria> filtrarCategoriasPorNombreSQL(@Param("filtro") String filtro);




}
