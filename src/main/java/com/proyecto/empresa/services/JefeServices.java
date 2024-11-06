package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;
import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.repositories.JefeRepository;

public class JefeServices {
    private final JefeRepository jefeRepository;

	//No se necesita Autowired porque manejamos las inyecciones con beans desde AppConfig
    public JefeServices(JefeRepository jefeRepository) {
        this.jefeRepository = jefeRepository;
    }

    // Método para obtener todos los registros
    public List<Jefe> getAll() {
        return jefeRepository.findAll();
    }

    // Método para buscar por ID
    public Optional<Jefe> findById(Long id) {
        return jefeRepository.findById(id);
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

