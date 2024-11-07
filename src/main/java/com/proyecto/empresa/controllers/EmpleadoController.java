package com.proyecto.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.services.EmpleadoServices;

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
	public Optional<Empleado> findById(@PathVariable("Id") Long id){
		return this.empleadoServices.findById(id);
	}

//MÉTODOS PROPIOS   
	
}
