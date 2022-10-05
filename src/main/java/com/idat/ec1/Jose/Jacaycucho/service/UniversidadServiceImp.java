package com.idat.ec1.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.Jose.Jacaycucho.model.Universidad;
import com.idat.ec1.Jose.Jacaycucho.repository.UniversidadRepository;

@Service
public class UniversidadServiceImp implements UniversidadService {
	
	@Autowired
	private UniversidadRepository universidadRepository;

	@Override
	public void guardar(Universidad universidad) {
		universidadRepository.save(universidad);

	}

	@Override
	public void actualizar(Universidad universidad) {
		universidadRepository.saveAndFlush(universidad);

	}

	@Override
	public void eliminar(Integer id) {
		universidadRepository.deleteById(id);

	}

	@Override
	public List<Universidad> listar() {
		return universidadRepository.findAll();
	}

	@Override
	public Universidad obtener(Integer id) {
		return universidadRepository.findById(id).orElse(null);
	}

}
