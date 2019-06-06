package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.domains.dto.LoteDto;
import br.facisa.si2.Leilao.api.repositories.LoteRepository;

@Service
public class LoteService{
	
	@Autowired
	private ProdutoService servProd;
	
	@Autowired
	private LoteRepository loteRep;
	
	public Lote createLote(LoteDto dto) {
		Lote lote = new Lote();
		for (int id : dto.getProdutosId()) {
			Long idProd = (long) id;
			Produto prod = servProd.getById(idProd);
			lote.getProdutos().add(prod);
			
		}
		return loteRep.save(lote);
		
	}

}
