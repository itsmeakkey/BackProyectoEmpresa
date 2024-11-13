package com.proyecto.empresa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.proyecto.empresa.models.TrabajadorEmpresa;

//Al ser una interfaz genérica de la que heredan otras interfaces específicas, marcamos TrabajadorRepository con @NoRepositoryBean
@NoRepositoryBean
public interface TrabajadorRepository<T extends TrabajadorEmpresa> extends JpaRepository<T, Long> {
	List<T> findByNombre(String nombre);

	List<T> findByEdad(Integer edad);

	List<T> findBySalarioGreaterThan(Long salario);

	List<T> findBySalarioLessThan(Long salario);

	List<T> findBySalarioBetween(Long salarioMin, Long salarioMax);
}
