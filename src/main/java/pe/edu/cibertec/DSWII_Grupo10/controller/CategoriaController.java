package pe.edu.cibertec.DSWII_Grupo10.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_Grupo10.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Categoria;
import pe.edu.cibertec.DSWII_Grupo10.service.CategoriaService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoriaController {

    private CategoriaService categoryService;


    @GetMapping("")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categoryList = new ArrayList<>();
        categoryService.listarCategorias()
                .forEach(categoryList::add);
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(
            @PathVariable("id") Integer id){
        Categoria category = categoryService
                .obtenerCategoriaPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @GetMapping("/categoryname/{filtro}")
    public ResponseEntity<List<Categoria>> filtrarCategoriasPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Categoria> categoryList = new ArrayList<>();
        categoryService.obtenerCategoriasPorFiltro(filtro)
                .forEach(categoryList::add);
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<Categoria> registrarCategoria(
            @RequestBody Categoria category
    ){
        return new ResponseEntity<>(
                categoryService.guardar(category), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(
            @PathVariable("id") Integer id,
            @RequestBody Categoria category
    ){
        Categoria oldCategory = categoryService
                .obtenerCategoriaPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con el Id Nro. "+
                        id + " no existe."));
        oldCategory.setCategorianame(category.getCategorianame());
        oldCategory.setDescripcion(category.getDescripcion());
        return new ResponseEntity<>(
                categoryService.guardar(oldCategory), HttpStatus.OK
        );
    }

}
