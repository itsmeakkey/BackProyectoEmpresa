package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.empresa.models.Empleado;
import com.proyecto.empresa.to.EmpleadoTO;

@Mapper(uses = { DepartamentoMapper.class })
public interface EmpleadoMapper {

	@Mapping(source = "departamento", target = "departamentoTO")

	// Convertimos Empleado a EmpleadoTO
	EmpleadoTO convertirAEmpleadoTO(Empleado empleado);

	// Convertimos Lista a ListaTO
	List<EmpleadoTO> convertirListaAEmpleadoTO(List<Empleado> empleado);
	
	// Mapeo inverso para las fechas
	Empleado convertirDeEmpleadoTO(EmpleadoTO mpleadoTO);

}
