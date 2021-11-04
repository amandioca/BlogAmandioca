package org.generation.blogPessoal.security;

import java.util.Optional;

import org.generation.blogPessoal.models.Usuario;
import org.generation.blogPessoal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Amanda
 * @version 1.0
 */
@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	private @Autowired UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> objetoOptional = repository.findByEmail(username);

		if (objetoOptional.isPresent()) {
			return new UserDetailsImplements(objetoOptional.get());
		} else {
			throw new UsernameNotFoundException(username + " Não existe!");
		}

	}

}