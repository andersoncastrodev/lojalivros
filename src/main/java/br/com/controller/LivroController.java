package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.domian.Livro;
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
}
