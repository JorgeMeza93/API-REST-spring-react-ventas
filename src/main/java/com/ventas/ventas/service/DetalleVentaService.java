package com.ventas.ventas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.repository.IDetalleVentaRepository;

@Service
public class DetalleVentaService implements ICrudService<DetalleVenta>{
	
	@Autowired
	private IDetalleVentaRepository detalleVenta;
	
	@Override
	public List<DetalleVenta> findAll() {
		return detalleVenta.findAll();
	}

	@Override
	public Optional<DetalleVenta> findById(Integer id) {
		return detalleVenta.findById(id);
	}

	@Override
	public DetalleVenta create(DetalleVenta modelo) {
		return detalleVenta.save(modelo);
	}

	@Override
	public DetalleVenta update(DetalleVenta modelo) {
		return detalleVenta.save(modelo);

	}

	@Override
	public void delete(Integer id) {
		detalleVenta.deleteById(id);
	}

}
