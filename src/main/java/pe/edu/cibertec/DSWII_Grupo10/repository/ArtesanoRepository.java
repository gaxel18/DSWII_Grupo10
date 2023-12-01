package pe.edu.cibertec.DSWII_Grupo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Artesano;

@Repository
public interface ArtesanoRepository
        extends JpaRepository<Artesano, Integer>
{
}