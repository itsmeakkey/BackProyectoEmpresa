package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.to.EmpleadoTO;

public class EmpleadoServices {

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final EmpleadoRepository empleadoRepository;
	private final DepartamentoRepository departamentoRepository;

	public EmpleadoServices(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository) {
		this.empleadoRepository = empleadoRepository;
		this.departamentoRepository = departamentoRepository;
	}

	// MÉTODOS COMUNES
	// Método para obtener todos los registros
	public List<Empleado> getAll() {
		return empleadoRepository.findAll();
	}

	// Método para buscar por ID
	public Optional<Empleado> findById(Long id) {
		return empleadoRepository.findById(id);
	}

	// MÉTODOS PROPIOS
	// Método para CREAR un empleado
	public Empleado createEmpleado(EmpleadoTO e) {
		// Buscamos el departamento por ID
		Departamento departamento = departamentoRepository.findById(e.getDepartamentoTO().getId())
				.orElseThrow(() -> new RuntimeException("Departamento no encontrado"));

		// Crear el objeto empleado para asignar los valores
		Empleado empleado = new Empleado();

		empleado.setNombre(e.getNombre());
		empleado.setEdad(e.getEdad());
		empleado.setFecha_alta(e.getFecha_alta());
		empleado.setFecha_baja(e.getFecha_baja());
		empleado.setSalario(e.getSalario());

		// Asigno el departamento al empleado
		empleado.setDepartamento(departamento);

		// Guardamos el empleado en BBDD
		return empleadoRepository.save(empleado);
	}

	// Método para BORRAR un empleado
	public void deleteEmpleadoById(Long idEmpleado) {
		empleadoRepository.deleteById(idEmpleado);
	}

	// Método para ACTUALIZAR un empleado
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
		empleado.setFecha_alta(e.getFecha_alta());
		empleado.setFecha_baja(e.getFecha_baja());
		empleado.setSalario(e.getSalario());

		// Asignamos el departamento al empleado
		empleado.setDepartamento(departamento);

		// Guardamos los cambios
		return empleadoRepository.save(empleado);
	}

	// Método para buscar empleados por nombre
	public List<Empleado> findByNombre(String nombre) {
		return empleadoRepository.findByNombre(nombre);
	}

	// Método para buscar empleados por edad
	public List<Empleado> findByEdad(int edad) {
		return empleadoRepository.findByEdad(edad);
	}

	// Método para buscar empleados con salario superior a una cantidad especificada
	public List<Empleado> findBySuperiorASalario(Long salario) {
		return empleadoRepository.findBySalarioGreaterThan(salario);
	}

	// Método para buscar empleados con salario inferior a una cantidad especificada
	public List<Empleado> findByInferiorASalario(Long salario) {
		return empleadoRepository.findBySalarioLessThan(salario);
	}

	// Método para buscar empleados con salarios en un rango específico
	public List<Empleado> findByEntreSalarios(Long salarioMin, Long salarioMax) {
		return empleadoRepository.findBySalarioBetween(salarioMin, salarioMax);
	}

}
