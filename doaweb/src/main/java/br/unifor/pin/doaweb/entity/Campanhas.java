package br.unifor.pin.doaweb.entity;

import java.io.Serializable;
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

/**
 * Entity implementation class for Entity: Campanhas
 *
 */
@Entity
public class Campanhas implements Serializable {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id_campanhas")
	private Long idCampanhas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio_campanhas", nullable = false, updatable = false)
	private Date dataInicioCampanhas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_termino_campanhas", nullable = false, updatable = false)
	private Date dataTerminoCampanhas;
	
	@Column(name="tipo_campanhas", nullable = false, updatable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoDoacao tipo;
	
	@Column(name="descricao_campanhas", nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;
	
	private static final long serialVersionUID = 1L;

	public Campanhas() {
		super();
	}

	public Long getIdCampanhas() {
		return this.idCampanhas;
	}

	public Date getDataInicioCampanhas() {
		return this.dataInicioCampanhas;
	}

	public void setDataInicioCampanhas(Date dataInicioCampanhas) {
		this.dataInicioCampanhas = dataInicioCampanhas;
	}

	public Date getDataTerminoCampanhas() {
		return this.dataTerminoCampanhas;
	}

	public void setDataTerminoCampanhas(Date dataTerminoCampanhas) {
		this.dataTerminoCampanhas = dataTerminoCampanhas;
	}

	public TipoDoacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDoacao tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
