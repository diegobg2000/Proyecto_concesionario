
package com.diego.proyectoFinal.empleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diego.proyectoFinal.Crypt.GeneradorCrypt;
import com.diego.proyectoFinal.rol.Rol;
import com.diego.proyectoFinal.rol.RolDAO;

@Controller
public class RutasEmpleado {
	//INYECCIONES
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Autowired
	private GeneradorCrypt generadorCrypt;
	
	/*RUTAS*/
	//Visualizar
	@GetMapping("/empleados")
	public ModelAndView mostrarEmpleados() {
		
		ModelAndView nav = new ModelAndView();
		
		nav.setViewName("empleados");
		
		nav.addObject("empleado", new Empleado());
		
		List<Empleado> listaEmpleados = (List<Empleado>)empleadoDAO.findAll();
		nav.addObject("empleados", listaEmpleados);	
		
		
		nav.addObject("rol", new Rol());
		
		List<Rol> listaRoles = (List<Rol>)rolDAO.findAll();
		nav.addObject("roles", listaRoles);
				
		return nav;
	}
	
	
	//Añadir Empleado
	@PostMapping("/empleados/anadir")
	public String anadirEmpleado(@ModelAttribute Empleado empleado) {
		
		empleado.setContrasena(generadorCrypt.encriptador().encode(empleado.getContrasena()));
		empleadoDAO.save(empleado);
		
		return "redirect:/empleados";
	}

	
	
	//Eliminar Empleado
	@GetMapping("/empleados/eliminar/{usuario}")
	public String eliminarEmpleado(@PathVariable String usuario) {
		
		empleadoDAO.deleteById(usuario);
		
		return "redirect:/empleados";	
	}
	

}
