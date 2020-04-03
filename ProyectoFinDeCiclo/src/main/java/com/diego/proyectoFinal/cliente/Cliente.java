package com.diego.proyectoFinal.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.diego.proyectoFinal.vehiculo.Vehiculo;

@Entity
@Table(name="clientes")
public class Cliente {

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idCliente;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column 
	private String telefono;
	
	@Column
	private String direccion;
	
	@Column
	private String dni;
	
	@Column 
	private String fechaNacimiento;


	/*RELACIONES ENTRE TABLAS*/
	@OneToMany(fetch=FetchType.EAGER,mappedBy = "cliente")
	private List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	
	 	
	
	/*GETTERS & SETTERS*/

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	


}
