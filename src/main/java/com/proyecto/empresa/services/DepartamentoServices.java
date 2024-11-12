package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.to.DepartamentoTO;

public interface DepartamentoServices {
	List<Departamento> getAllDepartamentos();
	Optional<Departamento> findById(Long id);
	
	Departamento createDepartamento(DepartamentoTO d);
	void deleteDepartamentoById(Long id);
	Departamento updateDepartamento(Long id, DepartamentoTO d);
}
