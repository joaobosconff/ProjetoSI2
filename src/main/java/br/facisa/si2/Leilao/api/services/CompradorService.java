package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.repositories.CompradorRepository;

@Service
public class CompradorService extends ServiceAbs<Comprador>{
	
	@Autowired
	public CompradorService(CompradorRepository repository) {
		super(repository);
	}
	
}
