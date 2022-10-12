package com.ventas.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.ventas.model.DetalleVenta;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta, Integer>{

}
