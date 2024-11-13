package com.proyecto.empresa.services.impl;

import java.util.List;
import java.util.Optional;
import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.services.DepartamentoServices;
import com.proyecto.empresa.to.DepartamentoTO;


public class DepartamentoServicesImpl implements DepartamentoServices {

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final DepartamentoRepository departamentoRepository;
	private final JefeRepository jefeRepository;

	public DepartamentoServicesImpl(DepartamentoRepository departamentoRepository, JefeRepository jefeRepository) {
		this.departamentoRepository = departamentoRepository;
		this.jefeRepository = jefeRepository;
	}

	// MÉTODOS COMUNES
	// Obtener todos los departamentos
	@Override
	public List<Departamento> getAllDepartamentos() {
		return departamentoRepository.findAll();
	}

	// Buscar un departamento por ID
	@Override
	public Optional<Departamento> findById(Long id) {
		return departamentoRepository.findById(id);
	}

	// MÉTODOS PROPIOS
	// Método para CREAR un departamento
	@Override
	public Departamento createDepartamento(DepartamentoTO d) {
		// Buscamos el jefe que vamos a insertar
		Jefe jefe = jefeRepository.findById(d.getJefeTO().getId())
				// Esto lo hemos hecho porque el método devuelve un Optional(puede existir o no)
				// para una variable de tipo Jefe
				.orElseThrow(() -> new RuntimeException("Jefe no encontrado"));
		//Configuramos el nuevo departamento
		Departamento depar = new Departamento();
		depar.setNombre(d.getNombre());
		depar.setJefe(jefe);

		return departamentoRepository.save(depar);
	}

	// Método para BORRAR un departamento
	@Override
	public void deleteDepartamentoById(Long idDepartamento) {
		departamentoRepository.deleteById(idDepartamento);
	}

	// Método para ACTUALIZAR un departamento
	@Override
	public Departamento updateDepartamento(Long id, DepartamentoTO d) {
		//Buscamos el departamento por id
		Departamento departamento = departamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
		
		// Busca el jefe por id
		Jefe jefe = jefeRepository.findById(d.getJefeTO().getId())
				.orElseThrow(() -> new RuntimeException("Jefe no encontrado"));

		//Asignamos los valores	
		departamento.setNombre(d.getNombre());
		departamento.setJefe(jefe);

		//Guardamos los cambios
		return departamentoRepository.save(departamento);

}
}
