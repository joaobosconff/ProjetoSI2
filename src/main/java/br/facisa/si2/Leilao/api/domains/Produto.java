package br.facisa.si2.Leilao.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Produto implements Identificable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private double precoInicial;
	
	private double precoFinal;
	
	@OneToOne
	private Comprador compradorFinal;

	public Produto(String nome, double precoInicial, double precoFinal) {
		this.nome = nome;
		this.precoInicial = precoInicial;
		this.precoFinal = precoFinal;
	}
	
	public Produto() {
		
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

	public double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(double precoFinal) {
		this.precoFinal = precoFinal;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", precoInicial=" + precoInicial + ", precoFinal=" + precoFinal
				+ "]";
	}

	public Comprador getCompradorFinal() {
		return compradorFinal;
	}

	public void setCompradorFinal(Comprador compradorFinal) {
		this.compradorFinal = compradorFinal;
	}
}
