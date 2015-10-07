/**
 * 
 */
package br.unifor.pin.doaweb.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.UsuarioBO;
import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.to.SegurancaTO;
import br.unifor.pin.doaweb.utils.Encripta;
import br.unifor.pin.doaweb.utils.MessagesUtils;
import br.unifor.pin.doaweb.utils.Navigation;

/**
 * @author patrick.cunha
 * @since 26/06/2015
 */
@RequestScoped
@Component(value = "login")
@ManagedBean(name = "login")
public class LoginManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private SegurancaTO seguranca;
	private Usuarios usuario = new Usuarios();
	private boolean existsEmail;

	public String loggar() {
		Usuarios usuario = this.usuarioBO.loggar(this.usuario.getEmail(),
				Encripta.encripta(this.usuario.getSenha()));
		this.usuario = new Usuarios();
		if (usuario != null) {
			seguranca.setUsuario(usuario);
			existsEmail = true;
			if(usuario instanceof Doadores) {
				MessagesUtils.info("Bem vindo "+((Doadores)usuario).getNome());
			} else if (usuario instanceof Instituicoes) {
				MessagesUtils.info("Bem vindo "+((Instituicoes)usuario).getRazaoSocial());
			}
			return Navigation.SUCESSO;
		} else {
			existsEmail = false;
			MessagesUtils.error("O e-mail ou a senha inseridos estão incorretos.");
			return Navigation.FRACASSO;
		}
	}
	
	public String preparaSalvar(){
		return Navigation.CADASTRO;
	}

	/**
	 * @return the usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the existsEmail
	 */
	public boolean isExistsEmail() {
		return existsEmail;
	}

	/**
	 * @param existsEmail
	 *            the existsEmail to set
	 */
	public void setExistsEmail(boolean existsEmail) {
		this.existsEmail = existsEmail;
	}

	public SegurancaTO getSeguranca() {
		return seguranca;
	}

	public void setSeguranca(SegurancaTO seguranca) {
		this.seguranca = seguranca;
	}

	
	
}
