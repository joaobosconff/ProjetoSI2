package br.facisa.si2.Leilao.api.exceptions;

public class RestException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public RestException(String msg) {
		super(msg);
	}
	
}
