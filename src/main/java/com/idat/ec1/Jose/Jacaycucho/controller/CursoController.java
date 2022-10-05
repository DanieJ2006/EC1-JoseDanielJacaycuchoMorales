package com.idat.ec1.Jose.Jacaycucho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.idat.ec1.Jose.Jacaycucho.model.Curso;
import com.idat.ec1.Jose.Jacaycucho.service.CursoService;

@Controller
@RequestMapping("/curso/ec1")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar(){
		return new ResponseEntity<List<Curso>>(cursoService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Curso curso){
		cursoService.guardar(curso);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id){
		
		Curso cursoexistente = cursoService.obtener(id);
		if(cursoexistente !=null) {
			return new ResponseEntity<Curso>(cursoexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Curso curso){
		
		Curso cursoexistente = cursoService.obtener(curso.getIdCurso());
		
		if(cursoexistente != null) {
			cursoService.actualizar(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Curso cursoexistente = cursoService.obtener(id);
		if(cursoexistente != null) {
			cursoService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
