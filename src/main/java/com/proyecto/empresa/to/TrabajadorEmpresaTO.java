package com.proyecto.empresa.to;

import java.util.Date;

public class TrabajadorEmpresaTO {
	protected Long id;
	protected String nombre;
	protected Integer edad;
	protected Date fecha_alta;
	protected Date fecha_baja;
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
	
	public Date getFecha_alta() {
		return fecha_alta;
	}
	
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	
	public Date getFecha_baja() {
		return fecha_baja;
	}
	
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}
	
	public Long getSalario() {
		return salario;
	}
	
	public void setSalario(Long salario) {
		this.salario = salario;
	}

}
