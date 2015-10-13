package br.unifor.pin.doaweb.manager.instituicao;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.CampanhaBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.enums.TipoDoacao;
import br.unifor.pin.doaweb.utils.MessagesUtils;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "cadCampanha")
@Component(value = "cadCampanha")
public class CadCampanhaManager {

	@Autowired
	public CampanhaBO campanhaBO;

	private Date dataInicioCampanhas;
	private Date dataTerminoCampanhas;
	private TipoDoacao tipo;
	private String descricao;
	private Instituicoes instituicao;

	public String salvar() {
		Campanhas campanha = new Campanhas();
		campanha.setDataInicioCampanhas(getDataInicioCampanhas());
		campanha.setDataTerminoCampanhas(getDataTerminoCampanhas());
		campanha.setDescricao(getDescricao());
		campanha.setInstituicao(campanhaBO.getInstituicaoCampanha());
		campanha.setTipo(getTipo());
		
		try {
			this.campanhaBO.salvar(campanha);
			MessagesUtils.info("Campanha cadastrada com sucesso!");
			preparaSalvar();
		} catch (Exception e) {
			MessagesUtils.error(e.getMessage());
		}

		return Navigation.VOLTAR;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		return Navigation.CADASTRO;
	}
	
	public void limpaDados() {
		this.dataInicioCampanhas = null;
		this.dataTerminoCampanhas = null;
		this.descricao = "";
	}
	
	//Metodo para pegar os labels do Enum TipoDeDoacao
	public TipoDoacao[] getTipoDoacaoValores() {
	    return TipoDoacao.values();
	  }

	public CampanhaBO getCampanhaBO() {
		return campanhaBO;
	}

	public void setCampanhaBO(CampanhaBO campanhaBO) {
		this.campanhaBO = campanhaBO;
	}

	public Date getDataInicioCampanhas() {
		return dataInicioCampanhas;
	}

	public void setDataInicioCampanhas(Date dataInicioCampanhas) {
		this.dataInicioCampanhas = dataInicioCampanhas;
	}

	public Date getDataTerminoCampanhas() {
		return dataTerminoCampanhas;
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
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}

}
