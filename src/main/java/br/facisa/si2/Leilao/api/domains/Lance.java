package br.facisa.si2.Leilao.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Lance implements Identificable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Produto produtoLeiloado;
	
	private Double precoLance;

	@OneToOne
	private Comprador compradorFinal;

	public Lance(Produto produtoLeiloados, Double precoLance) {
		this.produtoLeiloado = produtoLeiloados;
		this.precoLance = precoLance;
	}
	
	public Lance() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProdutoLeiloado() {
		return produtoLeiloado;
	}

	public void setProdutoLeiloado(Produto produtoLeiloado) {
		this.produtoLeiloado = produtoLeiloado;
	}

	public Double getPrecoLance() {
		return precoLance;
	}

	public void setPrecoLance(Double precoLance) {
		this.precoLance = precoLance;
	}

	public Comprador getCompradorFinal() {
		return compradorFinal;
	}

	public void setCompradorFinal(Comprador compradorFinal) {
		this.compradorFinal = compradorFinal;
	}
	
	
}