package pe.edu.cibertec.DSWII_Grupo10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Pedido;

@Repository
public interface PedidoRepository
        extends JpaRepository<Pedido, Integer>
{
}
