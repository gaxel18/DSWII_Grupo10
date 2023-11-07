package pe.edu.cibertec.DSWII_Grupo10.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_Grupo10.exception.ResourceNotFoundException;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Producto;
import pe.edu.cibertec.DSWII_Grupo10.service.ProductoService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private ProductoService productoService;


    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>();
        productoService.listarProductos()
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(
            @PathVariable("id") Integer id){
        Producto category = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @GetMapping("/categoryname/{filtro}")
    public ResponseEntity<List<Producto>> filtrarCategoriasPorNombre(
            @PathVariable("filtro") String filtro
    ){
        List<Producto> productoList = new ArrayList<>();
        productoService.obtenerProductosPorFiltro(filtro)
                .forEach(productoList::add);
        if(productoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<List<Producto>> buscarPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.buscarPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/productos-en-rango-de-cantidad")
    public ResponseEntity<List<Producto>> productosEnRangoDeCantidad() {
        List<Producto> productos = productoService.findProductosEnRangoDeCantidad();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/productos-con-fecha-2024")
    public ResponseEntity<List<Producto>> productosConFecha2024() {
        List<Producto> productos = productoService.findProductosConFechaDeVencimiento2024();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(
            @RequestBody Producto producto
    ){
        return new ResponseEntity<>(
                productoService.guardar(producto), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto
    ){
        Producto oldProducto = productoService
                .obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con el Id Nro. "+
                        id + " no existe."));
        oldProducto.setProductoname(producto.getProductoname());
        oldProducto.setDescripcion(producto.getDescripcion());
        return new ResponseEntity<>(
                productoService.guardar(oldProducto), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable("id") Integer id) {
        try {
            productoService.eliminarProductoPorId(id);
            return new ResponseEntity<>("Producto eliminado con ID: " + id, HttpStatus.OK);
        } catch (ResourceNotFoundException exception) {
            return new ResponseEntity<>("Producto no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>("Error al eliminar el producto con ID: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}