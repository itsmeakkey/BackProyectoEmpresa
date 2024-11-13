package com.proyecto.empresa.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Cada campo añadido es una columna en BBDD
@Table(name = "jefe")
public class Jefe extends TrabajadorEmpresa {
	
    //Constructor vacío para JPA
    public Jefe() {
    }

	private Date fechaJefe;

	public Jefe(String nombre, Integer edad, Date fechAlta, Date fechaBaja, Long salario) {
		super(nombre, edad, fechAlta, fechaBaja, salario);
		// TODO Auto-generated constructor stub
	}

	// Relación uno a muchos con Departamento
	@OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<Departamento> departamentos;
	
// Getters y Setters

	public Date getFechaJefe() {
		return fechaJefe;
	}

	public void setFechaJefe(Date fechaJefe) {
		this.fechaJefe = fechaJefe;
	}
}
