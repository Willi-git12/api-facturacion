package com.WilliApp.facturacion_prod.controller;

import com.WilliApp.facturacion_prod.dto.ProductoDTO;
import com.WilliApp.facturacion_prod.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Slf4j  //LOGS
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoDTO productoDTO){

        System.out.println(productoDTO.getNombre());
        log.info("Informacion productoDTO {}", productoDTO); //Log info

        return new ResponseEntity<>(productoService.save(productoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        List<ProductoDTO> productoDTOS = productoService.finAll();
        if (productoDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productoDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById (@PathVariable Integer id){
        return productoService.finById(id).map(
                ResponseEntity::ok
        ).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        if(productoService.deleteById(id))
            return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProductoDTO> update(@RequestBody ProductoDTO productoDTO){
        return productoService.update(productoDTO).map(
                ResponseEntity::ok
        ).orElseGet(
                ()-> ResponseEntity.notFound().build()
        );
    }

}
