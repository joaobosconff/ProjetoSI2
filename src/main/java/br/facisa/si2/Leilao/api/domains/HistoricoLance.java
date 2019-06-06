package br.facisa.si2.Leilao.api.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class HistoricoLance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
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
