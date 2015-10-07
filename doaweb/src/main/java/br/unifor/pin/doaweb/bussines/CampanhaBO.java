package br.unifor.pin.doaweb.bussines;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.RolesAllowed;
import br.unifor.pin.doaweb.dao.CampanhasDAO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.to.SegurancaTO;

@Component
public class CampanhaBO {

	@Autowired
	private SegurancaTO segurancaTo;
	
	@Autowired
	private CampanhasDAO campanhasDAO;

	public void salvar(Campanhas campanha) {
		campanhasDAO.salvar(campanha);
	}

	public void atualizarCampanha(Campanhas campanha) {
		campanhasDAO.atualizar(campanha);
	}

	public void excluirCampanha(Campanhas campanha) {
		campanhasDAO.excluir(campanha);
	}
	
	public Instituicoes getInstituicaoCampanha(){
		return (Instituicoes) segurancaTo.getUsuario();
	}
	
	@RolesAllowed(value = { "LISTAR_CAMPANHAS" })
	@Loggable(enable = false)
	public List<Campanhas> buscaPorDate(Date date)  {
		List<Campanhas> campanhas = campanhasDAO.listarPorDataDeInicio(date);
		return campanhas;
	}
	
}
