package com.proyecto.empresa.services;
 
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.repositories.TareasRepository;
 

public class TareasServices {
 
	//No se necesita Autowired porque manejamos las inyecciones con beans desde AppConfig
    private final TareasRepository tareasRepository;
    public TareasServices(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }
 
    // Obtiene todas las tareas
    public List<Tarea> getAll() {
        return tareasRepository.findAll();
    }
 
    // Busca tarea por ID
    public Optional<Tarea> findById(Long id) {
        return tareasRepository.findById(id);
    }
 
    // Guarda o actualiza una tarea
    public Tarea save(Tarea tarea) {
        return tareasRepository.save(tarea);
    }
 
    // Elimina una tarea por ID
    public void delete(Long id) {
        tareasRepository.deleteById(id);
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
}