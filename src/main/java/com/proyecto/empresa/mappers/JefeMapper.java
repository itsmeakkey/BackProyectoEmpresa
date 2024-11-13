package com.proyecto.empresa.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyecto.empresa.models.Jefe;
import com.proyecto.empresa.to.JefeTO;

@Mapper
public interface JefeMapper {
	
	//Método para convetir Jefe a JefeTO
	JefeTO convertirAJefeTO(Jefe jefe);
	
	//Método para convetir Jefe a lista JefeTO
	List<JefeTO> convertirListaAJefeTO(List<Jefe> jefe);	

}
