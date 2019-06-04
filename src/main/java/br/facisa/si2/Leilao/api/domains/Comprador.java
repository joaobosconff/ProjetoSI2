package br.facisa.si2.Leilao.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Comprador implements Identificable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	public Comprador() {
	}

	public Comprador(String nome) {
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	private void update() {
		System.out.println("Preco do Lance é");
	}
}
