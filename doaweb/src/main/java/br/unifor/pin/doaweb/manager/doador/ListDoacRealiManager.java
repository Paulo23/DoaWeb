package br.unifor.pin.doaweb.manager.doador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.DoacaoBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.entity.Usuarios;
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
	
	private String nomeDoador;
	private String telefoneDoador;
	private String endDoador;
	private String obsDoDoaodr;
	
	
	private List<Doacao> ltDoacoes;

	public String listarMinhasDoacRealizadas() {
		ltDoacoes = doacaoBO.buscarDoacPorDoad(segurancaTO.getUsuario());
		return Navigation.LISTDOACDOAD;
	}
	
	public String preparaInforDoDoador(Doacao doacao){
		nomeDoador = doacao.getDoador().getNome();
		telefoneDoador = doacao.getDoador().getTelDoador();
		obsDoDoaodr = doacao.getInformacoes();
		endDoador = doacao.getDoador().getEndereco();
		
		return Navigation.SUCESSO;
	}

	public List<Doacao> getLtDoacoes() {
		return ltDoacoes;
	}

	public void setLtDoacoes(List<Doacao> ltDoacoes) {
		this.ltDoacoes = ltDoacoes;
	}

	public String getNomeDoador() {
		return nomeDoador;
	}

	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}

	public String getTelefoneDoador() {
		return telefoneDoador;
	}

	public void setTelefoneDoador(String telefoneDoador) {
		this.telefoneDoador = telefoneDoador;
	}

	public String getObsDoDoaodr() {
		return obsDoDoaodr;
	}

	public void setObsDoDoaodr(String obsDoDoaodr) {
		this.obsDoDoaodr = obsDoDoaodr;
	}

	public String getEndDoador() {
		return endDoador;
	}

	public void setEndDoador(String endDoador) {
		this.endDoador = endDoador;
	}

	
	
	
}
