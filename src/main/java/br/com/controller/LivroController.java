package br.com.controller;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.domian.Livro;
import br.com.dtos.LivroDTO;
import br.com.service.LivroService;

@Controller
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
	

}
