package br.unifor.pin.doaweb.manager.usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.dao.UsuariosDAO;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.to.SegurancaTO;
import br.unifor.pin.doaweb.utils.Navigation;
/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name = "atualizaUsuario")
@Component(value = "atualizaUsuario")
public class AtualizaUsuarioManager {

	@Autowired
	private UsuariosDAO usuariosDAO;
	private SegurancaTO segurancaTO;
	private Usuarios usuarioSelecionado;
	
	
	public String preparaAtualizar() {
		//usuarioSelecionado = this.segurancaTO.getUsuario();

		return Navigation.ATUALIZA;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public String excluir(){
		usuarioSelecionado = (Instituicoes) this.segurancaTO.getUsuario();
		usuariosDAO.excluir(usuarioSelecionado);
		
		return Navigation.EXCLUIR;
	}

	
	public void limparDados(){
//		usuarioSelecionado.setNome("");
//		usuarioSelecionado.setEmail("");
//		usuarioSelecionado.setSenha("");
//		usuarioSelecionado.setAtivo(false);
	}


	
	
}
