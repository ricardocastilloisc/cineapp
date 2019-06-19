package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import net.itinajero.app.model.*;
import net.itinajero.app.service.*;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {

	@Autowired
	private IBannersService serviceBanners;

	@Autowired
	private IPeliculasService servicePeliculas;

	@Autowired
	private IHorariosService serviceHorarios;

	@Autowired
	private INoticiasService serviceNoticias;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {		
		try {			
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			List<String> listaFechas = Utileria.getNextDays(4);
			List<Pelicula> peliculas  = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);			
			// Regresamos la fecha que selecciono el usuario con el mismo formato
			model.addAttribute("fechaBusqueda",dateFormat.format(fecha));			
			model.addAttribute("peliculas", peliculas);			
			return "home";
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println(listaFechas);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		// peliculas.add("Rapido y furiosos");
		// peliculas.add("El aro 2");
		// peliculas.add("Aliens");
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha) {
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios", horarios);
		model.addAttribute("fechaBusqueda", dateFormat.format(fecha));
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@ModelAttribute("noticias")
	public List<Noticia> getNoticias() {
		return serviceNoticias.buscarUltimas();
	}

	@ModelAttribute("banners")
	public List<Banner> getBanners() {
		return serviceBanners.buscarActivos();
	}
	
	@RequestMapping(value = "/about")
	public String mostrarAcerca() {			
		return "acerca";
	}
}
