package org.generation.blogPessoal.repositories;

import java.util.List;

import org.generation.blogPessoal.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	/**
	 * @param titulo
	 * @return List com a classe Postagem
	 * @author Amanda
	 * @since 1.0
	 */
	public List<Postagem> findByTituloContainingIgnoreCase(String titulo);

}