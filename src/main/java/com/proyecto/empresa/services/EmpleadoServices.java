package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.to.EmpleadoTO;

public interface EmpleadoServices {
	List<Empleado> getAll();

	Optional<Empleado> findById(Long id);

	Empleado createEmpleado(EmpleadoTO e);

	void deleteEmpleadoById(Long idEmpleado);

	Empleado updateEmpleado(Long id, EmpleadoTO e);

	List<Empleado> findByNombre(String nombre);

	List<Empleado> findByEdad(int edad);

	List<Empleado> findBySuperiorASalario(Long salario);

	List<Empleado> findByInferiorASalario(Long salario);

	List<Empleado> findByEntreSalarios(Long salarioMin, Long salarioMax);
}
