package com.idat.ec1.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.Jose.Jacaycucho.model.Malla;
import com.idat.ec1.Jose.Jacaycucho.repository.MallaRepository;

@Service
public class MallaServiceImp implements MallaService {
	
	@Autowired
	private MallaRepository mallaRepository;

	@Override
	public void guardar(Malla malla) {
		mallaRepository.save(malla);

	}

	@Override
	public void actualizar(Malla malla) {
		mallaRepository.saveAndFlush(malla);

	}

	@Override
	public void eliminar(Integer id) {
		mallaRepository.deleteById(id);

	}

	@Override
	public List<Malla> listar() {
		return mallaRepository.findAll();
	}

	@Override
	public Malla obtener(Integer id) {
		return mallaRepository.findById(id).orElse(null);
	}

}
