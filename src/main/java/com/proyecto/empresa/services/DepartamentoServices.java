package com.proyecto.empresa.services;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoServices {
	
	
	private final DepartamentoRepository departamentoRepository;
	@Autowired
	public DepartamentoServices(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
    // Obtener todos los departamentos
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }
 
    // Buscar un departamento por ID
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }
	

}
