package br.unifor.pin.doaweb.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.PermitAll;
import br.unifor.pin.doaweb.dao.DoacaoDAO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.StatusDoacao;

@Component
public class DoacaoBO {

	@Autowired
	private DoacaoDAO doacaoDAO;
	

	public void salvar(Doacao doacao) {
		doacaoDAO.salvar(doacao);
	}

	@Loggable(enable = false)
	public List<Doacao> buscarDoacPorDoad(Usuarios doador) {
		return doacaoDAO.buscaDoacaoPorDoador(doador);
	}
	
	@PermitAll
	@Loggable(enable = false)
	public List<Doacao> buscarDoacPorIdDoador(Integer id) {
		return doacaoDAO.buscaDoacaoPorIdDoador(id);
	}
	
	@Loggable(enable = false)
	public List<Doacao> buscarDoacPorCamp(Campanhas camp) {
		return doacaoDAO.buscaDoacaoPorCampanha(camp);
	}
	
	public void alteraStatusDOacao(Doacao doacao, StatusDoacao statusDoacao){
		Doacao doacao2 = doacaoDAO.buscaDoacaoPorId(doacao.getId());
		doacao2.setStatus(statusDoacao);
		doacaoDAO.atualizar(doacao2);
	}
}
