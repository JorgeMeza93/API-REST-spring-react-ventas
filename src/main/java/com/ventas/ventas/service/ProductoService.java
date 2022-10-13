package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.Producto;
import com.ventas.ventas.repository.IProductoRepository;

@Service
public class ProductoService implements ICrudService<Producto>{
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll(); 
	}

	@Override
	public Optional<Producto> findById(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public Producto create(Producto modelo) {
		return productoRepository.save(modelo);
	}

	@Override
	public Producto update(Producto modelo) {
		return productoRepository.save(modelo);
	}

	@Override
	public void delete(Integer id) {
		productoRepository.deleteById(id);
		
	}

	

}
