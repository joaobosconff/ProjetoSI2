package br.facisa.si2.Leilao.api.domains;

import br.facisa.si2.Leilao.api.enumerator.UserType;

public class UserFactory {

	public Usuario criar(UserType ut){
		switch (ut) {
		case COMPRADOR:
			return new Comprador();
		case MEDIADOR:
			return new Mediador();
		default:
			break;
		}
		return null;
	}
}
