package br.com.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.domian.Categoria;
import br.com.domian.Livro;
import br.com.repository.CategoriaRepository;
import br.com.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void baseDados(){
		
		Categoria categoria = new Categoria(null, "Informatica", "Livros de TI");
		Categoria categoria1 = new Categoria(null, "Ficção Cientifica", "Livros de Ficção");
		Categoria categoria2 = new Categoria(null, "Biografias", "Livros Biografias");
		
		
		Livro livro = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", categoria);
		Livro livro1 = new Livro(null, "Matriz", "Lana Wachowski", "Baseado no filme", categoria1);
		Livro livro2 = new Livro(null, "Relatividade", "Albert Einstein", "Teoria", categoria2);
		
	    Livro livro3 = new Livro(null, "Banco de Dados", "Editar LS", "ORM", categoria);
		Livro livro4 = new Livro(null, "Predador", "John McTiernan", "Filme", categoria2);
		Livro livro5 = new Livro(null, "Matriz 2", "Lana Wachowski", "Baseado no filme", categoria1);
		
		
		categoria.getLivros().addAll( Arrays.asList(livro,livro3 ) );
		
		categoria1.getLivros().addAll(Arrays.asList(livro1,livro5,livro4) );
		
		categoria2.getLivros().addAll(Arrays.asList(livro2) );
		
		categoriaRepository.saveAll( Arrays.asList(categoria, categoria1, categoria2) );
		
		livroRepository.saveAll( Arrays.asList(livro, livro1, livro2, livro3, livro4, livro5 ) );
	}
}
