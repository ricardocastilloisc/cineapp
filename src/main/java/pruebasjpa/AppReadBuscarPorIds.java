package pruebasjpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppReadBuscarPorIds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

		List<Integer> ids = new LinkedList<Integer>();
		ids.add(8);
		ids.add(5);

		Iterable<Noticia> it = repo.findAllById(ids);
		for (Noticia n : it) {
			System.out.println(n);
		}
		context.close();

	}

}
