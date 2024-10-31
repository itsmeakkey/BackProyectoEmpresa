package com.proyecto.empresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.empresa.models.Tareas;

public interface TareasRepository extends JpaRepository<Tareas, Long> {

}
