package com.WilliApp.facturacion_prod.service;

import com.WilliApp.facturacion_prod.dto.RequestDetalleFacturaDTO;
import com.WilliApp.facturacion_prod.dto.RequestFacturaDTO;
import com.WilliApp.facturacion_prod.dto.ResponseDetalleFacturaDTO;
import com.WilliApp.facturacion_prod.dto.ResponseFacturaDTO;
import com.WilliApp.facturacion_prod.model.DetalleFactura;
import com.WilliApp.facturacion_prod.model.Factura;
import com.WilliApp.facturacion_prod.model.Producto;
import com.WilliApp.facturacion_prod.repository.FacturaRepository;
import com.WilliApp.facturacion_prod.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;
    private final ProductoRepository productoRepository;

    public FacturaService(FacturaRepository facturaRepository, ProductoRepository productoRepository) {
        this.facturaRepository = facturaRepository;
        this.productoRepository = productoRepository;
    }

    // Obtener todas las facturas
    public List<ResponseFacturaDTO> findAll() {
        return facturaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Obtener factura por ID
    public Optional<ResponseFacturaDTO> finById(Integer id) {
        return facturaRepository.findById(id)
                .map(this::toResponseDTO);
    }

    // Eliminar factura por ID
    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);
    }

    // Guardar nueva factura
    @Transactional
    public ResponseFacturaDTO save(RequestFacturaDTO requestFacturaDTO) {
        Factura factura = new Factura();
        BigDecimal subTotalFactura = BigDecimal.ZERO;
        Set<DetalleFactura> detalles = new HashSet<>();

        factura.setNumeroFactura(requestFacturaDTO.getNumeroFactura());

        for (RequestDetalleFacturaDTO detalleDTO : requestFacturaDTO.getDetalleFacturas()) {
            Producto producto = productoRepository.findById(detalleDTO.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            BigDecimal totalProducto = producto.getPrecio()
                    .multiply(BigDecimal.valueOf(detalleDTO.getCantidad()));
            subTotalFactura = subTotalFactura.add(totalProducto);

            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setId(null); // Asegura que sea una nueva entidad
            detalleFactura.setIdProducto(detalleDTO.getIdProducto());
            detalleFactura.setCantidad(detalleDTO.getCantidad());
            detalleFactura.setPrecio(producto.getPrecio());
            detalleFactura.setTotal(totalProducto);
            detalleFactura.setFactura(factura);

            detalles.add(detalleFactura);
        }

        factura.setDetalleFacturas(detalles);
        factura.setSubtotal(subTotalFactura);
        factura.setTotal(subTotalFactura.add(subTotalFactura.multiply(BigDecimal.valueOf(factura.getIVA()))));

        Factura savedFactura = facturaRepository.save(factura);
        return toResponseDTO(savedFactura);
    }

    // Mapeo manual de entidad Factura a DTO
    private ResponseFacturaDTO toResponseDTO(Factura factura) {
        ResponseFacturaDTO dto = new ResponseFacturaDTO();
        dto.setId(factura.getId());
        dto.setNumeroFactura(factura.getNumeroFactura());
        dto.setSubTotal(factura.getSubtotal());
        dto.setTotal(factura.getTotal());
        dto.setFechaCreado(factura.getFechaCreado());

        Set<ResponseDetalleFacturaDTO> detallesDTO = factura.getDetalleFacturas().stream().map(detalle -> {
            ResponseDetalleFacturaDTO detalleDTO = new ResponseDetalleFacturaDTO();
            detalleDTO.setIdProducto(detalle.getIdProducto());
            detalleDTO.setCantidad(detalle.getCantidad());
            detalleDTO.setPrecio(detalle.getPrecio());
            detalleDTO.setTotal(detalle.getTotal());
            return detalleDTO;
        }).collect(Collectors.toSet());

        dto.setDetallesFacturas(detallesDTO);
        return dto;
    }
}
