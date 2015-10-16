package br.unifor.pin.doaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("0")
public class Doadores extends Usuarios {
	
	@Column(nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)	
	@Column(name = "data_nascimento", nullable=false)
	private Date dataNascimento;

	@Column(name = "cpf", length = 14, nullable=false, unique = true )
	private String cpf;
	
	@Column(name = "telefone", nullable = false)
	private String telDoador;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelDoador() {
		return telDoador;
	}

	public void setTelDoador(String telDoador) {
		this.telDoador = telDoador;
	}

	
	
	
	
}
