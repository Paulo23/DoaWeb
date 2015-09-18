package br.unifor.pin.doaweb.entity;

import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * @author equipe.doaweb
 *
 */
@Entity 
public class Instituicao{
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_instituicao")
	private Integer id;
	
	@Column(name="cnpj_instituicao", nullable = false, length = 14, updatable = false, unique = true)
	private String cnpjInstituicao;
	
	@Column(name="nome_instituicao", nullable = false)
	private String nomeInstituicao;
	
	@Column(name="endereco_instituicao", nullable = false)
	private String endInstituicao;
	
	@Column(name="descricao_instituicao", nullable = false)
	private String descricaoInstituicao;
	
	@Column(name="telefone_instituicao", nullable = false, length = 15)
	private String telInstituicao;
	
	@Column(name="email_instituicao", nullable = false)
	private String emailInstituicao;
	
	@OneToMany(mappedBy = "instituicao", fetch=FetchType.EAGER)
	private List<Campanhas> campanhas;
	
	@OneToOne
	@JoinColumn(name="id_dadosBancarios")
	private Instituicao instituicao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpjInstituicao() {
		return cnpjInstituicao;
	}

	public void setCnpjInstituicao(String cnpjInstituicao) {
		this.cnpjInstituicao = cnpjInstituicao;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getEndInstituicao() {
		return endInstituicao;
	}

	public void setEndInstituicao(String endInstituicao) {
		this.endInstituicao = endInstituicao;
	}

	public String getDescricaoInstituicao() {
		return descricaoInstituicao;
	}

	public void setDescricaoInstituicao(String descricaoInstituicao) {
		this.descricaoInstituicao = descricaoInstituicao;
	}

	public String getTelInstituicao() {
		return telInstituicao;
	}

	public void setTelInstituicao(String telInstituicao) {
		this.telInstituicao = telInstituicao;
	}

	public String getEmailInstituicao() {
		return emailInstituicao;
	}

	public void setEmailInstituicao(String emailInstituicao) {
		this.emailInstituicao = emailInstituicao;
	}
	
	
	

}
