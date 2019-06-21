package net.itinajero.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="admin")
public class LoginController {
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request)
	{
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		return "redirect:/";
	}
}
