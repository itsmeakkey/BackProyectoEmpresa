package com.proyecto.empresa.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import com.proyecto.empresa.models.Departamento;
import com.proyecto.empresa.to.DepartamentoTO;

@Mapper
public interface DepartamentoMapper {
    // Método para convertir Departamento a DepartamentoTO
    DepartamentoTO convertirADepartamentoTO(Departamento departamento);

    // Método para convertir una lista de Departamento a una lista de DepartamentoTO
    List<DepartamentoTO> convertirListaADepartamentoTO(List<Departamento> departamentos);
}
