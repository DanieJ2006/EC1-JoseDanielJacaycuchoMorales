package com.idat.ec1.Jose.Jacaycucho.service;

import java.util.List;


import com.idat.ec1.Jose.Jacaycucho.model.Malla;

public interface MallaService {

	void guardar(Malla malla);
	void actualizar(Malla malla);
	void eliminar(Integer id);
	List<Malla> listar();
	Malla obtener(Integer id);
}
