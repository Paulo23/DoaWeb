package br.unifor.pin.doaweb.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.dao.DoacaoDAO;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.entity.Usuarios;

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
}
