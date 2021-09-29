package org.generation.blogPessoal.repositories;

import java.util.List;

import org.generation.blogPessoal.models.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {
	
	/**
	 * Metodo utilizado para realizar pesquisa pela coluna tema da tabela tema
	 * 
	 * @param titulo
	 * @return List com PostagemModel
	 * @author Amanda
	 * @since 1.0
	 * 
	 */
	
	public List<PostagemModel>findAllByTituloContainingIgnoreCase(String titulo);

}