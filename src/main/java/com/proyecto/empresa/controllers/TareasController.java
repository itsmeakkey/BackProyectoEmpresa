package com.proyecto.empresa.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.services.impl.TareasServicesImpl;
import com.proyecto.empresa.to.TareaTO;

@RestController
@RequestMapping("/api/tareas")
public class TareasController {

	private final TareasServicesImpl tareasServices;

	@Autowired
	public TareasController(TareasServicesImpl tareasServices) {
		this.tareasServices = tareasServices;
	}

	// MÉTODOS COMUNES
	// Endpoint para obtener todos las tareas
	@GetMapping
	public ResponseEntity<List<Tarea>> getAllTareas() {
		List<Tarea> obtenerTareas= tareasServices.getAll();
		//Si no existen 
		 if (obtenerTareas.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		 //Si existen
		return new ResponseEntity<>(obtenerTareas, HttpStatus.OK);
	}

	// Endpoint para buscar tareas por Id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Tarea>> findById(@PathVariable("id") Long id) {
		Optional<Tarea> obtenerTareaId = tareasServices.findById(id);
		//Si no existen 
		 if (obtenerTareaId.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		//Si existen
			return new ResponseEntity<>(obtenerTareaId, HttpStatus.OK);
	}

	// MÉTODOS PROPIOS
	// Endpoint para CREAR una tarea
	@PostMapping()
	public ResponseEntity<Tarea> createTarea(@RequestBody TareaTO tareaTo) {
		// Llamada al servicio para guardar la tarea
		Tarea createTarea = tareasServices.createTarea(tareaTo);

		// Devuelve una respuesta 201
		return new ResponseEntity<>(createTarea, HttpStatus.CREATED);
	}

	// Endpoint para BORRAR una tarea
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteTareaById(@PathVariable("id") Long id) {
		tareasServices.deleteTareaById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// Endpoint para ACTUALIZAR una tarea
	@PutMapping(path = "/{id}")
	public ResponseEntity<Tarea> updateTarea(@PathVariable("id") Long id, @RequestBody TareaTO TareaAct){
		//Llamada al servicio y retorno de un código 2OO
		Tarea tareaActualizada = tareasServices.updateTarea(id, TareaAct);
		return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);	
	}

	// Endpoint para buscar tareas asignadas a un empelado específico
	@GetMapping(path = "/tarea/{empleadoId}")
	public ResponseEntity<List<Tarea>> findByEmpleadoId(@PathVariable("empleadoId") Long id) {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByEmpleadoId(id);
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas entregadas a tiempo(true)
	@GetMapping(path = "/tarea/true")
	public ResponseEntity<List<Tarea>> findByEntregaATiempo() {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByEntregaATiempo();
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas entregadas a destiempo(false)
	@GetMapping(path = "/tarea/false")
	public ResponseEntity<List<Tarea>> findByEntregaADestiempo() {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByEntregaADestiempo();
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas no finalizadas
	@GetMapping(path = "/tarea/nofinalizada")
	public ResponseEntity<List<Tarea>> findByNotFinished() {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByNotFinished();
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas entregadas después de una fecha específica.
	// DateTimeFormat nos permite el usar el forato YYYY-MM-DD en la URL
	@GetMapping(path = "/fechaDespues/{fecha}")
	ResponseEntity<List<Tarea>> findByFechaCreacion(
			@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCreacion) {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByFechaCreacion(fechaCreacion);
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas entregadas antes de una fecha específica
	@GetMapping(path = "/fechaAnterior/{fecha}")
	public ResponseEntity<List<Tarea>> findByFechaAnteriorCreacion(
			@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaCreacion) {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByFechaAnteriorCreacion(fechaCreacion);
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

	// Endpoint para buscar tareas entregadas entre dos fechas
	@GetMapping(path = "/fechaEntre/{fechauno}/{fechados}")
	public ResponseEntity<List<Tarea>> findByFechaCreacionBetween(
			@PathVariable("fechauno") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaA,
			@PathVariable("fechados") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaB) {
		// Llamada al servicio para buscar la tarea
		List<Tarea> tarea = tareasServices.findByFechaEntreCreacion(fechaA, fechaB);
		// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
		if (tarea.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(tarea, HttpStatus.OK);
	}

}
