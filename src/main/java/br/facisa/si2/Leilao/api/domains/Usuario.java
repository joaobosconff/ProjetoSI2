package br.facisa.si2.Leilao.api.domains;

public class Usuario{
	
	private String nome;

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}
	
	public Usuario() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
