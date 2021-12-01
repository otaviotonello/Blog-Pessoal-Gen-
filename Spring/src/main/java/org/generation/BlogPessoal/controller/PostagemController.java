package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.generation.BlogPessoal.repository.postagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private postagemRepository repository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id2")
	public ResponseEntity<List<Postagem>> findById() {
		return ResponseEntity.ok(repository.findById(2l));
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<List<Postagem>> getByTitulo() {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase("API Rest Spring 2"));
	}
	
}
