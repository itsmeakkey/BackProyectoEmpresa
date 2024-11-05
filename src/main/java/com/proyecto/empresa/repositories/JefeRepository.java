package com.proyecto.empresa.repositories;

import org.springframework.stereotype.Repository;

import com.proyecto.empresa.models.Jefe;

@Repository
public interface JefeRepository extends TrabajadorRepository<Jefe> {
    // Aquí solo defines métodos específicos de Empleado si los hay
}
