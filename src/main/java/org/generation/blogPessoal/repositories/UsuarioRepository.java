package org.generation.blogPessoal.repositories;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/**
	 * @param nome
	 * @return list com nome
	 * @since 1.0
	 */
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);

	/**
	 * @param email
	 * @return list com email
	 * @since 1.0
	 */
	public Optional<Usuario> findByEmail(String email);
}
