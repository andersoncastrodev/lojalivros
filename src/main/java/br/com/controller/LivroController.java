package br.com.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.domian.Livro;
import br.com.dtos.LivroDTO;
import br.com.service.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/livros")
public class LivroController {


	@Autowired
	private LivroService livroservice;
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		
		Livro livroObj = livroservice.findById(id);
		
		return ResponseEntity.ok().body(livroObj);
	}
	
	@GetMapping()
	public ResponseEntity<List< LivroDTO>> findAll(@RequestParam(value ="categoria", defaultValue = "0") Integer id_cat ){
		List<Livro> livroList = livroservice.findAll(id_cat);
		List<LivroDTO> listDTO = livroList.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		//localhost:8080/livros/?categoria=1
	}
	
	/*
	 * Put = Aqui altera Tudo que foi atualizado.
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livro){	
		
		Livro livroObj = livroservice.update(id, livro);
		
		return ResponseEntity.ok().body(livroObj);
	}
	
	/*
	 * Patch = Atualizar apenas o campo que foi alterado.
	 */
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id,@Valid @RequestBody Livro livro){	
		
		Livro livroObj = livroservice.update(id, livro);
		
		return ResponseEntity.ok().body(livroObj);
	}
	
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0" ) Integer id_cat,@Valid @RequestBody Livro livro){
		
		Livro livroObj = livroservice.create(id_cat,livro);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(livroObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		 livroservice.delete(id);
		 return ResponseEntity.noContent().build();
	}

}
