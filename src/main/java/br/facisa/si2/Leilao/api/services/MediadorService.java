package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Lance;
import br.facisa.si2.Leilao.api.domains.Mediador;
import br.facisa.si2.Leilao.api.exceptions.RestException;
import br.facisa.si2.Leilao.api.repositories.MediadorRepository;

@Service
public class MediadorService extends ServiceAbs<Mediador>{
	
	@Autowired
	public MediadorService(MediadorRepository repository) {
		super(repository);
	}
	
	@Autowired
	private LanceService lanceService;
	
	
	public String fazLance(Lance l) throws RestException {
		Mediador mediadorUnico = this.getAll().get(0);
		String msg = mediadorUnico.setLance(l);
		if (msg == "vencedor") {
			return confirmarCompra(l,mediadorUnico.getComprador().get(0));
		} else {			
		mediadorUnico.setPrecoDoLance(l.getPrecoLance());
		this.atualiza(mediadorUnico);}
		return "atualiza";
	}
		
	
	public String confirmarCompra(Lance l,Comprador comprador) throws RestException {
		String msg = "O lance" + l.toString() + " foi vendido para" + comprador.getNome();
		lanceService.deleta(l.getId());
		return msg;
	}
	

}

