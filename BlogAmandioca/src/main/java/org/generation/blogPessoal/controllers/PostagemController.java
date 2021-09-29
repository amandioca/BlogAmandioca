package org.generation.blogPessoal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.models.Postagem;
import org.generation.blogPessoal.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	private @Autowired PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_postagem}") // vai usar o valor de "id"
	public ResponseEntity<Postagem> GetById(@PathVariable(value = "id_postagem") long idPostagem) {
		return repository.findById(idPostagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable(value = "titulo") String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> Post(@Valid @RequestBody Postagem novaPostagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novaPostagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> Put(@Valid @RequestBody Postagem novaPostagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novaPostagem));
	}

	@DeleteMapping("/{id_postagem}")
	public void Delete(@PathVariable(value = "id_postagem") long id_postagem) {
		repository.deleteById(id_postagem);
	}
}