package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Lote implements Identificable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<Produto> produtos;
	
	private Double precoTotal;

	public Lote(List<Produto> produtos, Double precoTotal) {
		this.produtos = produtos;
		this.precoTotal = precoTotal;
	}

	public Lote() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
}
