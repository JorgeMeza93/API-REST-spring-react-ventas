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

import com.ventas.ventas.model.Producto;
import com.ventas.ventas.service.ICrudService;

@RequestMapping("/api/productos")
@RestController
public class ProductoController {
	@Autowired
	private ICrudService<Producto> productoService;
	@GetMapping
	public ResponseEntity<List<Producto>> findAll(){
		return ResponseEntity.ok(productoService.findAll());
	}
	@PostMapping
	public ResponseEntity<Producto> create(@Valid @RequestBody Producto producto){
		return new ResponseEntity<>(productoService.create(producto), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Producto> findById(@PathVariable("id") Integer idProducto){
		return productoService.findById(idProducto)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@PutMapping
	public ResponseEntity<Producto> update(@Valid @RequestBody Producto producto){
		return productoService.findById(producto.getIdProducto())
				.map( sell -> ResponseEntity.ok(productoService.update(producto)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idProducto){
		return productoService.findById(idProducto)
				.map( sell -> {
					productoService.delete(idProducto);
					return ResponseEntity.ok().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}

}
