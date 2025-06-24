package com.WilliApp.facturacion_prod.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "productos")
@Setter
@Getter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String detalle;
    private BigDecimal precio;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaCreado;
    @UpdateTimestamp
    private LocalDateTime fechaActualizado;
}
