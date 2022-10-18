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

import com.ventas.ventas.model.Venta;
import com.ventas.ventas.service.ICrudService;

@RequestMapping("/api/ventas")
@RestController
public class VentaController {
	
	@Autowired
	private ICrudService<Venta> ventaService;
	@GetMapping
	public ResponseEntity<List<Venta>> findAll(){
		return ResponseEntity.ok(ventaService.findAll());
	}
	@PostMapping
	public ResponseEntity<Venta> create(@Valid @RequestBody Venta venta){
		return new ResponseEntity<>(ventaService.create(venta), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Venta> findById(@PathVariable("id") Integer idVenta){
		return ventaService.findById(idVenta)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@PutMapping
	public ResponseEntity<Venta> update(@Valid @RequestBody Venta venta){
		return ventaService.findById(venta.getIdVenta())
				.map( sell -> ResponseEntity.ok(ventaService.update(venta)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idVenta){
		return ventaService.findById(idVenta)
				.map( sell -> {
					ventaService.delete(idVenta);
					return ResponseEntity.ok().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
}
