package com.idat.ec1.Jose.Jacaycucho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec1.Jose.Jacaycucho.model.Curso;
import com.idat.ec1.Jose.Jacaycucho.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public void guardar(Curso curso) {
		cursoRepository.save(curso);
		
	}

	@Override
	public void actualizar(Curso curso) {
		cursoRepository.saveAndFlush(curso);
		
	}

	@Override
	public void eliminar(Integer id) {
		cursoRepository.deleteById(id);
		
	}

	@Override
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso obtener(Integer id) {
		return cursoRepository.findById(id).orElse(null);
	}

}
