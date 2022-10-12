package com.ventas.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.ventas.model.Venta;

public interface IVentasRepository extends JpaRepository<Venta, Integer>{

}
