package br.facisa.si2.Leilao.api.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.facisa.si2.Leilao.api.exceptions.RestException;
import br.facisa.si2.Leilao.api.interfaces.Identificable;

public abstract class ServiceAbs <T extends Identificable>{
	
	protected JpaRepository<T,Long> repository;
	
	public ServiceAbs(JpaRepository<T,Long> repository) {
		this.repository = repository;
	}
	
	public List<T> getAll() {  //READ ALL
		return repository.findAll();
	}
	
	public T getById(Long id) { //READ BY ID
		return repository.findById(id).get() ;
	}
	
	public T add(T t) { // ADD 
		return repository.save(t);
		
	}
	
	public T atualiza( T t) throws RestException{ // ATUALIZA
		if (repository.existsById(t.getId())) {
			return repository.saveAndFlush(t);
		}throw new RestException("Id não encontrado!!");
	}
	
	
	public void deleta( Long id ) throws RestException { // DELETE
		if (repository.existsById(id)) {
			repository.deleteById(id); 
		}else{
			throw new RestException("Não foi apagado!! ID errado ou não existe"); 
		}
	}
		
}