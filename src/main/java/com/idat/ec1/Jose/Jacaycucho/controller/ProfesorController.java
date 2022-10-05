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
import com.idat.ec1.Jose.Jacaycucho.model.Profesor;
import com.idat.ec1.Jose.Jacaycucho.service.ProfesorService;

@Controller
@RequestMapping("/profesor/ec1")
public class ProfesorController {
	
	@Autowired
	private ProfesorService profesorService;
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listar(){
		return new ResponseEntity<List<Profesor>>(profesorService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Profesor profesor){
		profesorService.guardar(profesor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Profesor> obtenerPorId(@PathVariable Integer id){
		
		Profesor profesorexistente = profesorService.obtener(id);
		if(profesorexistente !=null) {
			return new ResponseEntity<Profesor>(profesorexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Profesor profesor){
		
		Profesor profesorexistente = profesorService.obtener(profesor.getIdProfesor());
		
		if(profesorexistente != null) {
			profesorService.actualizar(profesor);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Profesor profesorexistente = profesorService.obtener(id);
		if(profesorexistente != null) {
			profesorService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
