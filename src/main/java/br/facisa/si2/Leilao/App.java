package br.facisa.si2.Leilao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class App implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Terminou");
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	}
	
	
}