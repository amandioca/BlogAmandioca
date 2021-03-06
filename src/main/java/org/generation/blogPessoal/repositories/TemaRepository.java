package org.generation.blogPessoal.repositories;

import java.util.List;

import org.generation.blogPessoal.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Amanda
 * @version 1.0
 */
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	/**
	 * @param tema
	 * @return list com tema
	 * @since 1.0
	 */
	public List<Tema> findByTemaContainingIgnoreCase(String tema);

}
