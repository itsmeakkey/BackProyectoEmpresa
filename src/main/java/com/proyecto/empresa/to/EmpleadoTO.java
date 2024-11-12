package com.proyecto.empresa.to;

import java.util.List;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.models.Tarea;

public class EmpleadoTO extends TrabajadorEmpresaTO {
	//TODO ESTO DEBE SER TO
	private DepartamentoTO departamentoTO;
	private List<TareaTO> tareasTO;
	
	
	public DepartamentoTO getDepartamentoTO() {
		return departamentoTO;
	}
	public void setDepartamentoTO(DepartamentoTO departamentoTO) {
		this.departamentoTO = departamentoTO;
	}
	public List<TareaTO> getTareasTO() {
		return tareasTO;
	}
	public void setTareasTO(List<TareaTO> tareasTO) {
		this.tareasTO = tareasTO;
	}

	
}
