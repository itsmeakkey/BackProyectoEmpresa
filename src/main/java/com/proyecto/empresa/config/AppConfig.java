package com.proyecto.empresa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.repositories.TareasRepository;
import com.proyecto.empresa.repositories.DepartamentoRepository;
import com.proyecto.empresa.services.EmpleadoServices;
import com.proyecto.empresa.services.JefeServices;
import com.proyecto.empresa.services.TareasServices;
import com.proyecto.empresa.services.DepartamentoServices;

@Configuration
public class AppConfig {
	
	//Inyección de dependencias de repositories a services
    @Bean
    public DepartamentoServices departamentoServices(DepartamentoRepository departamentoRepository, JefeRepository jefeRepository) {
        return new DepartamentoServices(departamentoRepository, jefeRepository);
    }

    @Bean
    public EmpleadoServices empleadoServices(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository) {
        return new EmpleadoServices(empleadoRepository, departamentoRepository);
    }

    @Bean
    public JefeServices jefeServices(JefeRepository jefeRepository) {
        return new JefeServices(jefeRepository);
    }

    @Bean
    public TareasServices tareasServices(TareasRepository tareasRepository, EmpleadoRepository empleadoRepository) {
        return new TareasServices(tareasRepository, empleadoRepository);
    }
}
