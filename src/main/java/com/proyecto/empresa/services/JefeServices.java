package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.to.JefeTO;

public interface JefeServices {
	List<Jefe> getAll();
	Optional<Jefe> findById(Long id);
	
	Jefe createJefe(JefeTO j);
	void deleteJefeById(Long idJefe);
	Jefe updateJefe(Long id, JefeTO j);
	List<Jefe> findByNombre(String nombre);
	List<Jefe> findByEdad(int edad);
	List<Jefe> findBySuperiorASalario(Long salario);
	List<Jefe> findByInferiorASalario(Long salario);
	List<Jefe> findByEntreSalarios(Long salarioMin, Long salarioMax);
}
