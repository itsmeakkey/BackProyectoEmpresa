package com.proyecto.empresa.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.mappers.JefeMapper;
import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.services.JefeServices;
import com.proyecto.empresa.to.JefeTO;


public class JefeServicesImpl implements JefeServices{
	private final JefeRepository jefeRepository;
	private final JefeMapper jefeMapper;

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	public JefeServicesImpl(JefeRepository jefeRepository, JefeMapper jefeMapper) {
		this.jefeRepository = jefeRepository;
		this.jefeMapper = jefeMapper;
	}

	// MÉTODOS COMUNES
	// Método para obtener todos los registros
	public List<Jefe> getAll() {
		return jefeRepository.findAll();
	}

	// Método para buscar por ID
	public Optional<Jefe> findById(Long id) {
		return jefeRepository.findById(id);
	}

	// MÉTODOS PROPIOS
	// Método para CREAR un jefe
	@Override
	public Jefe createJefe(JefeTO j) {
	    //Convertir con el mapper
	    Jefe jefe = jefeMapper.convertirDeJefeTO(j);
	    
	    //Comprobar si es null
	    if (jefe.getFechaJefe() == null) {
	        jefe.setFechaJefe(new Date());
	    }

	    return jefeRepository.save(jefe);
	}

	// Método para ACTUALIZAR un jefe
	@Override
	public Jefe updateJefe(Long id, JefeTO j) {
		// Buscamos el jefe por id
		Jefe jefe = jefeRepository.findById(id).orElseThrow(() -> new RuntimeException("Jefe no encontrado"));

		// Asignamos los datos
		jefe.setNombre(j.getNombre());
		jefe.setEdad(j.getEdad());
		jefe.setfechaAlta(j.getfechaAlta());
		jefe.setfechaBaja(j.getfechaBaja());
		jefe.setSalario(j.getSalario());
		jefe.setFechaJefe(j.getFechaJefe());

		// Guardamos los cambios
		return jefeRepository.save(jefe);

	}

	// Método para BORRAR un jefe
	@Override
	public void deleteJefeById(Long idJefe) {
		jefeRepository.deleteById(idJefe);
	}

	// Método para buscar jefes por nombre
	@Override
	public List<Jefe> findByNombre(String nombre) {
		return jefeRepository.findByNombre(nombre);
	}

	// Método para buscar jefes por edad
	@Override
	public List<Jefe> findByEdad(int edad) {
		return jefeRepository.findByEdad(edad);
	}

	// Método para buscar jefes con salario superior a una cantidad especificada
	@Override
	public List<Jefe> findBySuperiorASalario(Long salario) {
		return jefeRepository.findBySalarioGreaterThan(salario);
	}

	// Método para buscar jefes con salario inferior a una cantidad especificada
	@Override
	public List<Jefe> findByInferiorASalario(Long salario) {
		return jefeRepository.findBySalarioLessThan(salario);
	}

	// Método para buscar jefes con salarios en un rango específico
	@Override
	public List<Jefe> findByEntreSalarios(Long salarioMin, Long salarioMax) {
		return jefeRepository.findBySalarioBetween(salarioMin, salarioMax);
	}

}
