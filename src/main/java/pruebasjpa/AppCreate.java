package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {

		Noticia noticia = new Noticia();
		
		noticia.setTitulo("Proximo Estreno: Juego Macabro");
		noticia.setDetalle("el mes de septiembre se estrena");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		repo.save(noticia);
		context.close();

	}

}
