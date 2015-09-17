package br.unifor.pin.doaweb.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * @author equipe.doaweb
 *
 */
@Entity 
public class Instituicao implements Serializable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_instituicao")
	private Long idInstituicao;
	
	@Column(name="cnpj_instituicao", nullable = false, length = 14, updatable = false, unique = true)
	private String cnpj;
	
	@Column(name="nome_instituicao", nullable = false, length = 255)
	private String nome;
	
	@Column(name="endereco_instituicao", nullable = false, length = 255)
	private String endereco;
	
	@Column(name="descricao_instituicao", nullable = false, length = 3500)
	private String descricao;
	
	@Column(name="telefone_instituicao", nullable = false, length = 11)
	private String telefone;
	
	@Column(name="email_instituicao", nullable = false, length = 255)
	private String email;
	
	@OneToMany(mappedBy = "instituicao", fetch=FetchType.LAZY)
	private List<Campanhas> camapanhas;
	
	@OneToOne
	@JoinColumn(name="id_dadosBancarios")
	private Instituicao instituicao;
	
	private static final long serialVersionUID = 1L;

	public Instituicao() {
		super();
	}

	public Long getIdInstituicao() {
		return this.idInstituicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
