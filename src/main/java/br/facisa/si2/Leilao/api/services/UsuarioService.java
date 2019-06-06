package br.facisa.si2.Leilao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facisa.si2.Leilao.api.abstracts.ServiceAbs;
import br.facisa.si2.Leilao.api.domains.Comprador;
import br.facisa.si2.Leilao.api.domains.Usuario;
import br.facisa.si2.Leilao.api.repositories.CompradorRepository;
import br.facisa.si2.Leilao.api.repositories.MediadorRepository;

@Service
public class UsuarioService{
	
	@Autowired
	public UsuarioService(CompradorRepository repository) {
		new CompradorService(repository);
	}
	
	@Autowired
	public UsuarioService(MediadorRepository repository) {
		new MediadorService(repository);
	}
}
