package pe.edu.cibertec.DSWII_Grupo10.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_Grupo10.model.bd.Producto;
import pe.edu.cibertec.DSWII_Grupo10.service.ProductoService;
import pe.edu.cibertec.DSWII_Grupo10.model.dto.DtoEntity;
import pe.edu.cibertec.DSWII_Grupo10.model.dto.ProductoDto;
import pe.edu.cibertec.DSWII_Grupo10.util.DtoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductoController {
    private ProductoService productService;
    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productList = new ArrayList<>();
        productService.listarProductos().forEach(productList::add);
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DtoEntity>> listarProductosDto(){
        List<DtoEntity> productList = new ArrayList<>();
        productList = productService.listarProductos()
                .stream()
                .map(prod -> new DtoUtil().convertirADto(prod, new ProductoDto()))
                .collect(Collectors.toList());
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(productList, HttpStatus.OK);
    }

}