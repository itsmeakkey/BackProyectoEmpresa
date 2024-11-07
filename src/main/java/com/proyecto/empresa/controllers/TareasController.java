package com.proyecto.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.services.TareasServices;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {

	private final TareasServices tareasServices;

	@Autowired
	public TareasController(TareasServices tareasServices) {
	this.tareasServices = tareasServices;
	}
	
	//MÉTODOS COMUNES	
		//Endpoint para obtener todos las tareas
		@GetMapping
	    public List<Tarea> getAllTareas() {
	        return this.tareasServices.getAll();
	    }
		
		//Endpoint para buscar tareas por Id
		@GetMapping(path = "/{id}")
		public Optional<Tarea> findById(@PathVariable("Id") Long id){
			return this.tareasServices.findById(id);
		}
		
	//MÉTODOS PROPIOS 
		
		
		
}
