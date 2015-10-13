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
import br.unifor.pin.doaweb.bussines.InstituicaoBO;
import br.unifor.pin.doaweb.bussines.UsuarioBO;
import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.TipoUsuario;
import br.unifor.pin.doaweb.utils.Encripta;
import br.unifor.pin.doaweb.utils.MessagesUtils;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadUsuario")
@Component(value = "cadUsuario")
public class CadUsuarioManager {

	@Autowired
	private UsuarioBO usuarioBO;
	@Autowired
	private InstituicaoBO instituicaoBO;
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
	private String endDoador;
	private String telDoador;

	// atributos instituicao
	private String razaoSocial;
	private String cnpj;
	private String end;
	private String tel;
	private String nomeBanco;
	private String operacao;
	private String agencia;
	private String conta;
	private String descricao;

	public String salvar() {
		
		Usuarios usuario = UsuarioFactory.obtemFactory(tipoUsuario)
				.criaUsuario();
		
		usuario.setEmail(getEmail());
		usuario.setSenha(Encripta.encripta(getSenha()));

		if(usuario instanceof Doadores){
			((Doadores) usuario).setNome(getNome());
			((Doadores) usuario).setCpf(getCpf());
			((Doadores) usuario).setDataNascimento(getDataNascimento());
			((Doadores) usuario).setEndDoador(getEndDoador());
			((Doadores) usuario).setTelDoador(getTelDoador());
		} else {
			((Instituicoes) usuario).setCnpj(getCnpj());
			((Instituicoes) usuario).setRazaoSocial(getRazaoSocial());
			((Instituicoes) usuario).setEnd(getEnd());
			((Instituicoes) usuario).setTelefone(getTel());
			((Instituicoes) usuario).setDesc(getDescricao());
			((Instituicoes) usuario).setNomeBanco(getNomeBanco());
			((Instituicoes) usuario).setOperacao(getOperacao());
			((Instituicoes) usuario).setAgencia(getAgencia());
			((Instituicoes) usuario).setConta(getConta());
		}
		
		try {
			this.usuarioBO.salvar(usuario);
			MessagesUtils.info("Usuário cadastrado com sucesso!");
		} catch (Exception e) {
			MessagesUtils.error(e.getMessage());
		}
		
		return Navigation.SUCESSO;
	}

	public String preparaSalvar() {
		this.limpaDados();
		return Navigation.CADASTRO;
	}
	
	public String voltar(){
		return Navigation.VOLTAR;
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

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndDoador() {
		return endDoador;
	}

	public void setEndDoador(String endDoador) {
		this.endDoador = endDoador;
	}

	public String getTelDoador() {
		return telDoador;
	}

	public void setTelDoador(String telDoador) {
		this.telDoador = telDoador;
	}

	
	
	

	
	
}
