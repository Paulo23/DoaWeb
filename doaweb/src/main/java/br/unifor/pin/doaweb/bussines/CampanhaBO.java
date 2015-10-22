package br.unifor.pin.doaweb.bussines;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.dao.CampanhasDAO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;

@Component
public class CampanhaBO {

	@Autowired
	private CampanhasDAO campanhasDAO;

	public void salvar(Campanhas campanha) {
		campanhasDAO.salvar(campanha);
	}

	public void atualizarCampanha(Campanhas campanha) {
		campanhasDAO.atualizar(campanha);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluirCampanha(Campanhas campanha) {
		campanha = campanhasDAO.buscaCampanhaPorId(campanha.getId());
		campanhasDAO.excluir(campanha);
	}

	@Loggable(enable = false)
	public List<Campanhas> buscarCampPorInst(Usuarios instituicao) {
		return campanhasDAO.buscaCampanhasPorInstituicao(instituicao);
	}
	
	public List<Campanhas> buscaCampanhasPorInstituicaoData(Instituicoes instituicao, Date data){
		return campanhasDAO.buscaCampanhasPorInstituicaoData(instituicao, data);
	}
	
	@Loggable(enable = false)
	public List<Campanhas> buscarTodasCamp() {
		List<Campanhas> campanhas = campanhasDAO.buscaTodasCampanhas();
		return campanhas;
	}
	
	public void atualizar(){
		
	}
	
	public void buscarCampanhaPorId(Integer id){
		campanhasDAO.buscaCampanhaPorId(id);
	}

}
