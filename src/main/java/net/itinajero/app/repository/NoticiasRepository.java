package net.itinajero.app.repository;

import org.springframework.data.repository.CrudRepository;

import net.itinajero.app.model.Noticia;

public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
