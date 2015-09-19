package br.unifor.pin.doaweb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author equipe.doaweb
 *
 */
@Entity 
@DiscriminatorValue("1")
public class Instituicao extends Usuarios {
	
	@Column(name="cnpj_instituicao", nullable = false, length = 14, updatable = false, unique = true)
	private String cnpj;
	
	@Column(name="razao_social", nullable = false)
	private String razaoSocial;
	
	@OneToMany(mappedBy = "instituicao", fetch=FetchType.EAGER)
	private List<Campanhas> campanhas;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public List<Campanhas> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<Campanhas> campanhas) {
		this.campanhas = campanhas;
	}

}
