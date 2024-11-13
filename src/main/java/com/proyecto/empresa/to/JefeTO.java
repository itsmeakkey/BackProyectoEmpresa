package com.proyecto.empresa.to;

import java.util.Date;
import java.util.List;

public class JefeTO extends TrabajadorEmpresaTO {
	// ESTOS CAMPOS DEBEN SER TO
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
