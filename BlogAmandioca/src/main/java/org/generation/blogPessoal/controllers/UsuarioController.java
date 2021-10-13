package org.generation.blogPessoal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.models.Usuario;
import org.generation.blogPessoal.repositories.UsuarioRepository;
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
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	private @Autowired UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> getById(@PathVariable(value = "id_usuario") Long id_usuario) {
		return repository.findById(id_usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.noContent().build());
	}

	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Usuario>> getByUsuario(@PathVariable(value = "usuario") String nome) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}

	@GetMapping("/usuario/{email}")
	public ResponseEntity<List<Usuario>> getByEmail(@PathVariable(value = "email") String email) {
		return ResponseEntity.ok(repository.findByEmail(email));
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(novoUsuario));
	}

	@DeleteMapping("/{id_usuario}")
	public void delete(@PathVariable(value = "id_usuario") Long id_tema) {
		repository.deleteById(id_tema);
	}
}
