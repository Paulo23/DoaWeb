package br.unifor.pin.doaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.unifor.pin.doaweb.enums.TipoDoacao;

@Entity
public class Doacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_doacao")
	private Integer id;

	@Column(name = "tipo_doacao", nullable = false, updatable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoDoacao tipoDeDoacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_doacao", nullable = false, updatable = false)
	private Date dataDoacao;

	@ManyToOne
	@JoinColumn(name = "id_campanhas")
	private Campanhas campanha;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuarios usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDoacao getTipoDeDoacao() {
		return tipoDeDoacao;
	}

	public void setTipoDeDoacao(TipoDoacao tipoDeDoacao) {
		this.tipoDeDoacao = tipoDeDoacao;
	}

	public Date getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(Date dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public Campanhas getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanhas campanha) {
		this.campanha = campanha;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}
