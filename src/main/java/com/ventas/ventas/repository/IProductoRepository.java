package com.ventas.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ventas.ventas.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
