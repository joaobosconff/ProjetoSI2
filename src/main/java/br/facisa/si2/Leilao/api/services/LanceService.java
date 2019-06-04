package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Lance;
import br.facisa.si2.Leilao.api.repositories.LanceRepository;

@Service
public class LanceService extends ServiceAbs<Lance>{
	
	@Autowired
	public LanceService(LanceRepository repository) {
		super(repository);
	}
	

}
