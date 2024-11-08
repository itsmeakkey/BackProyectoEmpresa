package com.proyecto.empresa.to;

import java.util.Date;

import com.proyecto.empresa.models.Empleado;

public class TareaTO{
	private Long id;
    private String nombreTarea;
    private Date fechaCreacion;
    private Date fechaFin;
    private Boolean entregadoATiempo;
    private Date fechaEstimada;
    private Empleado empleado;
    
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
