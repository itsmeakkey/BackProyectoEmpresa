package com.proyecto.empresa.services;
 
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.empresa.models.Tareas;
import com.proyecto.empresa.repositories.TareasRepository;
 
@Service
public class TareasServices {
 
    private final TareasRepository tareasRepository;
 
    @Autowired
    public TareasServices(TareasRepository tareasRepository) {
        this.tareasRepository = tareasRepository;
    }
 
    // Obtiene todas las tareas
    public List<Tareas> getAll() {
        return tareasRepository.findAll();
    }
 
    // Busca tarea por ID
    public Optional<Tareas> findById(Long id) {
        return tareasRepository.findById(id);
    }
 
    // Guarda o actualiza una tarea
    public Tareas save(Tareas tarea) {
        return tareasRepository.save(tarea);
    }
 
    // Elimina una tarea por ID
    public void delete(Long id) {
        tareasRepository.deleteById(id);
    }
 
    // Busca tareas asignadas a un empleado específico
    public List<Tareas> findByEmpleadoId(Long empleadoId) {
        return tareasRepository.findByEmpleadoId(empleadoId);
    }
 
    // Busca tareas entregadas a tiempo
    public List<Tareas> findByEntregaATiempo() {
        return tareasRepository.findByEntregadoATiempoTrue();
    }
 
    // Busca tareas entregadas fuera de tiempo
    public List<Tareas> findByEntregaADestiempo() {
        return tareasRepository.findByEntregadoATiempoFalse();
    }
 
    // Busca tareas no finalizadas (fecha de fin es null)
    public List<Tareas> findByNotFinished() {
        return tareasRepository.findByFechaFinIsNull();
    }
 
    // Busca tareas creadas después de una fecha específica
    public List<Tareas> findByFechaCreacion(Date fecha) {
        return tareasRepository.findByFechaCreacionAfter(fecha);
    }
 
    // Busca tareas creadas antes de una fecha específica
    public List<Tareas> findByFechaAnteriorCreacion(Date fecha) {
        return tareasRepository.findByFechaCreacionBefore(fecha);
    }
 
    // Busca tareas creadas entre dos fechas específicas
    public List<Tareas> findByFechaEntreCreacion(Date fechaInicio, Date fechaFin) {
        return tareasRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);
    }
}