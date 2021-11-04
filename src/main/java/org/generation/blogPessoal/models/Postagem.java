package org.generation.blogPessoal.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Amanda
 * @version 1.0
 */
@Entity
public class Postagem {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long idPostagem;
	private @NotBlank @Size(min = 10, max = 100) String titulo;
	private @NotBlank @Size(min = 10, max = 500) String texto;
	private String midia;
	private @Temporal(TemporalType.TIMESTAMP) Date date = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne
	@JoinColumn(name = "fk_criador")
	@JsonIgnoreProperties("minhasPostagens")
	private Usuario criador;
	
	@ManyToOne
	@JoinColumn(name = "fk_tema")
	@JsonIgnoreProperties("postagens")
	private Tema temaRelacionado;
	
	public long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Usuario getCriador() {
		return criador;
	}

	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public Tema getTemaRelacionado() {
		return temaRelacionado;
	}

	public void setTemaRelacionado(Tema temaRelacionado) {
		this.temaRelacionado = temaRelacionado;
	}

}