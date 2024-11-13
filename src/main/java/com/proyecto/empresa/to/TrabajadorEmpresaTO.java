package com.proyecto.empresa.to;

import java.util.Date;

public class TrabajadorEmpresaTO {
	protected Long id;
	protected String nombre;
	protected Integer edad;
	protected Date fechaAlta;
	protected Date fechaBaja;
	protected Long salario;
	
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
	
	public void setFecha_alta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public Date getfechaBaja() {
		return fechaBaja;
	}
	
	public void setFecha_baja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	
	public Long getSalario() {
		return salario;
	}
	
	public void setSalario(Long salario) {
		this.salario = salario;
	}

}
