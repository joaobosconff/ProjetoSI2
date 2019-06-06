package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class HistoricoLance {
	private List<Lance> lances;
	
	public HistoricoLance() {
		
	}

	public void adicionarLance(Lance lance) {
		this.lances.add(lance);
	}
	
	public List<Lance> getLances(){
		return this.lances;
	}

	@Override
	public String toString() {
		return "HistoricoLance [lances=" + lances + "]";
	}
}
