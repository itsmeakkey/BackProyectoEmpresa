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

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.services.impl.EmpleadoServicesImpl;
import com.proyecto.empresa.to.EmpleadoTO;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

	private final EmpleadoServicesImpl empleadoServices;

	@Autowired
	public EmpleadoController(EmpleadoServicesImpl empleadoServices) {
		this.empleadoServices = empleadoServices;
	}

//MÉTODOS COMUNES
	// Endpoint para obtener todos los empleados
	@GetMapping
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		List<Empleado> obtenerEmpleados= empleadoServices.getAll();
		//Si no existen 
		 if (obtenerEmpleados.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		 //Si existen
		return new ResponseEntity<>(obtenerEmpleados, HttpStatus.OK);
	}

	// Endpoint para buscar empleados por Id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Empleado>> findById(@PathVariable("id") Long id) {
		Optional<Empleado> obtenerEmpleadoId = empleadoServices.findById(id);
		//Si no existen 
		 if (obtenerEmpleadoId.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		//Si existen
			return new ResponseEntity<>(obtenerEmpleadoId, HttpStatus.OK);
	}

	// MÉTODOS PROPIOS
	// Endpoint para CREAR un empleado
	@PostMapping()
	public ResponseEntity<Empleado> createEmpleado(@RequestBody EmpleadoTO empleadoTO) {
		// Llamada al service para guardar el empleado
		Empleado createEmpleado = empleadoServices.createEmpleado(empleadoTO);

		// Devolvemos una respuesta 201
		return new ResponseEntity<>(createEmpleado, HttpStatus.CREATED);
	}
	
	// Endpoint para BORRAR un empleado por ID
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteEmpleadoById(@PathVariable("id") Long id) {
		empleadoServices.deleteEmpleadoById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
    // Endpoint para ACTUALIZAR un empleado por ID
    @PutMapping(path = "/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable ("id")  Long id, @RequestBody EmpleadoTO empleadoAct) {
        // Llamada al servicio para actualizar el empleado
        Empleado empleadoActualizado = empleadoServices.updateEmpleado(id, empleadoAct);
        
        // Devuelve el empleado actualizado con un código HTTP 200 OK
        return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
    }

	// Endpoint para buscar por nombre
	@GetMapping(path = "/nombre/{nombre}")
	public ResponseEntity<List<Empleado>> findByNombre(@PathVariable("nombre") String nombre) {
		List<Empleado> empleado = empleadoServices.findByNombre(nombre);

		// Si no encuentra el nombre, devuelve un 404. Si existe, devuelve un 200
		if (empleado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	// Endpoint para buscar por edad
	@GetMapping(path = "/edad/{edad}")
	public ResponseEntity<List<Empleado>> findByEdad(@PathVariable("edad") Integer edad) {
		List<Empleado> empleado = empleadoServices.findByEdad(edad);

		// Si no encuentra la edad, devuelve un 404. Si existe, devuelve un 200
		if (empleado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	// Endpoint para buscar por un salario superior a x.
	@GetMapping(path = "/salariosup/{salario}")
	public ResponseEntity<List<Empleado>> findBySuperiorASalario(@PathVariable("salario") Long salario) {
		List<Empleado> empleado = empleadoServices.findBySuperiorASalario(salario);

		// Si no encuentra el salario, devuelve un 404. Si existe, devuelve un 200
		if (empleado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	// Endpoint para buscar por un salario inferior a x.
	@GetMapping(path = "/salariosinf/{salario}")
	public ResponseEntity<List<Empleado>> findByInferiorASalario(@PathVariable("salario") Long salario) {
		List<Empleado> empleado = empleadoServices.findByInferiorASalario(salario);

		// Si no encuentra el salario, devuelve un 404. Si existe, devuelve un 200
		if (empleado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	// Endpoint para buscar entre dos valores salario.
	@GetMapping(path = "/salariosbet/{salarioA}/{salarioB}")
	public ResponseEntity<List<Empleado>> findByEntreSalarios(@PathVariable("salarioA") Long salarioA,
			@PathVariable("salarioB") Long salarioB) {
		List<Empleado> empleado = empleadoServices.findByEntreSalarios(salarioA, salarioB);
		if (empleado.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}

	

}
