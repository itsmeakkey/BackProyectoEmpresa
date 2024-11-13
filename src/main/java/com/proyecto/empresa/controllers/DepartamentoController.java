package com.proyecto.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.proyecto.empresa.mappers.DepartamentoMapper;
import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.services.DepartamentoServices;
import com.proyecto.empresa.to.DepartamentoTO;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

	private final DepartamentoServices departamentoServices;
	private final DepartamentoMapper departamentoMapper;

	@Autowired
	public DepartamentoController(DepartamentoServices departamentoServices, DepartamentoMapper departamentoMapper) {
		this.departamentoServices = departamentoServices;
		this.departamentoMapper = departamentoMapper;
	}

	// Endpoint para obtener todos los departamentos
	@GetMapping
	public ResponseEntity<List<DepartamentoTO>> getAllDepartamentos() {
		List<Departamento> obtenerDepartamentos = departamentoServices.getAllDepartamentos();

		// Si no existen, devolvemos 404
		if (obtenerDepartamentos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Si existen: Convertimos la lista de Departamento a DepartamentoTO usando el mapper
		List<DepartamentoTO> departamentosTO = departamentoMapper.convertirListaADepartamentoTO(obtenerDepartamentos);
		return new ResponseEntity<>(departamentosTO, HttpStatus.OK);
	}

	// Endpoint para buscar por id un departamento
	@GetMapping(path = "/{id}")
	public ResponseEntity<DepartamentoTO> findById(@PathVariable("id") Long id) {
		Optional<Departamento> obtenerDepartamentoId = departamentoServices.findById(id);
		// Si no existen
		if (obtenerDepartamentoId.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		// Conversión de de Departamento a DepartamentoTO con el mapper
		DepartamentoTO departamentoTO = departamentoMapper.convertirADepartamentoTO(obtenerDepartamentoId.get());//Preguntar
		return new ResponseEntity<>(departamentoTO, HttpStatus.OK);
	}

	// MÉTODOS PROPIOS
	// Endpoint para CREAR un departamento
	@PostMapping()
	public ResponseEntity<DepartamentoTO> createDepartamento(@RequestBody DepartamentoTO d) {
		Departamento createDepartamento = departamentoServices.createDepartamento(d);
		//Lo convertimos a departamentoTO con el mapper
		DepartamentoTO departamentoTO = departamentoMapper.convertirADepartamentoTO(createDepartamento);

		return new ResponseEntity<>(departamentoTO, HttpStatus.CREATED);
	}

	// Endpoint para ACTUALIZAR un departamento
	@PutMapping(path = "/{id}")
	public ResponseEntity<DepartamentoTO> updateDepartamento(@PathVariable("id") Long id,
			@RequestBody DepartamentoTO departamentoAct) {
		// Llamada al servicio para actualizar el empleado
		Departamento departamentoActualizado = departamentoServices.updateDepartamento(id, departamentoAct);
		
		// Convertimos Departamento a DepartamentoTO
		DepartamentoTO departamentoTO = departamentoMapper.convertirADepartamentoTO(departamentoActualizado);

		// Devuelve el empleado actualizado con un código HTTP 200 OK
		return new ResponseEntity<>(departamentoTO, HttpStatus.OK);
	}

	// Endpoint para BORRAR un departamento (No necesita conversión porque solo usamos el id)
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteDepartamentoById(@PathVariable("id") Long id) {
		departamentoServices.deleteDepartamentoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
