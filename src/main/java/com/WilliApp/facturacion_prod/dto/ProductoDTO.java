package com.WilliApp.facturacion_prod.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;
}
