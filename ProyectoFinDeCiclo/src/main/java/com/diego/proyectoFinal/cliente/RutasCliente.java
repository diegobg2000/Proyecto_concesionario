package com.diego.proyectoFinal.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RutasCliente {
	//INYECCIONES
	@Autowired
	private ClienteDAO clienteDAO;
	

	
	//RUTAS
	@GetMapping("/clientes")
	public ModelAndView mostrarClientes() {
		ModelAndView nav = new ModelAndView();
		nav.setViewName("clientes");
		
		nav.addObject("cliente", new Cliente());
		
		List<Cliente> listaClientes = (List<Cliente>)clienteDAO.findAll();
		nav.addObject("clientes",listaClientes);
		
		
		return nav;
	}
	
	/*Añadir*/
	@PostMapping("/clientes/anadir")
	public String anadirCliente(@ModelAttribute Cliente cliente) {
	
	clienteDAO.save(cliente);
	
	return "redirect:/clientes";
	}
	
	//Eliminar
	@GetMapping("/clientes/eliminar/{id}")
	public String eliminarCliente(@PathVariable long id) {
		
		clienteDAO.deleteById(id);
	
		return "redirect:/clientes";
	}

}
