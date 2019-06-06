package br.facisa.si2.Leilao.api.services;

import java.util.List;

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

	public List<Lote> getAll() { 
		return loteRep.findAll();
	}
	
	public Lote getById(Long id) {
		return loteRep.getOne(id);
	}
	
	public Lote atualiza(Lote l) {
		return loteRep.saveAndFlush(l);
	}
	
	public void deleta(Long id) {
		loteRep.deleteById(id);
	}
}
