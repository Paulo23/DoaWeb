package br.unifor.pin.doaweb.manager.campanhas;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.CampanhaBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "listCampanha")
@Component(value = "listCampanha")
public class ListCampanhaManager {

	@Autowired
	private CampanhaBO campanhaBO;

	private Date dateCriacao;

	private List<Campanhas> listarCampanhas;

	public Date getDataCriacao(){
		return getDateCriacao();
	}

	public void lista() throws ParseException {

		// listarCampanhas = (List<Campanhas>)
		// campanhaBO.buscaPorDate(getDataCriacao());
		System.out.println(getDataCriacao());
	}

	public String preparaListar() {
		this.limparDados();
		return Navigation.SUCESSO;
	}

	public void limparDados() {
		this.listarCampanhas = null;
	}

	public String salvar() {
		return null;
	}

	public Date getDateCriacao() {
		return dateCriacao;
	}

	public void setDateCriacao(Date dateCriacao) {
		this.dateCriacao = dateCriacao;
	}

	public List<Campanhas> getListarCampanhas() {
		return listarCampanhas;
	}

	public void setListarCampanhas(List<Campanhas> listarCampanhas) {
		this.listarCampanhas = listarCampanhas;
	}

}
