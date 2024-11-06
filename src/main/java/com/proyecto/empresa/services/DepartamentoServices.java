package com.proyecto.empresa.services;
 
import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.repositories.DepartamentoRepository;

public class DepartamentoServices {
	
	//No se necesita Autowired porque manejamos las inyecciones con beans desde AppConfig
	private final DepartamentoRepository departamentoRepository;
	
	public DepartamentoServices(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
    //Obtener todos los departamentos
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }
 
    //Buscar un departamento por ID
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }
	
    //Crear un nuevo departamento
    public Departamento saveDepartamento(Departamento d) {
    	return departamentoRepository.save(d);
    }
}
