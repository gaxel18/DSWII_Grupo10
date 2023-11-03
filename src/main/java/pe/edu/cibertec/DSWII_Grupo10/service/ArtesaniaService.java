package pe.edu.cibertec.DSWII_Grupo10.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Artesania;
import pe.edu.cibertec.DSWII_Grupo10.repository.ArtesaniaRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtesaniaService {

    private ArtesaniaRepository artesaniaRepository;

    public List<Artesania> listarProductos(){
        return artesaniaRepository.findAll();
    }
    public Artesania guardar(Artesania artesania){
        return artesaniaRepository.save(artesania);
    }
    public Optional<Artesania> obtenerProductoPorId(Integer id){
        Optional<Artesania> artesania = artesaniaRepository.findById(id);
        if(artesania.isEmpty()){
            return Optional.empty();
        }else
            return artesania;
    }

    public Optional<Artesania> obtenerProductoPorNombre(String nombre){
        Optional<Artesania> artesania = artesaniaRepository.findByProductname(nombre);
        if(artesania.isEmpty())
            return  Optional.empty();
        else
            return artesania;
    }

    public List<Artesania> obtenerProductosPorFiltro(String filtro){
        return artesaniaRepository.filtrarProductosPorNombreSQL(filtro);
    }

    public void eliminarProductoPorId(Integer id) {
        Optional<Artesania> productoOptional = artesaniaRepository.findById(id);
        if (productoOptional.isPresent()) {
            artesaniaRepository.deleteById(id);
        } else {
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }
    }

    public List<Artesania> buscarPorNombre(String nombre) {
        return null;
    }

    public List<Artesania> findProductosEnRangoDeCantidad() {
        return null;
    }

    public List<Artesania> findProductosConFechaDeVencimiento2024() {
        return null;
    }
}
