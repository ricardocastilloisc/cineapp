package net.itinajero.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
	@Autowired
	private PeliculasRepository peliculasRepo;

	@Override
	public void insertar(Pelicula pelicula) {
		
		
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		// TODO Auto-generated method stub
		return null;
	}

}
