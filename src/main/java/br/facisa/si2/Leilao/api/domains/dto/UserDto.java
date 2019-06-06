package br.facisa.si2.Leilao.api.domains.dto;

import br.facisa.si2.Leilao.api.domains.Usuario;
import br.facisa.si2.Leilao.api.enumerator.UserType;

public class UserDto {
	
	private Usuario user;
	
	private UserType role;

	public UserDto(Usuario user, UserType role) {
		this.user = user;
		this.role = role;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public UserType getRole() {
		return role;
	}

	public void setRole(UserType role) {
		this.role = role;
	}

	
}
