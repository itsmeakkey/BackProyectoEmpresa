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

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.services.EmpleadoServices;
import com.proyecto.empresa.to.EmpleadoTO;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

	private final EmpleadoServices empleadoServices;

	@Autowired
	public EmpleadoController(EmpleadoServices empleadoServices) {
		this.empleadoServices = empleadoServices;
	}

//MÉTODOS COMUNES
	//Endpoint para obtener todos los empleados
	@GetMapping
    public List<Empleado> getAllEmpleados() {
        return this.empleadoServices.getAll();
    }
	
	//Endpoint para buscar empleados por Id
	@GetMapping(path = "/{id}")
	public Optional<Empleado> findById(@PathVariable("id") Long id){
		return this.empleadoServices.findById(id);
	}

	 //MÉTODOS PROPIOS  
    /*CREAR*/
    @PostMapping()
    public ResponseEntity<Empleado> createEmpleado(@RequestBody EmpleadoTO empleadoTO) {
    	//Llamada al service para guardar el empleado
    	Empleado createEmpleado = empleadoServices.createEmpleado(empleadoTO);
 
    	//Devolvemos una respuesta 201
        return new ResponseEntity<>(createEmpleado, HttpStatus.CREATED);
    }	
}
