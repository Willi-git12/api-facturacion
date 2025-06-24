package com.WilliApp.facturacion_prod.repository;

import com.WilliApp.facturacion_prod.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
