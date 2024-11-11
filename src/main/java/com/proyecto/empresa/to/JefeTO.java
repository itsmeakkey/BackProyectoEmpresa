package com.proyecto.empresa.to;

import java.util.Date;
import java.util.List;

import com.proyecto.empresa.models.Departamento;

public class JefeTO extends TrabajadorEmpresaTO {
	//TODO ESTOS CAMPOS DEBEN SER TO
	private Date fechaJefe;
	private List<Departamento> departamentos;
	
	public Date getFechaJefe() {
		return fechaJefe;
	}
	public void setFechaJefe(Date fechaJefe) {
		this.fechaJefe = fechaJefe;
	}
	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
