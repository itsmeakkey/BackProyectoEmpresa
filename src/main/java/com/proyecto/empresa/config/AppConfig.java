package com.proyecto.empresa.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.empresa.mappers.DepartamentoMapper;
import com.proyecto.empresa.mappers.EmpleadoMapper;
import com.proyecto.empresa.mappers.JefeMapper;
import com.proyecto.empresa.mappers.TareaMapper;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.repositories.TareasRepository;
import com.proyecto.empresa.services.DepartamentoServices;
import com.proyecto.empresa.services.EmpleadoServices;
import com.proyecto.empresa.services.JefeServices;
import com.proyecto.empresa.services.TareasServices;
import com.proyecto.empresa.services.impl.DepartamentoServicesImpl;
import com.proyecto.empresa.services.impl.EmpleadoServicesImpl;
import com.proyecto.empresa.services.impl.JefeServicesImpl;
import com.proyecto.empresa.services.impl.TareasServicesImpl;

@Configuration
public class AppConfig {

	// Inyección de dependencias de repositories a ServicesImpl

	@Bean
	public DepartamentoServices departamentoServices(DepartamentoRepository departamentoRepository,
			JefeRepository jefeRepository) {
		return new DepartamentoServicesImpl(departamentoRepository, jefeRepository);
	}

	@Bean
	public EmpleadoServices empleadoServices(EmpleadoRepository empleadoRepository,
			DepartamentoRepository departamentoRepository) {
		return new EmpleadoServicesImpl(empleadoRepository, departamentoRepository);
	}

	@Bean
	public JefeServices jefeServices(JefeRepository jefeRepository) {
		return new JefeServicesImpl(jefeRepository);
	}

	@Bean
	public TareasServices tareasServices(TareasRepository tareasRepository, EmpleadoRepository empleadoRepository) {
		return new TareasServicesImpl(tareasRepository, empleadoRepository);
	}

	// Inyección de Mappers
	@Bean
	public DepartamentoMapper departamentoMapper() {
		return Mappers.getMapper(DepartamentoMapper.class);
	}

	@Bean
	public EmpleadoMapper empleadoMapper() {
		return Mappers.getMapper(EmpleadoMapper.class);
	}

	@Bean
	public JefeMapper jefeMapper() {
		return Mappers.getMapper(JefeMapper.class);
	}

	@Bean
	public TareaMapper tareaMapper() {
		return Mappers.getMapper(TareaMapper.class);
	}
}
