package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.domian.Livro;
import br.com.repository.LivroRepository;
import br.com.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
	
		Optional<Livro> livro = livroRepository.findById(id);
	
		return livro.orElseThrow( () ->new ObjectNotFoundException("Objeto não encontrado! Id:"+ id +",Tipo: "+ Livro.class.getName()) );
	}

	public List<Livro> findAll(Integer id_cat) {
		
		categoriaService.findById(id_cat);	
		
		return livroRepository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro livro) {
		
		Livro livroObj = findById(id);
		
		livroObj.setTitulo(livro.getTitulo());
		livroObj.setNomeAutor(livro.getNomeAutor());
		livroObj.setTexto(livro.getTexto());
		
		return livroRepository.save(livroObj);
	}
	
	
}
