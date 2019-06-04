package br.facisa.si2.Leilao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.abstracts.ControllerAbs;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends ControllerAbs<Produto>{
	@Autowired
	public ProdutoController(ProdutoService service) {
		super(service);
		
	}
}