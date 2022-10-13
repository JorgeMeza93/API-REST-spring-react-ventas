package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.repository.ITipoProductoRepository;

@Service
public class TipoProductoService implements ICrudService<TipoProducto>{
	
	@Autowired
	private ITipoProductoRepository tipoProductoRepository;
	
	@Override
	public List<TipoProducto> findAll() {
		return tipoProductoRepository.findAll();
	}

	@Override
	public Optional<TipoProducto> findById(Integer id) {
		return tipoProductoRepository.findById(id);
	}

	@Override
	public TipoProducto create(TipoProducto modelo) {
		return tipoProductoRepository.save(modelo);
	}

	@Override
	public TipoProducto update(TipoProducto modelo) {
		return tipoProductoRepository.save(modelo);
	}

	@Override
	public void delete(Integer id) {
		tipoProductoRepository.deleteById(id);
		
	}

}
