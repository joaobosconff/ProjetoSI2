package br.facisa.si2.Leilao.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.facisa.si2.Leilao.api.domains.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
