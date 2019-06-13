package pruebasjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		Page<Noticia> page = repo.findAll(PageRequest.of(1, 10));
		
		for(Noticia n: page) 
		{
			System.out.println(n);
		}
		context.close();

	}

}
