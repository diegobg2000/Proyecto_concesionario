package com.diego.proyectoFinal.generico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasGenericas {
	
	@GetMapping("/")
	public String principal() {
		
		return "principal.html";
	}
	
	
	@GetMapping("/login")
	public String menulogin() {
		
		
		return "login.html";
	}
	

}
