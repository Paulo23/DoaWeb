package br.unifor.pin.doaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.entity.Instituicoes;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Instituicoes instituicao) {
		entityManager.persist(instituicao);
	}

	public void atualizar(Instituicoes instituicao) {
		entityManager.merge(instituicao);
	}

	public void excluir(Instituicoes instituicao) {
		entityManager.remove(instituicao);
	}

	public Instituicoes buscarPorId(Integer id){
		return entityManager.find(Instituicoes.class, id);
	}
	
	public Instituicoes buscarPorNome(String nome) {
		String jpql = "select i from Instituicoes i where i.nome = :nome";
		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Instituicoes) ((javax.persistence.Query) query).getSingleResult();
	}
	
}
