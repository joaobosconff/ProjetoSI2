package br.facisa.si2.Leilao.api;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.services.CompradorService;

@Service
public class Admin {

	@Autowired
	private CompradorService serv;

	public Admin() {

	}

	public void execute() {
		Scanner scanner = new Scanner(System.in);
		boolean executando = true;
		while (executando) {
			System.out.println(
					"Bem vindo ao sistema de leilão,o que você deseja fazer? 1-Criar Comprador 2-Criar produto");
			int number = scanner.nextInt();
			switch (number) {
			case 1:
				executando = false;
				break;
			case 2:
				System.out.println("zabo");
			default:
				break;
			}
		}
	}
}
