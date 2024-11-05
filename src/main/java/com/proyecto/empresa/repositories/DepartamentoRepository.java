package com.proyecto.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.empresa.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	/*
	 * Métodos comunes en todas las clases: getAll(): obtiene todos los registros.
	 * findById(): busca por ID
	 */

	// No hay métodos adicionales solo FindByID de JpaRepo

}
