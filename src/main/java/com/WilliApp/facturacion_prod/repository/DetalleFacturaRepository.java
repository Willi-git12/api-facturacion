package com.WilliApp.facturacion_prod.repository;

import com.WilliApp.facturacion_prod.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
}
