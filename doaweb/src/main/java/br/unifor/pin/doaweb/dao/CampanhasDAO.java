package br.unifor.pin.doaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unifor.pin.doaweb.entity.Campanhas;


public class CampanhasDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Campanhas campanha){
		entityManager.persist(campanha);
	}
	
	public void atualizar(Campanhas campanha) {
		entityManager.merge(campanha);
	}

	public void excluir(Campanhas campanha) {
		entityManager.remove(campanha);
	}
	
}
