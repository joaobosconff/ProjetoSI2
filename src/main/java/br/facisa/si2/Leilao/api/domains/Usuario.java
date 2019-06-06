package br.facisa.si2.Leilao.api.domains;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

public class Usuario implements Identificable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}
	
	public Usuario() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
