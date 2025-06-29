package com.WilliApp.facturacion_prod.controller;


import com.WilliApp.facturacion_prod.dto.RequestFacturaDTO;
import com.WilliApp.facturacion_prod.dto.ResponseFacturaDTO;
import com.WilliApp.facturacion_prod.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping
    public ResponseFacturaDTO save(@RequestBody RequestFacturaDTO requestFacturaDTO){
        return facturaService.save(requestFacturaDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseFacturaDTO>> findAll(){
        List<ResponseFacturaDTO> responseFacturaDTOS = facturaService.findAll();
        if (responseFacturaDTOS.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(responseFacturaDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseFacturaDTO> findById(@PathVariable Integer id){
        Optional<ResponseFacturaDTO> factura= facturaService.finById(id);
        return factura.map(
                ResponseEntity::ok
        ).orElseGet(
                () -> ResponseEntity.notFound().build()
        );
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        facturaService.deleteById(id);
    }
}
