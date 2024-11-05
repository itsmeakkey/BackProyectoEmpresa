package com.proyecto.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.repositories.EmpleadoRepository;

@Service
public class EmpleadoServices {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServices(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // Método para obtener todos los registros
    public List<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    // Método para buscar por ID
    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
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
