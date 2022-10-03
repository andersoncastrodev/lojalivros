package br.com;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.domian.Categoria;
import br.com.domian.Livro;
import br.com.repository.CategoriaRepository;
import br.com.repository.LivroRepository;

@SpringBootApplication
public class LojalivrosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@Autowired
	private LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(LojalivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria = new Categoria(null, "Informatica", "Livros de TI");
		
		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", categoria);
		
		categoria.getLivros().addAll( Arrays.asList(livro) );
		
		categoriaRepository.saveAll( Arrays.asList(categoria) );
		
		livroRepository.saveAll( Arrays.asList(livro) );
		
	}

}
