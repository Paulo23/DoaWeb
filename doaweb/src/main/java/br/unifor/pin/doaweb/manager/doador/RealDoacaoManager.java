package br.unifor.pin.doaweb.manager.doador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.CampanhaBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "realizarDoac")
@Component(value = "realizarDoac")
public class RealDoacaoManager {

	@Autowired
	private CampanhaBO campanhaBO;
	
	private Campanhas campanhas;

	private List<Campanhas> ltTodasCampanhas;

	public String listarTodasCampanhas() {
		ltTodasCampanhas = campanhaBO.buscarTodasCamp();
		return Navigation.LISTCAMPDOAD;
	}

	public List<Campanhas> getLtTodasCampanhas() {
		return ltTodasCampanhas;
	}

	public void setLtTodasCampanhas(List<Campanhas> ltTodasCampanhas) {
		this.ltTodasCampanhas = ltTodasCampanhas;
	}

	public Campanhas getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(Campanhas campanhas) {
		this.campanhas = campanhas;
	}
	
	

}
