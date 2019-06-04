package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.repositories.ProdutoRepository;

@Service
public class ProdutoService extends ServiceAbs<Produto>{
	
	@Autowired
	public ProdutoService(ProdutoRepository repository) {
		super(repository);
	}
}
