package com.proyecto.empresa.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.services.DepartamentoServices;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	
	private final DepartamentoServices departamentoServices;
	@Autowired
	public DepartamentoController(DepartamentoServices departamentoServices) {
		this.departamentoServices = departamentoServices;
	}
	// Endpoint para obtener todos los departamentos
    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoServices.getAllDepartamentos();
    }
 
 

}
