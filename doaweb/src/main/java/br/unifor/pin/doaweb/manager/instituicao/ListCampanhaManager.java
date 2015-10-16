package br.unifor.pin.doaweb.manager.instituicao;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.CampanhaBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.to.SegurancaTO;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "listCampanha")
@Component(value = "listCampanha")
public class ListCampanhaManager {

	@Autowired
	private CampanhaBO campanhaBO;
	@Autowired
	private SegurancaTO segurancaTO;

	private List<Campanhas> ltCampanhas;
	private Date dataInicioFiltro;

	private Campanhas campanha;

	public String listarMinhasCampanhasPorFiltro() {
		ltCampanhas = campanhaBO.buscaCampanhasPorInstituicaoData((Instituicoes) segurancaTO.getUsuario(),
				dataInicioFiltro);
		return Navigation.LISTCAMPINST;
	}

	public String listarMinhasCampanhas() {
		ltCampanhas = campanhaBO.buscarCampPorInst(segurancaTO.getUsuario());
		return Navigation.LISTCAMPINST;
	}

	public void excluir(Campanhas campanha) {
		campanhaBO.excluirCampanha(campanha);
		ltCampanhas = campanhaBO.buscarCampPorInst(segurancaTO.getUsuario());
	}

	public List<Campanhas> getLtCampanhas() {
		return ltCampanhas;
	}

	public void setLtCampanhas(List<Campanhas> ltCampanhas) {
		this.ltCampanhas = ltCampanhas;
	}

	public Campanhas getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanhas campanha) {
		this.campanha = campanha;
	}

	public Date getDataInicioFiltro() {
		return dataInicioFiltro;
	}

	public void setDataInicioFiltro(Date dataInicioFiltro) {
		this.dataInicioFiltro = dataInicioFiltro;
	}

}
