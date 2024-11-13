package com.proyecto.empresa.models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class TrabajadorEmpresa {
	@Id // Indica que este es el id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
	protected Long id;
	protected String nombre;
	protected Integer edad;
	protected Date fechaAlta;
	protected Date fechaBaja;
	protected Long salario;

	// Constructor vacío para JPA
	protected TrabajadorEmpresa() {
	}

	// Contructor clase Abstracta
	// No se debe pasar el id como parámetro en el constructor, ya que este campo se generará automáticamente
	public TrabajadorEmpresa(String nombre, Integer edad, Date fechaAlta, Date fechaBaja, Long salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.salario = salario;
	}

	// Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getfechaAlta() {
		return fechaAlta;
	}

	public void setfechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getfechaBaja() {
		return fechaBaja;
	}

	public void setfechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

}
