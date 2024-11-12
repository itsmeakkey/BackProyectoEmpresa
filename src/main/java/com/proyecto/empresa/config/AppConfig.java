package com.proyecto.empresa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.empresa.repositories.EmpleadoRepository;
import com.proyecto.empresa.repositories.JefeRepository;
import com.proyecto.empresa.repositories.TareasRepository;
import com.proyecto.empresa.services.impl.DepartamentoServicesImpl;
import com.proyecto.empresa.services.impl.EmpleadoServicesImpl;
import com.proyecto.empresa.services.impl.JefeServicesImpl;
import com.proyecto.empresa.services.impl.TareasServicesImpl;
import com.proyecto.empresa.repositories.DepartamentoRepository;

@Configuration
public class AppConfig {
	
	//Inyección de dependencias de repositories a services
	
    @Bean
    public DepartamentoServicesImpl departamentoServices(DepartamentoRepository departamentoRepository, JefeRepository jefeRepository) {
        return new DepartamentoServicesImpl(departamentoRepository, jefeRepository);
    }

    @Bean
    public EmpleadoServicesImpl empleadoServices(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository) {
        return new EmpleadoServicesImpl(empleadoRepository, departamentoRepository);
    }

    @Bean
    public JefeServicesImpl jefeServices(JefeRepository jefeRepository) {
        return new JefeServicesImpl(jefeRepository);
    }

    @Bean
    public TareasServicesImpl tareasServices(TareasRepository tareasRepository, EmpleadoRepository empleadoRepository) {
        return new TareasServicesImpl(tareasRepository, empleadoRepository);
    }
}
