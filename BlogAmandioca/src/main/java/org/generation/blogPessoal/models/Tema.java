package org.generation.blogPessoal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Amanda
 * @version 1.0
 */
@Entity
public class Tema {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long idTema;
	private @NotBlank @Size(min = 1, max = 20) String tema;
	private @NotBlank @Size(min = 15, max = 100) String descricao;

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
	
	
	
}
