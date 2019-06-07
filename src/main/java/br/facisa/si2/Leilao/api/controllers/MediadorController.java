package br.facisa.si2.Leilao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.domains.Lance;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.exceptions.RestException;
import br.facisa.si2.Leilao.api.services.LanceService;
import br.facisa.si2.Leilao.api.services.LoteService;
import br.facisa.si2.Leilao.api.services.MediadorService;

@CrossOrigin
@RestController
@RequestMapping("/mediador")
public class MediadorController {

	@Autowired
	private MediadorService mediadorService;

	@Autowired
	private LoteService loteService;

	@PostMapping("/lance")
	public ResponseEntity<String> criarLance(@RequestBody Lance l) throws RestException {
		return new ResponseEntity<String>(mediadorService.fazLance(l), HttpStatus.CREATED);
		}

	@PostMapping("/lote")
	public ResponseEntity<Lote> comprarLote(@RequestBody Lote l) {
		loteService.deleta(l.getId());
		return new ResponseEntity<Lote>(l, HttpStatus.CREATED);
	}
	
	@PostMapping("/confirmar/lance")
	public ResponseEntity<Produto> confirmarCompra(@RequestBody Lance l, String msg) throws RestException {
		return new ResponseEntity<Produto>(mediadorService.confirmarCompra(msg, l), HttpStatus.CREATED);
	}
}
