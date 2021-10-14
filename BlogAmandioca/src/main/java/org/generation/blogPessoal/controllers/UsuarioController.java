package org.generation.blogPessoal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.generation.blogPessoal.models.Usuario;
import org.generation.blogPessoal.models.dtos.CredenciaisDTO;
import org.generation.blogPessoal.models.dtos.UsuarioLoginDTO;
import org.generation.blogPessoal.repositories.UsuarioRepository;
import org.generation.blogPessoal.services.UsuarioService;
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
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Amanda
 * @version 1.0
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	private @Autowired UsuarioRepository repository;
	private @Autowired UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable (value = "id") Long idUsuario) {
		return repository.findById(idUsuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findByNomeContainingIgnoreCase(nome));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		return service.cadastrarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Email existente, cadastre outro email!.");
				});

	}

	@PutMapping("/login")
	public ResponseEntity<CredenciaisDTO> logar(@Valid @RequestBody UsuarioLoginDTO usuarioParaAutenticar) {
		return service.pegarCredenciais(usuarioParaAutenticar);
	}

	/*@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario novoUsuario) {
		return service.atualizarUsuario(novoUsuario).map(resp -> ResponseEntity.status(201).body(resp))
				.orElseThrow(() -> {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
							"Necessario que passe um idUsuario valido para alterar!.");
				});

	}*/
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable (value = "id") Long idUsuario) {
		repository.deleteById(idUsuario);
	}

}

