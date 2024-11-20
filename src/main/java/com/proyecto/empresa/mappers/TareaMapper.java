package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.to.JefeTO;
import com.proyecto.empresa.to.TareaTO;

@Mapper(uses = { EmpleadoMapper.class })
public interface TareaMapper {
	@Mapping(source = "empleado", target = "empleadoTO")

	// Convertimos Tarea a TareaTo
	TareaTO convertirATareaTO(Tarea tareao);

	// Convertimos Lista a ListaTo
	List<TareaTO> convertirListaATareaTO(List<Tarea> tarea);
	
	 // Mapeo inverso para las fechas
    Tarea convertirDeTareaTO(TareaTO tareaTO);

}
