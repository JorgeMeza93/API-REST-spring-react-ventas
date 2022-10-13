package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.Persona;
import com.ventas.ventas.repository.IPersonaRepository;

@Service
public class PersonaService implements ICrudService<Persona>{
	
	@Autowired
	private IPersonaRepository personaRepository;
	
	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(Integer id) {
		return personaRepository.findById(id);
	}

	@Override
	public Persona create(Persona modelo) {
		return personaRepository.save(modelo);
	}

	@Override
	public Persona update(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public void delete(Integer id) {
		personaRepository.deleteById(id);
		
	}

}
