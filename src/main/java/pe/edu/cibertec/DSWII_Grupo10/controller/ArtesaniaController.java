package pe.edu.cibertec.DSWII_Grupo10.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_Grupo10.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Artesania;
import pe.edu.cibertec.DSWII_Grupo10.service.ArtesaniaService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ArtesaniaController {

    private ArtesaniaService artesaniaService;


    @GetMapping("")
    public ResponseEntity<List<Artesania>> listarProductos(){
        List<Artesania> productoList = new ArrayList<>();
        artesaniaService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artesania> obtenerProducto(
            @PathVariable("id") Integer id){
        Artesania category = artesaniaService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @GetMapping("/categoryname/{filtro}")
    public ResponseEntity<List<Artesania>> filtrarCategoriasPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Artesania> productoList = new ArrayList<>();
        artesaniaService.obtenerProductosPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<List<Artesania>> buscarPorNombre(@RequestParam String nombre) {
        List<Artesania> artesanias = artesaniaService.buscarPorNombre(nombre);
        return ResponseEntity.ok(artesanias);
    }

    @GetMapping("/productos-en-rango-de-cantidad")
    public ResponseEntity<List<Artesania>> productosEnRangoDeCantidad() {
        List<Artesania> artesanias = artesaniaService.findProductosEnRangoDeCantidad();
        return ResponseEntity.ok(artesanias);
    }

    @GetMapping("/productos-con-fecha-2024")
    public ResponseEntity<List<Artesania>> productosConFecha2024() {
        List<Artesania> artesanias = artesaniaService.findProductosConFechaDeVencimiento2024();
        return ResponseEntity.ok(artesanias);
    }

    @PostMapping("")
    public ResponseEntity<Artesania> registrarProducto(
            @RequestBody Artesania artesania
    ){
        return new ResponseEntity<>(
                artesaniaService.guardar(artesania), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artesania> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Artesania artesania
    ){
        Artesania oldArtesania = artesaniaService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldArtesania.setProductoname(artesania.getProductoname());
        oldArtesania.setDescripcion(artesania.getDescripcion());
        return new ResponseEntity<>(
                artesaniaService.guardar(oldArtesania), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable("id") Integer id) {
        try {
            artesaniaService.eliminarProductoPorId(id);
            return new ResponseEntity<>("Producto eliminado con ID: " + id, HttpStatus.OK);
        } catch (ResourceNotFoundException exception) {
            return new ResponseEntity<>("Producto no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>("Error al eliminar el producto con ID: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
