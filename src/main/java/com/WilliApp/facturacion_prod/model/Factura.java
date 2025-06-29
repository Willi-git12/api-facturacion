package com.WilliApp.facturacion_prod.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numeroFactura;
    private BigDecimal subtotal;
    private BigDecimal total;

    @Transient
    private final double IVA = 0.15; // 15% iva

    @CreationTimestamp
    private LocalDateTime fechaCreado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura", orphanRemoval = true)
    private Set<DetalleFactura> detalleFacturas;

}
