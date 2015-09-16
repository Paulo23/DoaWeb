package br.unifor.pin.doaweb.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long idUsuario;
	
	@Column(name="nome_usuario", nullable = false, length = 255)
	private String nomeUsuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="nascimento_usuario", nullable = false)
	private Date dataNascimento;
	
	@Column(name="rg_usuario", nullable = false, updatable = false, unique = true, length = 255)
	private String rgUsuario;
	
	@Column(name="telefone_usuario", nullable = false, length = 11)
	private String telefoneUsuario;
	
	@Column(name="endereco_usuario", nullable = false, length = 255)
	private String enderecoUsuario;
	
	@Column(name="email_usuario", nullable = false, length = 255)
	private String emailUsuario;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Doacao> doacoes;

	public String getRgUsuario() {
		return rgUsuario;
	}

	public void setRgUsuario(String rgUsuario) {
		this.rgUsuario = rgUsuario;
	}

	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}

	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}

	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}

	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
