package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.to.JefeTO;

@Mapper
public interface JefeMapper {

	// Convertimos Jefe a JefeTo
	JefeTO convertirAJefeTO(Jefe jefe);
	
    // Mapeo inverso para las fechas
    Jefe convertirDeJefeTO(JefeTO jefeTO);

	// Convertimos Lista a ListaTO
	List<JefeTO> convertirListaAJefeTO(List<Jefe> jefe);

}
