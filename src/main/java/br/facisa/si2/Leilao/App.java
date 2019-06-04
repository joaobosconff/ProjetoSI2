package br.facisa.si2.Leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.facisa.si2.Leilao.api.Admin;

@SpringBootApplication
@EnableAutoConfiguration
public class App implements CommandLineRunner {
	
	@Autowired
	private Admin admin;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Terminou");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		admin.execute();
	}
	
	
}