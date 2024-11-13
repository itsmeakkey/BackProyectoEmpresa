package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.to.EmpleadoTO;
@Mapper
public interface EmpleadoMapper {
	
	//Método para convertir Empleado a EmpleadoTO
	EmpleadoTO convertirAEmpleadoTO(Empleado empleado);
	
	//Método para convetir de Empleado a una lista de EmpleadoTO
	List<EmpleadoTO> convertirListaAEmpleadoTO(List<Empleado> empleado);	

}
	