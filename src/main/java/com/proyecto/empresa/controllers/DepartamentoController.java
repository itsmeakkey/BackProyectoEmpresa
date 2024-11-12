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

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.services.DepartamentoServices;
import com.proyecto.empresa.to.DepartamentoTO;
import com.proyecto.empresa.to.EmpleadoTO;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

	private final DepartamentoServices departamentoServices;

	@Autowired
	public DepartamentoController(DepartamentoServices departamentoServices) {
		this.departamentoServices = departamentoServices;
	}

	// MÉTODOS COMUNES
	// Endpoint para obtener todos los departamentos
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamentos() {
		List<Departamento> obtenerDepartamentos= departamentoServices.getAllDepartamentos();
		//Si no existen 
		 if (obtenerDepartamentos.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		 //Si existen
		return new ResponseEntity<>(obtenerDepartamentos, HttpStatus.OK);
	}

	// Endpoint para buscar por id un departamento
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Departamento>> findById(@PathVariable("id") Long id) {
		Optional<Departamento> obtenerDepartamentoId = departamentoServices.findById(id);
		//Si no existen 
		 if (obtenerDepartamentoId.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		return new ResponseEntity<>(obtenerDepartamentoId, HttpStatus.OK);
	}

	// MÉTODOS PROPIOS
	//Endpoint para CREAR un departamento
	@PostMapping()
	public ResponseEntity<Departamento> createDepartamento(@RequestBody DepartamentoTO d) {
		Departamento createDepartamento = departamentoServices.createDepartamento(d);
		DepartamentoTO inventado = new DepartamentoTO();
		inventado.setNombre(createDepartamento.getNombre());
		

		return new ResponseEntity<Departamento>(createDepartamento, HttpStatus.CREATED);
	}
	
	//Endpoint para ACTUALIZAR un departamento
    @PutMapping(path = "/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable ("id")  Long id, @RequestBody DepartamentoTO departamentoAct) {
        // Llamada al servicio para actualizar el empleado
        Departamento departamentoActualizado = departamentoServices.updateDepartamento(id, departamentoAct);
        
        // Devuelve el empleado actualizado con un código HTTP 200 OK
        return new ResponseEntity<>(departamentoActualizado, HttpStatus.OK);
    }
    
	//Endpoint para BORRAR un departamento
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteDepartamentoById(@PathVariable ("id") Long id) {
		departamentoServices.deleteDepartamentoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
