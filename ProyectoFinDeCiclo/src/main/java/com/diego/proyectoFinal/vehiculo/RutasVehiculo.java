package com.diego.proyectoFinal.vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diego.proyectoFinal.cliente.Cliente;
import com.diego.proyectoFinal.cliente.ClienteDAO;

@Controller
public class RutasVehiculo {
	//INYECCIONES
	@Autowired
	private VehiculoDAO vehiculoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	//RUTAS
	@GetMapping("/vehiculos")
	public ModelAndView mostrarVehiculos() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vehiculo", new Vehiculo());
		
		List<Vehiculo> listaVehiculos = (List<Vehiculo>)vehiculoDAO.findAll();
		mav.addObject("vehiculos", listaVehiculos);
		
		mav.addObject("cliente", new Cliente());
		
		List<Cliente> listaClientes = (List<Cliente>)clienteDAO.findAll();
		mav.addObject("clientes", listaClientes);
		
		return mav;
	}
	
	
	
	
	@PostMapping("vehiculos/anadir")
	public String anadirVehiculo(@ModelAttribute Vehiculo vehiculo) {
		
		if(vehiculo.getCliente() == null) {
			vehiculo.setCliente(null);
		}
		
		vehiculoDAO.save(vehiculo);
		
		return "redirect:/vehiculos";
	}
	
	
	@GetMapping("/vehiculo/eliminar/{id}")
	public String eliminarVehiculo(@PathVariable long id) {
		
		vehiculoDAO.deleteById(id);
		
		return "redirect:/vehiculos";
	}
}
