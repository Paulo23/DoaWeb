package br.unifor.pin.doaweb.entity;

import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * @author equipe.doaweb
 *
 */
@Entity
public class DadosBancarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_dadosBancarios")
	private Integer id;

	@Column(name = "nomeBanco_dadosBancarios", nullable = false)
	private String nomeBanco;

	@Column(name = "operacao_dadosBancarios", nullable = true, length = 10)
	private String operacao;

	@Column(name = "agencia_dadosBancarios", nullable = false, length = 50)
	private String agencia;

	@Column(name = "conta_dadosBancarios", nullable = false, length = 50)
	private String conta;

	@OneToOne(mappedBy = "instituicao")
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

}
