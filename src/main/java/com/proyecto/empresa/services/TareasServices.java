package com.proyecto.empresa.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.to.TareaTO;

public interface TareasServices {
	List<Tarea> getAll();
	Optional<Tarea> findById(Long id);
	
	Tarea createTarea(TareaTO t);
	Tarea updateTarea(Long id, TareaTO t);
	void deleteTareaById(Long idTarea);
	List<Tarea> findByEmpleadoId(Long empleadoId);
	List<Tarea> findByEntregaATiempo();
	List<Tarea> findByEntregaADestiempo();
	List<Tarea> findByNotFinished();
	List<Tarea> findByFechaCreacion(Date fecha);
	List<Tarea> findByFechaAnteriorCreacion(Date fecha);
	List<Tarea> findByFechaEntreCreacion(Date fechaInicio, Date fechaFin);

}
