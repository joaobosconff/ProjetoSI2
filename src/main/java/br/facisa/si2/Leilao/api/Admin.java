package br.facisa.si2.Leilao.api;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Lote;
import br.facisa.si2.Leilao.api.domains.Produto;
import br.facisa.si2.Leilao.api.services.CompradorService;
import br.facisa.si2.Leilao.api.services.LoteService;
import br.facisa.si2.Leilao.api.services.ProdutoService;

@Service
public class Admin {

	@Autowired
	private CompradorService compServ;

	@Autowired
	private ProdutoService prodServ;
	
	@Autowired
	private LoteService loteServ;

	@Autowired
	private Scanner input;

	public Admin() {

	}

	public void execute() {
		boolean executando = true;
		while (executando) {
			System.out.println(
					"Bem vindo ao sistema de leilão,o que você deseja fazer? 1-Criar Comprador 2-Criar produto,3-Criar lote,6-Fechar");
			int number = input.nextInt();
			if (number == 1) {
				this.criarCompraddor();
			} else if (number == 2) {
				this.criarProduto();
			}else if(number == 3) {
				this.criarLote();
			}
			else if (number == 6) {
				executando = false;
			}
		}
	}

	private void criarCompraddor() {

		Comprador comprador = new Comprador();
		System.out.println("Digite o nome do Comprador:");
		String nome = input.next();
		comprador.setNome(nome);
		System.out.println(comprador);
		System.out.println("Deseja salvar? 1-SIM , 2-NÂO");
		int number2 = input.nextInt();
		if (number2 == 1) {
			compServ.add(comprador);
			System.out.println("Salvo");
		}
	}

	private void criarProduto() {
		Produto produto = new Produto();
		System.out.println("Digite o nome do Produto:");
		String nome = input.next();
		produto.setNome(nome);
		System.out.println("Digite o preço inicial:");
		double precoInicial = input.nextDouble();
		produto.setPrecoInicial(precoInicial);
		System.out.println("Digite o preço final:");
		Double precoFinal = input.nextDouble();
		produto.setPrecoFinal(precoFinal);
		System.out.println(produto);
		System.out.println("Deseja salvar? 1-SIM , 2-NÂO");
		int number2 = input.nextInt();
		if (number2 == 1) {
			prodServ.add(produto);
			System.out.println("Salvo");
		}
	}
	
	//quebrando
	public void criarLote() {
		boolean executando = true;
		Lote lote = new Lote();
		System.out.println(prodServ.getAll());
		System.out.println("");
		while(executando) {
			System.out.println("Digite os id dos produtos para adicionar no lote");
			Integer id = input.nextInt();
			if(id.equals(null)) {
				executando = false;
			}else {
				Produto prod = prodServ.getById(id.longValue());
				lote.getProdutos().add(prod);
			}
		}
	}

	@Bean
	private Scanner input() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}
}
