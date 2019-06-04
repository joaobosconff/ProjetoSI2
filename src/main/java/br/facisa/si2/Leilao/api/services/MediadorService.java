package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Mediador;
import br.facisa.si2.Leilao.api.repositories.MediadorRepository;

public class MediadorService extends ServiceAbs<Mediador>{
	
	@Autowired
	public MediadorService(MediadorRepository repository) {
		super(repository);
	}
	

}

