package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.domian.Categoria;
import br.com.dtos.CategoriaDTO;
import br.com.repository.CategoriaRepository;
import br.com.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {	
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		return categoria.orElseThrow( () ->new ObjectNotFoundException("Objeto não encontrado! Id:"+ id +",Tipo: "+ Categoria.class.getName()) );
	}

	/*
	 * Carrega todas as categorias
	 */
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	/*
	 * Salvando as alterações
	 */
	public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
		Categoria categoriaObj = findById(id);
		categoriaObj.setNome(categoriaDTO.getNome());
		categoriaObj.setDescricao(categoriaDTO.getDescricao());
		return categoriaRepository.save(categoriaObj);
	}
	
}
