package br.unifor.pin.doaweb.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.PermitAll;
import br.unifor.pin.doaweb.aspectj.RolesAllowed;
import br.unifor.pin.doaweb.dao.DoadoresDAO;
import br.unifor.pin.doaweb.dao.UsuariosDAO;
import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.exceptions.BOException;
import br.unifor.pin.doaweb.exceptions.DAOException;
import br.unifor.pin.doaweb.to.SegurancaTO;

@Loggable
@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UsuarioBO {

	@Autowired
	private UsuariosDAO usuarioDAO;
	
	private SegurancaTO segurancaTo;
	
	@Autowired
	private DoadoresDAO doadoresDAO;
	
	public void salvar(Usuarios usuario) throws BOException {
		usuario.setAtivo(true);
		
		if (usuario instanceof Doadores) {
			Usuarios usuarioComMesmoCPFJaCadastrado = doadoresDAO.buscarPorCPF(((Doadores)usuario).getCpf());
			if(usuarioComMesmoCPFJaCadastrado != null){
				throw new BOException("CPF já cadastrado. Volte a tela de cadastro e tente novamente.");
			}
		}
		
		usuarioDAO.salvar(usuario);
	}

	public void atualizar(Usuarios usuario) {
		usuarioDAO.atualizar(usuario);
	}

	@Loggable(enable = false)
	public Usuarios loggar(String email, String senha) {
		return usuarioDAO.buscarPorEmailSenha(email, senha);
	}

	@Loggable(enable = false)
	public Usuarios buscarUsuarioPorEmail(String email) {
		return usuarioDAO.buscarPorEmail(email);
	}

	@PermitAll
	@Loggable(enable = false)
	public Usuarios buscarPorId(Integer id) {
		try {
			return usuarioDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@RolesAllowed(value = { "EXCLUIR_USUARIO" })
	public void excluirUsuario(Usuarios usuario) {
		try {
			usuario = usuarioDAO.buscaPorId(usuario.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		usuarioDAO.excluir(usuario);
	}
	

}
