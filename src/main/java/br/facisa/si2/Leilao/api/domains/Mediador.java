package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Mediador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private Double precoDoLance;
	
	@OneToOne
	private Lance lance;
	
	@OneToMany
	private List<Comprador> comprador;

	public Mediador(String nome, Lance lance) {
		this.nome = nome;
		this.lance = lance;
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

	public Double getPrecoDoLance() {
		return precoDoLance;
	}

	public void setPrecoDoLance(Double precoDoLance) {
		this.precoDoLance = precoDoLance;
	}

	public Lance getLance() {
		return lance;
	}

	public void setLance(Lance lance) {
		this.lance = lance;
	}

	public List<Comprador> getComprador() {
		return comprador;
	}

	public void setComprador(List<Comprador> comprador) {
		this.comprador = comprador;
	}
	

	

}