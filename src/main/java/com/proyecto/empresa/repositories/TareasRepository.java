package com.proyecto.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.empresa.models.Tarea;
import java.util.Date;
import java.util.List;

public interface TareasRepository extends JpaRepository<Tarea, Long> {

	/*
	 * Métodos comunes en todas las clases: getAll(): obtiene todos los registros.
	 * findById(): busca por ID
	 */

	//Busca tareas asignadas a un empleado específico
	List<Tarea> findByEmpleadoId(Long empleadoId);

	//Busca tareas entregadas a tiempo
	List<Tarea> findByEntregadoATiempoTrue();

	//Busca tareas entregadas fuera de tiempo
	List<Tarea> findByEntregadoATiempoFalse();

	//Busca tareas no finalizadas (donde fecha_fin es null)
	List<Tarea> findByFechaFinIsNull();

	//Busca tareas creadas después de una fecha específica
	List<Tarea> findByFechaCreacionAfter(Date fecha);

	//Busca tareas creadas antes de una fecha específica
	List<Tarea> findByFechaCreacionBefore(Date fecha);

	//Busca tareas creadas entre dos fechas específicas
	List<Tarea> findByFechaCreacionBetween(Date fechaInicio, Date fechaFin);

}