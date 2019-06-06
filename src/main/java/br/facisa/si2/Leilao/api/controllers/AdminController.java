package br.facisa.si2.Leilao.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Mediador;
import br.facisa.si2.Leilao.api.domains.Usuario;
import br.facisa.si2.Leilao.api.domains.dto.UserDto;
import br.facisa.si2.Leilao.api.enumerator.UserType;
import br.facisa.si2.Leilao.api.exceptions.RestException;
import br.facisa.si2.Leilao.api.services.CompradorService;
import br.facisa.si2.Leilao.api.services.LoteService;
import br.facisa.si2.Leilao.api.services.MediadorService;
import br.facisa.si2.Leilao.api.services.ProdutoService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProdutoService prodService;

	@Autowired
	private MediadorService medService;

	@Autowired
	private LoteService loteService;

	@Autowired
	private CompradorService compService;

	@GetMapping("/usuario/mediador")
	public ResponseEntity<List<Mediador>> getMediador() {
		return new ResponseEntity<List<Mediador>>(medService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/usuario/comprador")
	public ResponseEntity<List<Comprador>> getComprador(){
		return new ResponseEntity<List<Comprador>>(compService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody UserDto dto){
		Usuario user = null;
		if(dto.getRole() == UserType.COMPRADOR) {
			user = compService.add((Comprador) dto.getUser());
		}else if (dto.getRole() == UserType.MEDIADOR) {
			user = medService.add((Mediador) dto.getUser());
		}
		return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,@RequestBody UserDto dto) throws RestException{
		Usuario user = null;
		if(dto.getRole() == UserType.COMPRADOR) {
			user = (Comprador) dto.getUser();
			user.setId(id);
			user = compService.atualiza((Comprador) user);
		}else if (dto.getRole() == UserType.MEDIADOR) {
			user = (Mediador) dto.getUser();
			user.setId(id);
			user = medService.atualiza((Mediador) user);
		}
		return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable Long id,@RequestBody UserDto dto) throws RestException{
		if(dto.getRole() == UserType.COMPRADOR) {
			compService.deleta(id);
		}else if (dto.getRole() == UserType.MEDIADOR) {
			medService.deleta(id);
		}
		return new ResponseEntity<String>("deletado",HttpStatus.OK);
	}
	
	
}
