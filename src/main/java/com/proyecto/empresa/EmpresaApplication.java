package com.proyecto.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.proyecto.empresa.repositories")

public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}

}
