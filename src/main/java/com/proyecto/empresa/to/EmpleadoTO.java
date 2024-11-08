package com.proyecto.empresa.to;

import java.util.List;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Tarea;

public class EmpleadoTO extends TrabajadorEmpresaTO {
	private Departamento departamento;
	private List<Tarea> tareas;

	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	
}
