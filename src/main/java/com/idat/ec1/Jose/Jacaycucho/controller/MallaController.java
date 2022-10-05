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
import com.idat.ec1.Jose.Jacaycucho.model.Malla;
import com.idat.ec1.Jose.Jacaycucho.service.MallaService;

@Controller
@RequestMapping("/malla/ec1")
public class MallaController {
	
	
	@Autowired
	private MallaService mallaService;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Malla>> listar(){
		return new ResponseEntity<List<Malla>>(mallaService.listar(), HttpStatus.OK) ;
	}
	
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Malla malla){
		mallaService.guardar(malla);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(path = "/listar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Malla> obtenerPorId(@PathVariable Integer id){
		
		Malla mallaexistente = mallaService.obtener(id);
		if(mallaexistente !=null) {
			return new ResponseEntity<Malla>(mallaexistente,HttpStatus.OK);
		}else {
			return new ResponseEntity<Malla>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	@RequestMapping(path = "/editar",method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody Malla malla){
		
		Malla mallaexistente = mallaService.obtener(malla.getIdMalla());
		
		if(mallaexistente != null) {
			mallaService.actualizar(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Malla mallaexistente = mallaService.obtener(id);
		if(mallaexistente != null) {
			mallaService.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
