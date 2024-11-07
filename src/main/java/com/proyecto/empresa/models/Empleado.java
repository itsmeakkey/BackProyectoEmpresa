package com.proyecto.empresa.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Cada campo añadido es una columna en BBDD
@Table(name = "empleado")
public class Empleado extends TrabajadorEmpresa {

	public Empleado(String nombre, Integer edad, Date fecha_alta, Date fecha_baja, Long salario) {
		super(nombre, edad, fecha_alta, fecha_baja, salario);

	}

	// Relación muchos a uno con Departamento
	@ManyToOne
	@JoinColumn(name = "departamento_id") // Clave foránea en la tabla empleado
	private Departamento departamento;

	// Relación uno a muchos con Tareas
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tarea> tareas;

	// Métodos especificos para empleado
}