package br.unifor.pin.doaweb.abstractfactory;

import br.unifor.pin.doaweb.entity.Instituicao;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.TipoUsuario;

public class InstituicaoFactory extends UsuarioFactory {

	@Override
	public Usuarios criaUsuario() {
		Instituicao instituicao = new Instituicao();
		instituicao.setTipoUsuario(TipoUsuario.INSTITUICAO);
		return instituicao;
	}
	
	

}
