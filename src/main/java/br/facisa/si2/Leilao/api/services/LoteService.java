package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.repositories.LoteRepository;

@Service
public class LoteService extends ServiceAbs<Lote>{
	
	@Autowired
	public LoteService(LoteRepository repository) {
		super(repository);
	}

}
