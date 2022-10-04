package br.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.domian.Categoria;
import br.com.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {	
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElse(null);
	}
	/*
	 * 	public Optional<Categoria> findById(Integer id) {	
		Optional<Categoria> categoria = categoriaRepository.findById(id);
	  
		if(categoria != null) {
			return categoria;
		}
		return null;
	}
	 */
}
