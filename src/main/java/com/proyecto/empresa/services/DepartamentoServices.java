package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.to.DepartamentoTO;

public class DepartamentoServices {

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final DepartamentoRepository departamentoRepository;
	private final JefeRepository jefeRepository;

	public DepartamentoServices(DepartamentoRepository departamentoRepository, JefeRepository jefeRepository) {
		this.departamentoRepository = departamentoRepository;
		this.jefeRepository = jefeRepository;
	}

	// MÉTODOS COMUNES
	// Obtener todos los departamentos
	public List<Departamento> getAllDepartamentos() {
		return departamentoRepository.findAll();
	}

	// Buscar un departamento por ID
	public Optional<Departamento> findById(Long id) {
		return departamentoRepository.findById(id);
	}

	// MÉTODOS PROPIOS
	// Método para CREAR un departamento
	public Departamento createDepartamento(DepartamentoTO d) {
		// Buscamos el jefe que vamos a insertar
		Jefe jefe = jefeRepository.findById(d.getJefe().getId())
				// Esto lo hemos hecho porque el método devuelve un Optional(puede existir o no)
				// para una variable de tipo Jefe
				.orElseThrow(() -> new RuntimeException("Jefe no encontrado"));
		d.setJefe(jefe);
		Departamento depar = new Departamento();
		depar.setNombre(d.getNombre());
		depar.setJefe(jefe);

		return departamentoRepository.save(depar);
	}

	// Método para BORRAR un departamento
	public void deleteDepartamentoById(Long idDepartamento) {
		departamentoRepository.deleteById(idDepartamento);
	}

	// Método para ACTUALIZAR un departamento
	public Departamento updateDepartamento(Long id, DepartamentoTO d) {
		//Buscamos el departamento por id
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
		
		// Busca el jefe por id
		Jefe jefe = jefeRepository.findById(d.getJefe().getId())
				.orElseThrow(() -> new RuntimeException("Jefe no encontrado"));

		//Asignamos los valores	
		departamento.setNombre(d.getNombre());
		departamento.setJefe(jefe);

		//Guardamos los cambios
		return departamentoRepository.save(departamento);

}
}
