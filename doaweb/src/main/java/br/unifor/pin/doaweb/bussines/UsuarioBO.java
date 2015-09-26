package br.unifor.pin.doaweb.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.PermitAll;
import br.unifor.pin.doaweb.dao.DoadoresDAO;
import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.entity.security.Papeis;
import br.unifor.pin.doaweb.exceptions.DAOException;

/**
 * @author patrick.cunha
 * 
 */
@Loggable
@Component
@Transactional(propagation=Propagation.REQUIRED)
public class UsuarioBO {

	@Autowired
	private DoadoresDAO doadoresDAO;
	
	public void salvar(Doadores doador) {
//		doador.setAtivo(true);
		doadoresDAO.salvar(doador);
	}
	
	public void salvar(Usuarios usuario) {
//		usuario.setAtivo(true);
		doadoresDAO.salvar(usuario);
	}

	public void atualizar(Usuarios usuario) {
		doadoresDAO.atualizar(usuario);
	}

	@Loggable(enable = false)
	public Usuarios loggar(String email, String senha) {
		return doadoresDAO.buscarPorEmailSenha(email, senha);
	}

	@Loggable(enable = false)
	public Usuarios buscarUsuarioPorEmail(String email) {
		return doadoresDAO.buscarPorEmail(email);
	}

	@Loggable(enable = false)
	public List<Usuarios> listaUsuarioPorNome(String nome) {
		List<Usuarios> usuarios = doadoresDAO.listarPorNome(nome);
		return usuarios;
	}

	@PermitAll
	@Loggable(enable = false)
	public Usuarios buscarPorId(Integer id) {
		try {
			return doadoresDAO.buscaPorId(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Usuarios usuario) {
		try {
			usuario = doadoresDAO.buscaPorId(usuario.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		doadoresDAO.excluir(usuario);
	}

	public Papeis buscaPapelAdmin() {
		return doadoresDAO.buscaPapel();
	}

}
