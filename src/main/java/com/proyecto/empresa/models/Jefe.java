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

	public Jefe(String nombre, Integer edad, Date fecha_alta, Date fecha_baja, Long salario) {
		super(nombre, edad, fecha_alta, fecha_baja, salario);
		// TODO Auto-generated constructor stub
	}

	// Relación uno a muchos con Departamento
	@OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<Departamento> departamentos;
	
// Getter y Setter

	public Date getFechaJefe() {
		return fechaJefe;
	}

	public void setFechaJefe(Date fechaJefe) {
		this.fechaJefe = fechaJefe;
	}

	// Métodos especificos de jefe
}
