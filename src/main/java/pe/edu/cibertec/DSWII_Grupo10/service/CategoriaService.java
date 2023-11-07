package pe.edu.cibertec.DSWII_Grupo10.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Categoria;
import pe.edu.cibertec.DSWII_Grupo10.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoryRepository;

    public List<Categoria> listarCategorias(){
        return categoryRepository.findAll();
    }
    public Categoria guardar(Categoria category){
        return categoryRepository.save(category);
    }
    public Optional<Categoria> obtenerCategoriaPorId(Integer id){
        Optional<Categoria> category = categoryRepository.findById(id);
        if(category.isEmpty()){
            return Optional.empty();
        }else
            return category;
    }

    public Optional<Categoria> obtenerCatogoriaPorNombre(String categoryName){
        Optional<Categoria> category = categoryRepository.findByCategoryname(categoryName);
        if(category.isEmpty())
            return  Optional.empty();
        else
            return category;
    }

    public List<Categoria> obtenerCategoriasPorFiltro(String filtro){
        return categoryRepository.filtrarCategoriasPorNombreSQL(filtro);
    }


}
