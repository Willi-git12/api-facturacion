package com.WilliApp.facturacion_prod.repository;

import com.WilliApp.facturacion_prod.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
