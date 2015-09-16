package br.unifor.pin.doaweb.entity;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DadosBancarios
 *
 */
@Entity
public class DadosBancarios implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_dadosBancarios")
	private Integer idDadosBancarios;
	
	@Column(name="nome_banco__dadosBancarios", nullable = false, length = 255)
	private String nomeBanco;
	
	@Column(name="operacao_dadosBancarios", nullable = true, length = 10)
	private String operacao;
	
	@Column(name="agencia_dadosBancarios", nullable = false, length = 50)
	private String agencia;
	
	@Column(name="conta_dadosBancarios", nullable = false, length = 50)
	private String conta;	
	
	@OneToOne(mappedBy="instituicao")
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;

	private static final long serialVersionUID = 1L;

	public DadosBancarios() {
		super();
	}

	public Integer getIdDadosBancarios() {
		return this.idDadosBancarios;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getAgencia() {
		return this.agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return this.conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

}
