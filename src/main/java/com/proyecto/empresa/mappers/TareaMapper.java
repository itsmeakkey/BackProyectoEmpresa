package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.empresa.models.Tarea;
import com.proyecto.empresa.to.TareaTO;

@Mapper
public interface TareaMapper {

	// Método para convertir Tarea a TareaTO
	TareaTO convertirATareaTO(Tarea tareao);

	// Método para convetir de Tarea a una lista de TareaTO
	List<TareaTO> convertirListaATareaTO(List<Tarea> tarea);

}
