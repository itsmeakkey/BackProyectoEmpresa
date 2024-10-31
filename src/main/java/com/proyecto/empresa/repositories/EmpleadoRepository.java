package com.proyecto.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.empresa.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
