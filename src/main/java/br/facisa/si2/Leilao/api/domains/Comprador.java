package br.facisa.si2.Leilao.api.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Comprador extends Usuario implements Identificable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Mediador mediador;
	
	public Comprador() {
	}

	public Comprador(String nome) {
		super(nome);
	}

	public void update() {
		System.out.println("Preco do Lance é" + mediador.getPrecoDoLance());
	}

	@Override
	public String toString() {
		return "Comprador [id=" + getId() + ", nome=" + getNome() + ", mediador=" + mediador + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mediador getMediador() {
		return mediador;
	}

	public void setMediador(Mediador mediador) {
		this.mediador = mediador;
	}
	
	
}
