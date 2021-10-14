package org.generation.blogPessoal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Amanda
 * @version 1.0
 */
@Entity
public class Usuario {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long idUsuario;
	private @NotBlank String nome;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 8, max = 100) String senha;
	
	public Usuario() {
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
