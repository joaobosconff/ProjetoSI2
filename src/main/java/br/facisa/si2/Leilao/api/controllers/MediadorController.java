package br.facisa.si2.Leilao.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Lance;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Mediador;
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
	private LanceService lanceService;
	
	@Autowired
	private LoteService loteService;

	@PostMapping("/lance")
	public ResponseEntity<Lance> criarLance(@RequestBody Lance l) throws RestException {
		Mediador mediadorUnico = mediadorService.getAll().get(0);

		String msg = mediadorUnico.setLance(l);
		if (msg == "vencedor") {
			confirmarCompra(l.getCompradorFinal());
		} else {			
		mediadorUnico.setPrecoDoLance(l.getPrecoLance());
		mediadorService.atualiza(mediadorUnico);
		return new ResponseEntity<Lance>(lanceService.add(l), HttpStatus.CREATED);
		}
	}
	
	private ResponseEntity<String> confirmarCompra(Comprador compradorFinal) {
		return new ResponseEntity<String>("Confirmar compra", HttpStatus.OK);
	}
	
	@PostMapping("/confirmar")

	@PostMapping("/lote")
	public ResponseEntity<Lote> comprarLote(@RequestBody Lote l) {
		loteService.deleta(l.getId());
		return new ResponseEntity<Lote>(l, HttpStatus.CREATED);
	}
}
