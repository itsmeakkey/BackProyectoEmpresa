package com.proyecto.empresa.to;

import java.util.List;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.models.Jefe;

public class DepartamentoTO {
	private Long id;
	private String nombre;
	private Jefe jefe;
	private List<Empleado> empleados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Jefe getJefe() {
		return jefe;
	}

	public void setJefe(Jefe jefe) {
		this.jefe = jefe;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
