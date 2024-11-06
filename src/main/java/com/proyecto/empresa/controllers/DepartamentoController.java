package com.proyecto.empresa.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//Endpoint para obtener todos los departamentos
    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return this.departamentoServices.getAllDepartamentos();
    }
    
    //Endpoint para buscar por id un departamento
    @GetMapping(path = "/{id}")
    public Optional<Departamento> findById(@PathVariable("Id") Long id) {
        return this.departamentoServices.findById(id);
    }
    
    //Crear un departamento nuevo . @RequestBody convierte el json a Departamento en la petición
    @PostMapping()
    public Departamento saveDepartamento(@RequestBody Departamento d) {
    return this.departamentoServices.saveDepartamento(d);
    }
    
    
 

}
