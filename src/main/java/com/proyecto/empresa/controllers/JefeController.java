package com.proyecto.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.services.JefeServices;

@RestController
@RequestMapping("/api/jefes")
public class JefeController {

	private final JefeServices jefeServices;
	
	@Autowired
	public JefeController(JefeServices jefeServices) {
		this.jefeServices = jefeServices;
	}
	
//MÉTODOS COMUNES	
	//Endpoint para obtener todos los jefes
	@GetMapping
    public List<Jefe> getAllJefes() {
        return this.jefeServices.getAll();
    }
	
	//Endpoint para buscar jefes por Id
	@GetMapping(path = "/{id}")
	public Optional<Jefe> findById(@PathVariable("Id") Long id){
		return this.jefeServices.findById(id);
	}
	
//MÉTODOS PROPIOS   	
	
	

	
}
