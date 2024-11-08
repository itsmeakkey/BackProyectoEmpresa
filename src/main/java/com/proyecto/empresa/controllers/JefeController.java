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

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.services.JefeServices;
import com.proyecto.empresa.to.JefeTO;

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
	public Optional<Jefe> findById(@PathVariable("id") Long id){
		return this.jefeServices.findById(id);
	}
	
//MÉTODOS PROPIOS   	
    //Endpoint para crear un jefe
    @PostMapping
    public ResponseEntity<Jefe> createJefe(@RequestBody JefeTO jefeTo) {
		//Llamada al servicio para guardar el jefe
    	Jefe createJefe = jefeServices.createJefe(jefeTo);
    	
    	//Devuelve una respuesta 201
        return new ResponseEntity <>(createJefe,HttpStatus.CREATED);
    }
		
}
