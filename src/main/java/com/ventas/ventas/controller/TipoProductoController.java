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

import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.service.ICrudService;

@RequestMapping("/api/tipoproducto")
@RestController
public class TipoProductoController {
	@Autowired
	private ICrudService<TipoProducto> tipoProductoService;
	@GetMapping
	public ResponseEntity<List<TipoProducto>> findAll(){
		return ResponseEntity.ok(tipoProductoService.findAll());
	}
	@PostMapping
	public ResponseEntity<TipoProducto> create(@Valid @RequestBody TipoProducto tipoProducto){
		return new ResponseEntity<>(tipoProductoService.create(tipoProducto), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<TipoProducto> findById(@PathVariable("id") Integer idTipoProducto){
		return tipoProductoService.findById(idTipoProducto)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build() );
	}
	@PutMapping
	public ResponseEntity<TipoProducto> update(@Valid @RequestBody TipoProducto tipoProducto){
		return tipoProductoService.findById(tipoProducto.getIdTipoProducto())
				.map( tipo -> ResponseEntity.ok(tipoProductoService.update(tipoProducto)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idTipoProducto){
		return tipoProductoService.findById(idTipoProducto)
				.map( tipo -> {
					tipoProductoService.delete(idTipoProducto);
					return ResponseEntity.ok().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
}






