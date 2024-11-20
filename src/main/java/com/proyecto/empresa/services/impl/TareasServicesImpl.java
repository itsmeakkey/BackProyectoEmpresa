package com.proyecto.empresa.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.proyecto.empresa.mappers.TareaMapper;
import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.repositories.TareasRepository;
import com.proyecto.empresa.services.TareasServices;
import com.proyecto.empresa.to.TareaTO;

public class TareasServicesImpl implements TareasServices {

	// No se necesita Autowired porque manejamos las inyecciones con beans desde
	// AppConfig
	private final TareasRepository tareasRepository;
	private final EmpleadoRepository empleadoRepository;
	private final TareaMapper tareaMapper;
	public TareasServicesImpl(TareasRepository tareasRepository, EmpleadoRepository empleadoRepository, TareaMapper tareaMapper) {
		this.tareasRepository = tareasRepository;
		this.empleadoRepository = empleadoRepository;
		this.tareaMapper = tareaMapper;
	}

	// MÉTODOS COMUNES
	// Obtiene todas las tareas
	@Override
	public List<Tarea> getAll() {
		return tareasRepository.findAll();
	}

	// Busca tarea por ID
	@Override
	public Optional<Tarea> findById(Long id) {
		return tareasRepository.findById(id);
	}

	// MÉTODOS PROPIO
	// CREAR una nueva tarea
	@Override
	public Tarea createTarea(TareaTO t) {
	    // Buscamos el empleado por Id
	    Empleado empleado = empleadoRepository.findById(t.getEmpleadoTO().getId())
	            .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
	 
	    // Hacemos la conversion inversa
	    Tarea tarea = tareaMapper.convertirDeTareaTO(t);
	 
	    // Asignamos el empleado a la tarea
	    tarea.setEmpleado(empleado);
	 
	    // Guardamos la tarea en la base de datos
	    return tareasRepository.save(tarea);
	}

	// ACTUALIZAR una tarea
	@Override
	public Tarea updateTarea(Long id, TareaTO t) {
		// Buscamos la tarea que queremos actualizar
		Tarea tarea = tareasRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

		// Buscamos el empleado asignado
		Empleado empleado = empleadoRepository.findById(t.getEmpleadoTO().getId())
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		// Asignamos los valores
		tarea.setNombreTarea(t.getNombreTarea());
		tarea.setFechaCreacion(t.getFechaCreacion());
		tarea.setFechaFin(t.getFechaFin());
		tarea.setEntregadoATiempo(t.getEntregadoATiempo());
		tarea.setFechaEstimada(t.getFechaEstimada());
		// Asignamos el nuevo empleado
		tarea.setEmpleado(empleado);

		// Guardamos los cambios
		return tareasRepository.save(tarea);
	}

	// BORRAR una tarea
	@Override
	public void deleteTareaById(Long idTarea) {
		tareasRepository.deleteById(idTarea);
	}

	// Busca tareas asignadas a un empleado específico
	@Override
	public List<Tarea> findByEmpleadoId(Long empleadoId) {
		return tareasRepository.findByEmpleadoId(empleadoId);
	}

	// Busca tareas entregadas a tiempo
	@Override
	public List<Tarea> findByEntregaATiempo() {
		return tareasRepository.findByEntregadoATiempoTrue();
	}

	// Busca tareas entregadas fuera de tiempo
	@Override
	public List<Tarea> findByEntregaADestiempo() {
		return tareasRepository.findByEntregadoATiempoFalse();
	}

	// Busca tareas no finalizadas (fecha de fin es null)
	@Override
	public List<Tarea> findByNotFinished() {
		return tareasRepository.findByFechaFinIsNull();
	}

	// Busca tareas creadas después de una fecha específica
	@Override
	public List<Tarea> findByFechaCreacion(Date fecha) {
		return tareasRepository.findByFechaCreacionAfter(fecha);
	}

	// Busca tareas creadas antes de una fecha específica
	@Override
	public List<Tarea> findByFechaAnteriorCreacion(Date fecha) {
		return tareasRepository.findByFechaCreacionBefore(fecha);
	}

	// Busca tareas creadas entre dos fechas específicas
	@Override
	public List<Tarea> findByFechaEntreCreacion(Date fechaInicio, Date fechaFin) {
		return tareasRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
	}

}