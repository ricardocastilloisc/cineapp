package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.itinajero.app.model.Contacto;

@Controller
public class ContactoController {

	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto) 
	{
		return "formContacto";
	}
}
