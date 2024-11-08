package com.proyecto.empresa.models;
 
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "tarea") // Especifica el nombre de la tabla
public class Tarea {
	
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String nombreTarea;
 
    private Date fechaCreacion;
 
    private Date fechaFin;
 
    private Boolean entregadoATiempo;
 
    private Date fechaEstimada;
 
    // Relación muchos a uno con Empleado
    @ManyToOne
    @JoinColumn(name = "empleado_id") // Clave foránea
	@JsonIgnore //Evita que el departamento se serialice en el JSON del Empleado para que no haga un ciclo infinito
    private Empleado empleado;
 
    // Getters y Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNombreTarea() {
        return nombreTarea;
    }
 
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
 
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
 
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
 
    public Date getFechaFin() {
        return fechaFin;
    }
 
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
 
    public Boolean getEntregadoATiempo() {
        return entregadoATiempo;
    }
 
    public void setEntregadoATiempo(Boolean entregadoATiempo) {
        this.entregadoATiempo = entregadoATiempo;
    }
 
    public Date getFechaEstimada() {
        return fechaEstimada;
    }
 
    public void setFechaEstimada(Date fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }
 
    public Empleado getEmpleado() {
        return empleado;
    }
 
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}