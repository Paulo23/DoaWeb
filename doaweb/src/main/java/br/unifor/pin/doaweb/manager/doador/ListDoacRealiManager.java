package br.unifor.pin.doaweb.manager.doador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.DoacaoBO;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.to.SegurancaTO;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "listDoacReal")
@Component(value = "listDoacReal")
public class ListDoacRealiManager {

	@Autowired
	private DoacaoBO doacaoBO;
	@Autowired
	private SegurancaTO segurancaTO;

	private List<Doacao> ltDoacoes;

	public String listarMinhasDoacRealizadas() {
		ltDoacoes = doacaoBO.buscarDoacPorDoad(segurancaTO.getUsuario());
		return Navigation.LISTDOACDOAD;
	}

	public List<Doacao> getLtDoacoes() {
		return ltDoacoes;
	}

	public void setLtDoacoes(List<Doacao> ltDoacoes) {
		this.ltDoacoes = ltDoacoes;
	}

}
