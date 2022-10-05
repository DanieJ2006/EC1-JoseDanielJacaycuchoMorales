package com.idat.ec1.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.Jose.Jacaycucho.model.Profesor;
import com.idat.ec1.Jose.Jacaycucho.repository.ProfesorRepository;

@Service
public class ProfesorServiceImp implements ProfesorService {
	
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public void guardar(Profesor profesor) {
		profesorRepository.save(profesor);
		
	}

	@Override
	public void actualizar(Profesor profesor) {
		profesorRepository.saveAndFlush(profesor);
		
	}

	@Override
	public void eliminar(Integer id) {
		profesorRepository.deleteById(id);
		
	}

	@Override
	public List<Profesor> listar() {
		return profesorRepository.findAll();
	}

	@Override
	public Profesor obtener(Integer id) {
		return profesorRepository.findById(id).orElse(null);
	}

}
