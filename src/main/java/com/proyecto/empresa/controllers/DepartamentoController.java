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

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.services.DepartamentoServices;
import com.proyecto.empresa.to.DepartamentoTO;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
	
	private final DepartamentoServices departamentoServices;
	@Autowired
	public DepartamentoController(DepartamentoServices departamentoServices) {
		this.departamentoServices = departamentoServices;
	}

	//MÉTODOS COMUNES
	//Endpoint para obtener todos los departamentos
    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return this.departamentoServices.getAllDepartamentos();
    }
    
    //Endpoint para buscar por id un departamento
    @GetMapping(path = "/{id}")
    public Optional<Departamento> findById(@PathVariable("id") Long id) {
        return this.departamentoServices.findById(id);
    }
    
    
    //MÉTODOS PROPIOS  
    /*CREAR
    Los datos devueltos de la petición son devueltos como objects y hay que castearlos.
   	Usamos Map para extraer los datos del JSON y los guardamos luego en variables extrayéndolos con get. */
    @PostMapping()
    public ResponseEntity<Departamento> createDepartamento(@RequestBody DepartamentoTO d) {
        Departamento createDepartamento = departamentoServices.createDepartamento(d);
        DepartamentoTO inventado = new DepartamentoTO();
        inventado.setNombre(createDepartamento.getNombre());
        
		return new ResponseEntity<Departamento>(createDepartamento, HttpStatus.CREATED);
    }
    

    
    
 

}
