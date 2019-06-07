package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	//Metodo para generar una lista de Objetos de Modelo (Pelicula)
	private List<Pelicula> getLista()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista  = null;
		try {
			lista = new LinkedList<>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			pelicula1.setEstatus("inactivo");
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la best�a");
			pelicula2.setDuracion(132);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula2.setImagen("bella.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
			pelicula3.setImagen("contratiempo.png");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			
			return lista;
		} catch (Exception e) {
			// TODO: handle exception}
			System.out.println("Error: "+ e.getMessage());
			return null;
		}
		
	}
	@RequestMapping(value="/",  method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) 
	{
		List<Pelicula> peliculas = getLista();
		//peliculas.add("Rapido y furiosos");
		//peliculas.add("El aro 2");
		//peliculas.add("Aliens");
		model.addAttribute("peliculas", peliculas);
		return "home";
	}
	
	@RequestMapping(value="/detail/{id}",  method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula) 
	{
		System.out.println("idPelicula: " + idPelicula);
		String tituloPelicula  = "Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
}
