package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<Produto> produtosLeiloados;
	
	private Double precoLance;

	public Lance(List<Produto> produtosLeiloados, Double precoLance) {
		this.produtosLeiloados = produtosLeiloados;
		this.precoLance = precoLance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getProdutosLeiloados() {
		return produtosLeiloados;
	}

	public void setProdutosLeiloados(List<Produto> produtosLeiloados) {
		this.produtosLeiloados = produtosLeiloados;
	}

	public Double getPrecoLance() {
		return precoLance;
	}

	public void setPrecoLance(Double precoLance) {
		this.precoLance = precoLance;
	}
	

	

}
