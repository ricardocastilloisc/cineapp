package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@GetMapping("/create")
	public String crear() 
	{
		return "peliculas/formPelicula";
	}
}
