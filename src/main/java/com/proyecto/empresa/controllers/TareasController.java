package com.proyecto.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.services.TareasServices;
import com.proyecto.empresa.to.TareaTO;

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
		public Optional<Tarea> findById(@PathVariable("id") Long id){
			return this.tareasServices.findById(id);
		}
		
	//MÉTODOS PROPIOS 
		
		 /*CREAR */
		@PostMapping()
		public ResponseEntity<Tarea> createTarea(@RequestBody TareaTO tareaTo){
			//Llamada al servicio para guardar la tarea
			Tarea createTarea = tareasServices.createTarea(tareaTo);
			
			//Devuelve una respuesta 201
			return new ResponseEntity<>(createTarea, HttpStatus.CREATED);
		}
	    
	    
}
