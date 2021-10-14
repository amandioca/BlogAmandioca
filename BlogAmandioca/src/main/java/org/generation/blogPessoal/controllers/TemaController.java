package org.generation.blogPessoal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.models.Tema;
import org.generation.blogPessoal.repositories.TemaRepository;
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

/**
 * @author Amanda
 * @version 1.0
 */
@RestController
@RequestMapping("/temas")
@CrossOrigin("*")
public class TemaController {

	private @Autowired TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_tema}")
	public ResponseEntity<Tema> getById(@PathVariable(value = "id_tema") Long id_tema) {
		return repository.findById(id_tema).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Tema>> getByTema(@PathVariable(value = "tema") String tema) {
		return ResponseEntity.ok(repository.findByTemaContainingIgnoreCase(tema));
	}

	@PostMapping
	public ResponseEntity<Tema> post(@Valid @RequestBody Tema novoTema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoTema));
	}

	@PutMapping
	public ResponseEntity<Tema> put(@Valid @RequestBody Tema novoTema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoTema));
	}

	@DeleteMapping("/{id_tema}")
	public void delete(@PathVariable(value = "id_postagem") Long id_tema) {
		repository.deleteById(id_tema);
	}
}
