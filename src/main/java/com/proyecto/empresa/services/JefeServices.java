package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.to.JefeTO;

public class JefeServices {
	private final JefeRepository jefeRepository;

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	public JefeServices(JefeRepository jefeRepository) {
		this.jefeRepository = jefeRepository;
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
	public Jefe createJefe(JefeTO j) {
		Jefe jefe = new Jefe();
		jefe.setNombre(j.getNombre());
		jefe.setEdad(j.getEdad());
		jefe.setFecha_alta(j.getFecha_alta());
		jefe.setFecha_baja(j.getFecha_baja());
		jefe.setSalario(j.getSalario());
		jefe.setFechaJefe(j.getFechaJefe());

		return jefeRepository.save(jefe);
	}

	// Método para ACTUALIZAR un jefe
	public Jefe updateJefe(Long id, JefeTO j) {
		// Buscamos el jefe por id
		Jefe jefe = jefeRepository.findById(id).orElseThrow(() -> new RuntimeException("Jefe no encontrado"));

		// Asignamos los datos
		jefe.setNombre(j.getNombre());
		jefe.setEdad(j.getEdad());
		jefe.setFecha_alta(j.getFecha_alta());
		jefe.setFecha_baja(j.getFecha_baja());
		jefe.setSalario(j.getSalario());
		jefe.setFechaJefe(j.getFechaJefe());

		// Guardamos los cambios
		return jefeRepository.save(jefe);

	}

	// Método para BORRAR un jefe
	public void deleteJefeById(Long idJefe) {
		jefeRepository.deleteById(idJefe);
	}

	// Método para buscar jefes por nombre
	public List<Jefe> findByNombre(String nombre) {
		return jefeRepository.findByNombre(nombre);
	}

	// Método para buscar jefes por edad
	public List<Jefe> findByEdad(int edad) {
		return jefeRepository.findByEdad(edad);
	}

	// Método para buscar jefes con salario superior a una cantidad especificada
	public List<Jefe> findBySuperiorASalario(Long salario) {
		return jefeRepository.findBySalarioGreaterThan(salario);
	}

	// Método para buscar jefes con salario inferior a una cantidad especificada
	public List<Jefe> findByInferiorASalario(Long salario) {
		return jefeRepository.findBySalarioLessThan(salario);
	}

	// Método para buscar jefes con salarios en un rango específico
	public List<Jefe> findByEntreSalarios(Long salarioMin, Long salarioMax) {
		return jefeRepository.findBySalarioBetween(salarioMin, salarioMax);
	}

}
