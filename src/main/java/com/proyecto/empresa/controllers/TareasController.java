package com.proyecto.empresa.controllers;

import java.util.Date;
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

	// MÉTODOS COMUNES
	// Endpoint para obtener todos las tareas
	@GetMapping
	public List<Tarea> getAllTareas() {
		return this.tareasServices.getAll();
	}

	// Endpoint para buscar tareas por Id
	@GetMapping(path = "/{id}")
	public Optional<Tarea> findById(@PathVariable("id") Long id) {
		return this.tareasServices.findById(id);
	}

	// MÉTODOS PROPIOS

	/* CREAR */
	@PostMapping()
	public ResponseEntity<Tarea> createTarea(@RequestBody TareaTO tareaTo) {
		// Llamada al servicio para guardar la tarea
		Tarea createTarea = tareasServices.createTarea(tareaTo);

		// Devuelve una respuesta 201
		return new ResponseEntity<>(createTarea, HttpStatus.CREATED);
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
//PENDIENTES DE ARREGLAR
	// Endpoint para buscar tareas entregadas después de una fecha específica
	@GetMapping(path = "/fecha/{fechaPos}")
		public ResponseEntity<List<Tarea>>findByFechaCreacion(@PathVariable("fecha")Date fechaCreacion) {
			// Llamada al servicio para buscar la tarea
			List<Tarea> tarea = tareasServices.findByFechaCreacion(fechaCreacion);
			// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
			if (tarea.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(tarea, HttpStatus.OK);
		}
	//PENDIENTES DE ARREGLAR
	// Endpoint para buscar tareas entregadas antes de una fecha específica
	@GetMapping(path = "/fecha/{fechaAnt}")
		public ResponseEntity<List<Tarea>>findByFechaAnteriorCreacion(@PathVariable("fecha")Date fechaCreacion) {
			// Llamada al servicio para buscar la tarea
			List<Tarea> tarea = tareasServices.findByFechaAnteriorCreacion(fechaCreacion);
			// Si no encuentra la tarea, devuelve un 404. Si existe, devuelve un 200
			if (tarea.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(tarea, HttpStatus.OK);
		}
		

}
