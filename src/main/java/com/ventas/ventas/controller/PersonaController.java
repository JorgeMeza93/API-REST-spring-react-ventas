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

import com.ventas.ventas.model.Persona;
import com.ventas.ventas.service.ICrudService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private ICrudService<Persona> personaService;
	@GetMapping
	public ResponseEntity<List<Persona>> findAll(){
		return ResponseEntity.ok(personaService.findAll());	  
	}
	@PostMapping
	public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona){
		return new ResponseEntity<>(personaService.create(persona), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Persona> findById(@PathVariable("id") Integer idPersona){
		return personaService.findById(idPersona)
				.map(ResponseEntity::ok)
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@PutMapping
	public ResponseEntity<Persona> update(@Valid @RequestBody Persona persona){
		return personaService.findById(persona.getIdPersona())
				.map( person -> ResponseEntity.ok(personaService.update(persona)))
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer idPersona){
		return personaService.findById(idPersona)
				.map( person -> {
					personaService.delete(idPersona);
					return ResponseEntity.ok().build();
				})
				.orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	
}
