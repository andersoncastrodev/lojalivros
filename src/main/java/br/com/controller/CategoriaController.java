package br.com.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.domian.Categoria;
import br.com.dtos.CategoriaDTO;
import br.com.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> finById(@PathVariable Integer id) {
		
		Categoria categoria = categoriaService.findById(id);
		
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> finAll(){
		
		List<Categoria> categoriaList = categoriaService.findAll();
		
		List<CategoriaDTO> categoriaListDTO = categoriaList.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(categoriaListDTO);
	}

}
