package br.facisa.si2.Leilao.api.domains.dto;

import java.util.List;

public class LoteDto {
	
	private List<Integer> produtosId;

	public List<Integer> getProdutosId() {
		return produtosId;
	}

	public void setProdutosId(List<Integer> produtosId) {
		this.produtosId = produtosId;
	}

	public LoteDto(List<Integer> produtosId) {
		this.produtosId = produtosId;
	}
	
	

}
