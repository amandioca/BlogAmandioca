package org.generation.blogPessoal.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {
	
	public Usuario usuario;
	
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@BeforeEach
	public void start() {
		usuario = new Usuario("Amanda Amorim", "amanda@email.com", "135792468");
	}
	
	@Test
	void validaUsuarioCorretoRetornaTrue() {
		Set<ConstraintViolation<Usuario>> objetoViolado = validator.validate(usuario);
		
		assertTrue(objetoViolado.isEmpty());
	}
	
	@Test
	void validationUsuarioIncorretoRetornaFalse() {
		Usuario usuarioErro = new Usuario(null, "amanda@email.com", "135792468");
		Set<ConstraintViolation<Usuario>> objetoViolado = validator.validate(usuarioErro);
	
		assertFalse(objetoViolado.isEmpty());
	}
}
