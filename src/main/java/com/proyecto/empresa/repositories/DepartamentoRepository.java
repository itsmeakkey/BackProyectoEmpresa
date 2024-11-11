package com.proyecto.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.empresa.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
