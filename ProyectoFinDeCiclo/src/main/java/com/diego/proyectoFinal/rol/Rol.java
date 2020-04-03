package com.diego.proyectoFinal.rol;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.diego.proyectoFinal.empleado.Empleado;

@Entity
@Table(name="roles")
public class Rol {

	@Id
	@Column
	private String nombre;
	
	/*RELACIONES ENTRE TABLAS*/
	@OneToMany(fetch=FetchType.EAGER,  mappedBy = "rol")
	private List<Empleado> listaEmpleados = new ArrayList<Empleado>();
	
	
	
	/*GETTERS & SETTERS*/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
	
	
}
