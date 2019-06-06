package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.facisa.si2.Leilao.api.interfaces.Identificable;

@Entity
public class Mediador extends Usuario{

	private Double precoDoLance;

	@OneToOne
	private Lance lance;
	
	private HistoricoLance historicoLance;

	@OneToMany
	private List<Comprador> compradores;

	public Mediador(String nome, Lance lance) {
		super(nome);
		this.lance = lance;
	}
	
	public Mediador() {
		
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
		if (this.lance.getProdutoLeiloado().getCompradorFinal() != null) {
			System.out.println("Produto ja leiloado");
		} else if (lance.getPrecoLance() >= this.lance.getPrecoLance()) {
			System.out.println("Vencedor" + lance.getCompradorFinal().getNome());
			this.lance.getProdutoLeiloado().setCompradorFinal(lance.getCompradorFinal());
			this.lance = null;
			this.historicoLance = null;
			this.compradores = null;
			this.precoDoLance = null;
		} else {
			this.getHistoricoLance().adicionarLance(this.lance);
			this.lance = lance;
			for (Comprador comprador : compradores) {
				comprador.update();
			}
		}
	}

	public List<Comprador> getComprador() {
		return compradores;
	}

	public void setComprador(List<Comprador> comprador) {
		this.compradores = comprador;
	}
	
	
	public HistoricoLance getHistoricoLance() {
		return historicoLance;
	}

}
