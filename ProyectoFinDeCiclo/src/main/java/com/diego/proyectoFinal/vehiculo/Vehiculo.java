package com.diego.proyectoFinal.vehiculo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.diego.proyectoFinal.cliente.Cliente;

@Entity
@Table(name="vehiculos")
public class Vehiculo {

	@Id
	@Column
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idVehiculo;
	
	@Column
	private String modelo;
	
	@Column
	private boolean automatico;
	
	@Column
	private String matricula;
	
	@Column
	private String llantas;
	
	@Column
	private int cilindrada;
	
	@Column
	private int caballos;
	
	@Column
	private String color;
	
	@Column
	private boolean vendido;


	/*RELACION ENTRE TABLAS*/
	@ManyToOne(fetch=FetchType.EAGER, optional=true)
	private Cliente cliente = new Cliente();
	
	
	
	/*GETTERS & SETTERS*/

	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getLlantas() {
		return llantas;
	}

	public void setLlantas(String llantas) {
		this.llantas = llantas;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCaballos() {
		return caballos;
	}

	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}
	
	
	
	
	
}
