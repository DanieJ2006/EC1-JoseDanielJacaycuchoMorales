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

import com.idat.ec1.Jose.Jacaycucho.model.Universidad;
import com.idat.ec1.Jose.Jacaycucho.service.UniversidadService;

@Controller
@RequestMapping("/universidad/ec1")
public class UniversidadController {
	
	@Autowired
	private UniversidadService universidadService;
	
	
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Universidad>> listar(){
		return new ResponseEntity<List<Universidad>>(universidadService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad){
		universidadService.guardar(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Universidad> obtenerPorId(@PathVariable Integer id){
		
		Universidad universidadexistente = universidadService.obtener(id);
		if(universidadexistente !=null) {
			return new ResponseEntity<Universidad>(universidadexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Universidad universidad){
		
		Universidad universidadexistente = universidadService.obtener(universidad.getIdUniversidad());
		
		if(universidadexistente != null) {
			universidadService.actualizar(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Universidad universidadexistente = universidadService.obtener(id);
		if(universidadexistente != null) {
			universidadService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
