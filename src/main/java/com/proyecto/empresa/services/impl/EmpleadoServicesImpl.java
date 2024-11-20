package com.proyecto.empresa.services.impl;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.mappers.EmpleadoMapper;
import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.services.EmpleadoServices;
import com.proyecto.empresa.to.EmpleadoTO;


public class EmpleadoServicesImpl implements EmpleadoServices{

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final EmpleadoRepository empleadoRepository;
	private final DepartamentoRepository departamentoRepository;
	private final EmpleadoMapper empleadoMapper;

	public EmpleadoServicesImpl(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository, EmpleadoMapper empleadoMapper) {
		this.empleadoRepository = empleadoRepository;
		this.departamentoRepository = departamentoRepository;
		this.empleadoMapper = empleadoMapper;
	}

	// MÉTODOS COMUNES
	// Método para obtener todos los registros
	@Override
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}

	// Método para buscar por ID
	@Override
	public Optional<Empleado> findById(Long id) {
		return empleadoRepository.findById(id);
	}

	// MÉTODOS PROPIOS
	// Método para CREAR un empleado
	@Override
	public Empleado createEmpleado(EmpleadoTO e) {
	    //Convertimos con el mapper
	    Empleado empleado = empleadoMapper.convertirDeEmpleadoTO(e);
	 
	    // Buscamos el dpto por id
	    Departamento departamento = departamentoRepository.findById(e.getDepartamentoTO().getId())
	            .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
	 
	    // Asignar el departamento al empleado
	    empleado.setDepartamento(departamento);
	 
	    //Guardamos
	    return empleadoRepository.save(empleado);
	}

	// Método para BORRAR un empleado
	@Override
	public void deleteEmpleadoById(Long idEmpleado) {
		empleadoRepository.deleteById(idEmpleado);
	}

	// Método para ACTUALIZAR un empleado
	@Override
	public Empleado updateEmpleado(Long id, EmpleadoTO e) {
		// Busca el empleado por id
		Empleado empleado = empleadoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		// Buscamos el departamento por id
		Departamento departamento = departamentoRepository.findById(e.getDepartamentoTO().getId())
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

		// Asignamos los valores
		empleado.setNombre(e.getNombre());
		empleado.setEdad(e.getEdad());
		empleado.setfechaAlta(e.getfechaAlta());
		empleado.setfechaAlta(e.getfechaBaja());
		empleado.setSalario(e.getSalario());

		// Asignamos el departamento al empleado
		empleado.setDepartamento(departamento);

		// Guardamos los cambios
		return empleadoRepository.save(empleado);
	}

	// Método para buscar empleados por nombre
	@Override
	public List<Empleado> findByNombre(String nombre) {
		return empleadoRepository.findByNombre(nombre);
	}

	// Método para buscar empleados por edad
	@Override
	public List<Empleado> findByEdad(int edad) {
		return empleadoRepository.findByEdad(edad);
	}

	// Método para buscar empleados con salario superior a una cantidad especificada
	@Override
	public List<Empleado> findBySuperiorASalario(Long salario) {
		return empleadoRepository.findBySalarioGreaterThan(salario);
	}

	// Método para buscar empleados con salario inferior a una cantidad especificada
	@Override
	public List<Empleado> findByInferiorASalario(Long salario) {
		return empleadoRepository.findBySalarioLessThan(salario);
	}

	// Método para buscar empleados con salarios en un rango específico
	@Override
	public List<Empleado> findByEntreSalarios(Long salarioMin, Long salarioMax) {
		return empleadoRepository.findBySalarioBetween(salarioMin, salarioMax);
	}

}
