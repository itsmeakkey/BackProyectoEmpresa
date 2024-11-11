package com.proyecto.empresa.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.repositories.TareasRepository;
import com.proyecto.empresa.to.TareaTO;

public class TareasServices {

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final TareasRepository tareasRepository;
	private final EmpleadoRepository empleadoRepository;

	public TareasServices(TareasRepository tareasRepository, EmpleadoRepository empleadoRepository) {
		this.tareasRepository = tareasRepository;
		this.empleadoRepository = empleadoRepository;
	}

	// MÉTODOS COMUNES
	// Obtiene todas las tareas
	public List<Tarea> getAll() {
		return tareasRepository.findAll();
	}

	// Busca tarea por ID
	public Optional<Tarea> findById(Long id) {
		return tareasRepository.findById(id);
	}

	// MÉTODOS PROPIO
	// Crea una nueva tarea
	public Tarea createTarea(TareaTO t) {
		Empleado empleado = empleadoRepository.findById(t.getEmpleado().getId())
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
		t.setEmpleado(empleado);

		// Creamos la tarea recibiendo los valores de TareaTO
		Tarea tarea = new Tarea();
		tarea.setNombreTarea(t.getNombreTarea());
		tarea.setFechaCreacion(t.getFechaCreacion());
		tarea.setFechaFin(t.getFechaFin());
		tarea.setEntregadoATiempo(t.getEntregadoATiempo());
		tarea.setFechaEstimada(t.getFechaEstimada());

		// Asigna la tarea al empleado
		tarea.setEmpleado(empleado);

		// Guardamos la tarea en BBDD
		return tareasRepository.save(tarea);
	}

	// Busca tareas asignadas a un empleado específico
	public List<Tarea> findByEmpleadoId(Long empleadoId) {
		return tareasRepository.findByEmpleadoId(empleadoId);
	}

	// Busca tareas entregadas a tiempo
	public List<Tarea> findByEntregaATiempo() {
		return tareasRepository.findByEntregadoATiempoTrue();
	}

	// Busca tareas entregadas fuera de tiempo
	public List<Tarea> findByEntregaADestiempo() {
		return tareasRepository.findByEntregadoATiempoFalse();
	}

	// Busca tareas no finalizadas (fecha de fin es null)
	public List<Tarea> findByNotFinished() {
		return tareasRepository.findByFechaFinIsNull();
	}

	// Busca tareas creadas después de una fecha específica
	public List<Tarea> findByFechaCreacion(Date fecha) {
		return tareasRepository.findByFechaCreacionAfter(fecha);
	}

	// Busca tareas creadas antes de una fecha específica
	public List<Tarea> findByFechaAnteriorCreacion(Date fecha) {
		return tareasRepository.findByFechaCreacionBefore(fecha);
	}

	// Busca tareas creadas entre dos fechas específicas
	public List<Tarea> findByFechaEntreCreacion(Date fechaInicio, Date fechaFin) {
		return tareasRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
	}

	// Eliminar una tarea
	public void deleteTareaId(Long idTarea) {
		tareasRepository.deleteById(idTarea);
	}

}