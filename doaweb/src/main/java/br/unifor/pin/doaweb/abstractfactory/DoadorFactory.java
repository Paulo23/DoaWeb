package br.unifor.pin.doaweb.abstractfactory;

import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.TipoUsuario;

public class DoadorFactory extends UsuarioFactory {

	@Override
	public Usuarios criaUsuario() {
		Doadores doador = new Doadores();
		doador.setTipoUsuario(TipoUsuario.DOADOR);
		return doador;
	}

}
