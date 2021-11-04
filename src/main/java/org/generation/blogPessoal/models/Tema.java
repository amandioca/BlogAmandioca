package org.generation.blogPessoal.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Amanda
 * @version 1.0
 */
@Entity
public class Tema {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long idTema;
	private @NotBlank @Size(min = 1, max = 20) String tema;
	private @NotBlank @Size(min = 15, max = 100) String descricao;
	
	@OneToMany(mappedBy = "temaRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("temaRelacionado")
	private List<Postagem> postagens = new ArrayList<>();
	
	public long getIdTema() {
		return idTema;
	}

	public void setIdTema(long idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}
	
}
