package com.ventas.ventas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.service.ICrudService;

@RequestMapping("/api/detalleventa")
@RestController
public class DetalleVentaController {
	
	@Autowired
	private ICrudService<DetalleVenta> detalleVentaService;
	@GetMapping
	public ResponseEntity<List<DetalleVenta>> findAll(){
		return ResponseEntity.ok(detalleVentaService.findAll());
	}
	@PostMapping
	public ResponseEntity<DetalleVenta> create(@Valid @RequestBody DetalleVenta detalle){
		return new ResponseEntity<>(detalleVentaService.create(detalle), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalleVenta> findById(@PathVariable("id") Integer idDetalleVenta){
		return detalleVentaService.findById(idDetalleVenta)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@PutMapping
	public ResponseEntity<DetalleVenta> update(@Valid @RequestBody DetalleVenta detalleVenta){
		return detalleVentaService.findById(detalleVenta.getIdDetalleVenta())
				.map( sell -> ResponseEntity.ok(detalleVentaService.update(detalleVenta)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idProducto){
		return detalleVentaService.findById(idProducto)
				.map( sell -> {
					detalleVentaService.delete(idProducto);
					return ResponseEntity.ok().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
}
