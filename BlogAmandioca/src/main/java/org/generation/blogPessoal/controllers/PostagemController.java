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

/**
 * @author Amanda
 * @version 1.0
 */
@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	private @Autowired PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<Postagem>> buscarTodas() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> buscarPorId(@PathVariable(value = "id_postagem") long id_postagem) {
		return repository.findById(id_postagem).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> buscarPorTitulo(@PathVariable(value = "titulo") String titulo) {
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> postar(@Valid @RequestBody Postagem novaPostagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novaPostagem));
	}

	@PutMapping
	public ResponseEntity<Postagem> atualizar(@Valid @RequestBody Postagem novaPostagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novaPostagem));
	}

	@DeleteMapping("/{id_postagem}")
	public void deletar(@PathVariable(value = "id_postagem") Long id_postagem) {
		repository.deleteById(id_postagem);
	}
}