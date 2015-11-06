package br.unifor.pin.doaweb.bussines;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.doaweb.aspectj.Loggable;
import br.unifor.pin.doaweb.aspectj.RolesAllowed;
import br.unifor.pin.doaweb.dao.CampanhasDAO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.entity.Usuarios;
import br.unifor.pin.doaweb.enums.StatusCampanha;
import br.unifor.pin.doaweb.enums.TipoUsuario;

@Component
public class CampanhaBO {

	@Autowired
	private CampanhasDAO campanhasDAO;

	@RolesAllowed(value=TipoUsuario.INSTITUICAO)
	public void salvar(Campanhas campanha) {
		campanhasDAO.salvar(campanha);
	}

	@RolesAllowed(value=TipoUsuario.INSTITUICAO)
	public void atualizarCampanha(Campanhas campanha) {
		campanhasDAO.atualizar(campanha);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluirCampanha(Campanhas campanha) {
		campanha = campanhasDAO.buscaCampanhaPorId(campanha.getId());
		campanhasDAO.excluir(campanha);
	}

	@Loggable(enable = false)
	public List<Campanhas> buscarCampPorInst(Usuarios instituicao) {
		return campanhasDAO.buscaCampanhasPorInstituicao(instituicao);
	}
	
	public List<Campanhas> buscaCampanhasPorInstituicaoData(Instituicoes instituicao, Date data){
		return campanhasDAO.buscaCampanhasPorInstituicaoData(instituicao, data);
	}
	
	@Loggable(enable = false)
	public List<Campanhas> buscarTodasCamp() {
		List<Campanhas> campanhas = campanhasDAO.buscaTodasCampanhas();
		return campanhas;
	}
	
	public void atualizar(){
		
	}
	
	public void buscarCampanhaPorId(Integer id){
		campanhasDAO.buscaCampanhaPorId(id);
	}
	
	public String getDateInicioCampanha() {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(data).toString();
	}
	
	public boolean  validaDataDeTerminoDeCampanha(Date date){
		Date date2 = new Date();
		System.out.println(date2);
		System.out.println(date);
		if (date2.before(date) && !(date2.equals(date))) {
			return true;
		}else {
			return false;
		}
	}
	
	public Date dataSistema(){
		return new Date();
	}

	public void setStatusCampanhas(){
		Date atual = new Date();
		for (int i = 0; i < campanhasDAO.buscaTodasCampanhas().size() ; i++) {
			if(campanhasDAO.buscaTodasCampanhas().get(i).getDataTerminoCampanhas().after(atual)){
				Campanhas camp = campanhasDAO.buscaTodasCampanhas().get(i);
				camp.setStatus(StatusCampanha.INATIVA);
				campanhasDAO.atualizar(camp);
			}
		}
	}

}
