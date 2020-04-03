package com.diego.proyectoFinal.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diego.proyectoFinal.empleado.Empleado;
import com.diego.proyectoFinal.empleado.EmpleadoDAO;


@Service
public class Autenticacion implements UserDetailsService{
	
	@Autowired
	private EmpleadoDAO empleadoDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Empleado> user = empleadoDAO.findById(username);
		
		if(user.isPresent()) {
			return user.get();
		}
		else throw new UsernameNotFoundException("" + username);
	}

	
}
