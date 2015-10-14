package br.unifor.pin.doaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Usuarios;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CampanhasDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Campanhas campanha) {
		entityManager.persist(campanha);
	}

	public void atualizar(Campanhas campanha) {
		entityManager.merge(campanha);
	}

	public void excluir(Campanhas campanha) {
		entityManager.remove(campanha);
	}

	@SuppressWarnings("unchecked")
	public List<Campanhas> buscaCampanhasPorInstituicao(Usuarios instituicao) {
		String jpql = "select u from Campanhas u where u.instituicao = :instituicao";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("instituicao", instituicao);
		return (List<Campanhas>) query.getResultList();

	}
	
	public Campanhas buscaCampanhaPorId(Integer id) {
		String jpql = "select u from Campanhas u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		return (Campanhas) query.getSingleResult();

	}
	
	public List<Campanhas> buscaTodasCampanhas() {
		String jpql = "select * from Campanhas";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	

}
