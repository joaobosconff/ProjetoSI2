package br.facisa.si2.Leilao.api.domains.dto;

import br.facisa.si2.Leilao.api.enumerator.UserType;

public class UserDto {
	
	private String nome;
	
	private UserType role;

	public UserDto(String nome, UserType role) {
		this.nome = nome;
		this.role = role;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}
	
	

	

	
}
