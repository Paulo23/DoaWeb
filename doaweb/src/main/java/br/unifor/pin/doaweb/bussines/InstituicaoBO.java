package br.unifor.pin.doaweb.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.RolesAllowed;
import br.unifor.pin.doaweb.dao.InstituicaoDAO;
import br.unifor.pin.doaweb.entity.Instituicao;

@Loggable
@Service
public class InstituicaoBO {

	@Autowired
	private InstituicaoDAO instituicaoDAO;

	@RolesAllowed(value = { "INCLUIR_INSTITUICAO" })
	public void salvar(Instituicao instituicao) {
		instituicaoDAO.salvar(instituicao);
	}

}
