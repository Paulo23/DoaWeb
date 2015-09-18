package br.unifor.pin.doaweb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unifor.pin.doaweb.entity.security.Papeis;

/**
 * @author equipe.doaweb
 * 
 */
@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_usuario")
	private Integer id;

	@Column(name="nome_usuario", nullable=false)
	private String nomeUsuario;
	
	@Column(name="nascimento_usuario", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@Column(name="rg_usuario", nullable=false, unique=true)
	private String rgUsuario;
	
	@Column(name="email_usuario", unique=true, nullable=false)
	private String emailUsuario;
	
	@Column(name="endereco_usuario", nullable=false)
	private String endUsuario;
	
	@Column(name="telefone_usuario", nullable=false)
	private String telUsuario;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfis", 
		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id") , 
		inverseJoinColumns = @JoinColumn(name = "papel_id", referencedColumnName = "id") )
	private List<Papeis> papeis;

	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Doacao> doacoes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRgUsuario() {
		return rgUsuario;
	}

	public void setRgUsuario(String rgUsuario) {
		this.rgUsuario = rgUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getEndUsuario() {
		return endUsuario;
	}

	public void setEndUsuario(String endUsuario) {
		this.endUsuario = endUsuario;
	}

	public String getTelUsuario() {
		return telUsuario;
	}

	public void setTelUsuario(String telUsuario) {
		this.telUsuario = telUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the papeis
	 */
	public List<Papeis> getPapeis() {
		return papeis;
	}

	/**
	 * @param papeis
	 *            the papeis to set
	 */
	public void setPapeis(List<Papeis> papeis) {
		this.papeis = papeis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nomeUsuario + ", email=" + emailUsuario + ", papeis=" + papeis + "]";
	}
	
}