package br.facisa.si2.Leilao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.abstracts.ControllerAbs;
import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.services.CompradorService;

@RestController
@RequestMapping("/comprador")
public class CompradorController extends ControllerAbs<Comprador>{
	
	@Autowired
	public CompradorController(CompradorService service) {
		super(service);
		
	}
}