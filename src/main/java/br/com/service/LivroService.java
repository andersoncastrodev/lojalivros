package br.com.service;

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
	
	public Livro findById(Integer id) {
	
		Optional<Livro> livro = livroRepository.findById(id);
	
		return livro.orElseThrow( () ->new ObjectNotFoundException("Objeto não encontrado! Id:"+ id +",Tipo: "+ Livro.class.getName()) );
	}
}
