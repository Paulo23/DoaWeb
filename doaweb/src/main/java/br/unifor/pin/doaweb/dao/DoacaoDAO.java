package br.unifor.pin.doaweb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.entity.Usuarios;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DoacaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void salvar(Doacao doacao) {
		entityManager.persist(doacao);
	}

	public void atualizar(Doacao doacao) {
		entityManager.merge(doacao);
	}

	public void excluir(Doacao doacao) {
		entityManager.remove(doacao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Doacao> buscaDoacaoPorDoador(Usuarios doador) {
		String jpql = "select u from Doacao u where u.doador = :doador";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("doador", doador);
		return (List<Doacao>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Doacao> buscaDoacaoPorCampanha(Campanhas campanha) {
		String jpql = "select u from Doacao u where u.campanha = :campanha";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("campanha", campanha);
		return (List<Doacao>) query.getResultList();
	}

	public Doacao buscaDoacaoPorId(Integer id) {
		String jpql = "select u from Doacao u where u.id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		return (Doacao) query.getSingleResult();

	}
	
}
