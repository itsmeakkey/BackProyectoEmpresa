package com.proyecto.empresa.to;

import java.util.Date;

public class TareaTO{
	private Long id;
    private String nombreTarea;
    private Date fechaCreacion;
    private Date fechaFin;
    private Boolean entregadoATiempo;
    private Date fechaEstimada;
    //TODO ESTE CAMPO DEBE SER TO
    private EmpleadoTO empleadoTO;
    
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
	public EmpleadoTO getEmpleadoTO() {
		return empleadoTO;
	}
	public void setEmpleadoTO(EmpleadoTO empleadoTO) {
		this.empleadoTO = empleadoTO;
	}
	
}
