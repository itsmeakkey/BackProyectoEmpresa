package com.proyecto.empresa.to;

import java.util.List;

public class DepartamentoTO {
	private Long id;
	private String nombre;
	//TODO Este jefe debe ser JEFETO
	private JefeTO jefeTO;
	private List<EmpleadoTO> empleados;

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

	public JefeTO getJefeTO() {
		return jefeTO;
	}

	public void setJefeTO(JefeTO jefeTO) {
		this.jefeTO = jefeTO;
	}

	public List<EmpleadoTO> getEmpleadosTO() {
		return empleados;
	}

	public void setEmpleados(List<EmpleadoTO> empleados) {
		this.empleados = empleados;
	}


}
