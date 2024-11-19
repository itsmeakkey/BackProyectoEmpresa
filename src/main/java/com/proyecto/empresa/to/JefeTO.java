package com.proyecto.empresa.to;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JefeTO extends TrabajadorEmpresaTO {
	// ESTOS CAMPOS DEBEN SER TO
	
	//Convierte a un formato compatible con el datepicker del front
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaJefe;
	private List<DepartamentoTO> departamentosTO;

	public Date getFechaJefe() {
		return fechaJefe;
	}

	public void setFechaJefe(Date fechaJefe) {
		this.fechaJefe = fechaJefe;
	}

	public List<DepartamentoTO> getDepartamentosTO() {
		return departamentosTO;
	}

	public void setDepartamentosTO(List<DepartamentoTO> departamentosTO) {
		this.departamentosTO = departamentosTO;
	}

}
