package br.unifor.pin.doaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unifor.pin.doaweb.entity.Doacao;

public class DoacaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Doacao doacao){
		entityManager.persist(doacao);
	}
	
	public void atualizar(Doacao doacao) {
		entityManager.merge(doacao);
	}

	public void excluir(Doacao doacao) {
		entityManager.remove(doacao);
	}
	
}
