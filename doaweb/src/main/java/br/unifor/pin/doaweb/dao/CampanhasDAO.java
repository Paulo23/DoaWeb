package br.unifor.pin.doaweb.dao;

import java.util.Date;
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

@Repository
@Transactional(propagation=Propagation.REQUIRED)
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
	
	@SuppressWarnings("unchecked")
	public List<Campanhas> listarPorDataDeInicio(Date data) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Campanhas> criteriaQuery = criteriaBuilder.createQuery(Campanhas.class);
		Root<Campanhas> campanhas = criteriaQuery.from(Campanhas.class);
		criteriaQuery.where(criteriaBuilder.like(campanhas.<String>get("dataInicioCampanhas"), "%"+data+"%"));
		
		Query query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	}
	

