package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.to.DepartamentoTO;

@Mapper(uses = { JefeMapper.class })
public interface DepartamentoMapper {
	@Mapping(source = "jefe", target = "jefeTO")

	// Convertir un Dpto a un DptoTO
	DepartamentoTO convertirADepartamentoTO(Departamento departamento);

	// Convertir una Lista a una ListaTO
	List<DepartamentoTO> convertirListaADepartamentoTO(List<Departamento> departamentos);
}
