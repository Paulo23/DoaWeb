package br.unifor.pin.doaweb.manager.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.abstractfactory.UsuarioFactory;
import br.unifor.pin.doaweb.bussines.UsuarioBO;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.TipoUsuario;
import br.unifor.pin.doaweb.utils.Navigation;


/**
 * @author patrick.cunha
 * 
 */
@RequestScoped
@ManagedBean(name = "cadUsuario")
@Component(value = "cadUsuario")
public class CadUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private ListUsuarioManager listUsuario;

	// atributos usuario
	private String email;
	private String senha;
	private TipoUsuario tipoUsuario;

	// atributos doador
	private String nome;
	private Date dataNascimento;
	private String cpf;

	// atributos instituicao
	private String razaoSocial;
	private String cnpj;

	public String salvar() {
		
		Usuarios usuario = UsuarioFactory.obtemFactory(tipoUsuario)
				.criaUsuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		return Navigation.SUCESSO;
	}

	// public void handleChange(AjaxBehaviorEvent event){
	// }

	public String preparaSalvar() {
		this.limpaDados();

		return Navigation.CADASTRO;
	}

	public List<SelectItem> getTipoUsuarios() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		for (TipoUsuario tipoUsuario : TipoUsuario.values()) {
			items.add(new SelectItem(tipoUsuario, tipoUsuario.getDescricao()));
		}
		return items;
	}

	public void limpaDados() {
		this.nome = "";
		this.email = "";
		this.senha = "";
		this.tipoUsuario = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
