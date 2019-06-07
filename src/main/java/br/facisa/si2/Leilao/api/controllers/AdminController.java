package br.facisa.si2.Leilao.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Mediador;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.domains.UserFactory;
import br.facisa.si2.Leilao.api.domains.Usuario;
import br.facisa.si2.Leilao.api.domains.dto.LoteDto;
import br.facisa.si2.Leilao.api.domains.dto.UserDto;
import br.facisa.si2.Leilao.api.enumerator.UserType;
import br.facisa.si2.Leilao.api.exceptions.RestException;
import br.facisa.si2.Leilao.api.services.CompradorService;
import br.facisa.si2.Leilao.api.services.LoteService;
import br.facisa.si2.Leilao.api.services.MediadorService;
import br.facisa.si2.Leilao.api.services.ProdutoService;

@CrossOrigin
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
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id,@RequestBody UserDto dto) throws RestException{
		UserFactory userFactory = new UserFactory();
		Usuario user = new Usuario();
		if(dto.getRole() == UserType.COMPRADOR) {
			user = userFactory.criar(UserType.COMPRADOR);
			user.setId(id);
			user.setNome(dto.getNome());
			user = compService.atualiza((Comprador) user);
		}else if (dto.getRole() == UserType.MEDIADOR) {
			user = userFactory.criar(UserType.MEDIADOR);
			user.setId(id);
			user.setNome(dto.getNome());
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
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> createUsuario(@RequestBody UserDto dto){
		UserFactory userFactory = new UserFactory();
		Usuario user = new Usuario();
		if(dto.getRole() == UserType.COMPRADOR) {
			user = userFactory.criar(UserType.COMPRADOR);
			user.setNome(dto.getNome());
			compService.add((Comprador) user);
			return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
		}else if (dto.getRole() == UserType.MEDIADOR) {
			user = userFactory.criar(UserType.MEDIADOR);
			user.setNome(dto.getNome());
			medService.add((Mediador)user);
			return new ResponseEntity<Usuario>(user,HttpStatus.CREATED);
		}
		return null;
		
		
		
	}
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> createProduto(@RequestBody Produto p){
		return new ResponseEntity<Produto>(prodService.add(p), HttpStatus.CREATED);
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> getAllProdutos(){
		return new ResponseEntity<List<Produto>>(prodService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getProduto(@PathVariable Long id){
		return new ResponseEntity<Produto>(prodService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> editarProduto(@PathVariable Long id, @RequestBody Produto p) throws RestException{
		p.setId(id);
		return new ResponseEntity<Produto>(prodService.atualiza(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<String> deleteProduto(@PathVariable Long id) throws RestException{
		prodService.deleta(id);
		return new ResponseEntity<String>("Deletado com sucesso!",HttpStatus.OK);
	}
	
	@PostMapping("/lote")
	public ResponseEntity<Lote> createLote(@RequestBody LoteDto l){
		return new ResponseEntity<Lote>(loteService.createLote(l), HttpStatus.CREATED);
	}
	
	@GetMapping("/lote")
	public ResponseEntity<List<Lote>> getAllLote(){
		return new ResponseEntity<List<Lote>>(loteService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/lote/{id}")
	public ResponseEntity<Lote> getLote(@PathVariable Long id){
		return new ResponseEntity<Lote>(loteService.getById(id),HttpStatus.OK);
	}
	
	@PutMapping("/lote/{id}")
	public ResponseEntity<Lote> editarLote(@PathVariable Long id, @RequestBody Lote l) throws RestException{
		l.setId(id);
		return new ResponseEntity<Lote>(loteService.atualiza(l),HttpStatus.OK);
	}
	
	@DeleteMapping("/lote/{id}")
	public ResponseEntity<String> deleteLote(@PathVariable Long id) throws RestException{
		loteService.deleta(id);
		return new ResponseEntity<String>("Deletado com sucesso!",HttpStatus.OK);
	}
	
}
