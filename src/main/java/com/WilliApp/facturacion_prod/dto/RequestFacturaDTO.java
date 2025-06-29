package com.WilliApp.facturacion_prod.dto;

import java.util.Set;

public class RequestFacturaDTO {

    private Integer id;
    private String numeroFactura;
    private Set<RequestDetalleFacturaDTO> detalleFacturas;

    public RequestFacturaDTO(Integer id, String numeroFactura, Set<RequestDetalleFacturaDTO> detalleFacturas) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.detalleFacturas = detalleFacturas;
    }

    public Integer getId() {
        return id;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public Set<RequestDetalleFacturaDTO> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setDetalleFacturas(Set<RequestDetalleFacturaDTO> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }
}
