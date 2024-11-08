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
        
    //Endpoint para buscar por nombre
    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<List<Jefe>> findByNombre (@PathVariable("nombre") String nombre){
    	List<Jefe> jefes = jefeServices.findByNombre(nombre);
    	
    	//Si no encuentra el nombre, devuelve un 404. Si existe, devuelve un 200
        if (jefes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    	
    }
    
    //Endpoint para buscar por edad
    @GetMapping(path = "/edad/{edad}")
    public ResponseEntity<List<Jefe>> findByEdad (@PathVariable("edad") Integer edad){
    	List<Jefe> jefes = jefeServices.findByEdad(edad);
    	
    	//Si no encuentra la edad, devuelve un 404. Si existe, devuelve un 200
        if (jefes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    	
    }
    
    //Endpoint para buscar por un salario superior a x.
    @GetMapping(path = "/salariosup/{salario}")
    public ResponseEntity<List<Jefe>> findBySuperiorASalario (@PathVariable("salario") Long salario){
    	List<Jefe> jefes = jefeServices.findBySuperiorASalario(salario);
    	
    	//Si no encuentra el salario, devuelve un 404. Si existe, devuelve un 200
        if (jefes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    }
    
    //Endpoint para buscar por un salario inferior a x.
    @GetMapping(path = "/salariosinf/{salario}")
    public ResponseEntity<List<Jefe>> findByInferiorASalario (@PathVariable("salario") Long salario){
    	List<Jefe> jefes = jefeServices.findByInferiorASalario(salario);
    	
    	//Si no encuentra el salario, devuelve un 404. Si existe, devuelve un 200
        if (jefes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    }
    
    //Endpoint para buscar entre dos valores salario.
    @GetMapping(path = "/salariosbet/{salarioA}/{salarioB}")
    public ResponseEntity<List<Jefe>> findByEntreSalarios (@PathVariable("salarioA") Long salarioA, @PathVariable("salarioB") Long salarioB ){
    	List<Jefe> jefes = jefeServices.findByEntreSalarios(salarioA, salarioB);
    	if (jefes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jefes, HttpStatus.OK);
    }


    

		
}
