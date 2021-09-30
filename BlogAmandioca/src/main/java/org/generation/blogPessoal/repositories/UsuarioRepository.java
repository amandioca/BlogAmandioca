package org.generation.blogPessoal.repositories;

import java.util.List;

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
	 * Metodo utilizado para realizar pequisas na tabela usuario, coluna nome
	 * 
	 * @param nome
	 * @return list com nome
	 * @since 1.0
	 */
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	/**
	 * Metodo utilizado para realizar pequisas na tabela usuario, coluna email
	 * 
	 * @param email
	 * @return list com email
	 * @since 1.0
	 */
	public List<Usuario> findByEmailContainingIgnoreCase(String email);
}
