package br.facisa.si2.Leilao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import br.facisa.si2.Leilao.api.domains.Lance;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Mediador;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.services.LanceService;
import br.facisa.si2.Leilao.api.services.LoteService;
import br.facisa.si2.Leilao.api.services.MediadorService;

@RestController
@RequestMapping("/mediador")
public class MediadorController {

	@Autowired
	private MediadorService mediadorService;

	@Autowired
	private Mediador mediador = mediadorService.getAll().get(0);

	@Autowired
	private LanceService lanceService;
	
	@Autowired
	private LoteService loteService;

	@PostMapping("/lance")
	public ResponseEntity<Lance> criarLance(@RequestBody Lance l) {
		this.mediador.setLance(l);
		this.mediador.setPrecoDoLance(l.getPrecoLance());
		return new ResponseEntity<Lance>(lanceService.add(l), HttpStatus.CREATED);
	}
	
	@PostMapping("/lote")
	public ResponseEntity<Lote> comprarLote(@RequestBody Lote l) {
		loteService.deleta(l.getId());
		return new ResponseEntity<Lote>(l, HttpStatus.CREATED);
	}
}
