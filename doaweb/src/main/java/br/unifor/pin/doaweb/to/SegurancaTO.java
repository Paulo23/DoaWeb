/**
 * 
 */
package br.unifor.pin.doaweb.to;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.TipoUsuario;

/**
 * @author patrick.cunha
 * @since 07/05/2015
 */
@Component(value = "segurancaTO")
@ManagedBean(name = "segurancaTO")
@SessionScoped
public class SegurancaTO implements Serializable {

	private static final long serialVersionUID = -9069250861713212366L;
	
	private Usuarios usuario;

	public boolean isAutenticado() {
		return usuario != null;
	}
	
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}
	
	public Integer getUsuarioID(){
		return usuario.getId();
	}
	
	public TipoUsuario getTipoUsuario(){
		if(this.usuario instanceof Doadores){
			return TipoUsuario.DOADOR;
		} else {
			return TipoUsuario.INSTITUICAO;
		}
	}

}
