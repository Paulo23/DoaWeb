package br.unifor.pin.doaweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.entity.Instituicao;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Instituicao instituicao) {
		entityManager.persist(instituicao);
	}

	public void atualizar(Instituicao instituicao) {
		entityManager.merge(instituicao);
	}

	public void excluir(Instituicao instituicao) {
		entityManager.remove(instituicao);
	}

	public Instituicao buscarPorId(Integer id){
		return entityManager.find(Instituicao.class, id);
	}
	
	public Instituicao buscarPorNome(String nome) {
		String jpql = "select i from Instituicoes i where i.nome = :nome";
		Query query = (Query) entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		return (Instituicao) ((javax.persistence.Query) query).getSingleResult();
	}
	
}
