package br.unifor.pin.doaweb.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
import br.unifor.pin.doaweb.exceptions.DAOException;

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
	
	public Campanhas buscaPorId(Integer id) throws DAOException {
		String jpql = "select u from Campanhas u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);

		try {
			return (Campanhas) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	}
	

