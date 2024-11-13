package com.proyecto.empresa.repositories;

import com.proyecto.empresa.models.Empleado;
import org.springframework.stereotype.Repository;

@Repository // Esta anotación ayuda a Spring a reconocerlo como repositorio concreto
public interface EmpleadoRepository extends TrabajadorRepository<Empleado> {

}
