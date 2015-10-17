package br.unifor.pin.saa.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.doaweb.dao.CampanhasDAO;
import br.unifor.pin.doaweb.dao.DoacaoDAO;
import br.unifor.pin.doaweb.dao.DoadoresDAO;
import br.unifor.pin.doaweb.dao.UsuariosDAO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.entity.Doacao;
import br.unifor.pin.doaweb.entity.Doadores;
import br.unifor.pin.doaweb.entity.Instituicoes;
import br.unifor.pin.doaweb.enums.TipoDoacao;
import br.unifor.pin.doaweb.exceptions.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class DoacoesTest {
	
	@Autowired
	private DoacaoDAO doacaoDAO;
	
	@Autowired
	private CampanhasDAO campanhasDAO;
	
	@Autowired
	private UsuariosDAO dao;
	
	public Date stringToDate() throws ParseException{
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");  
		Date date = (Date)formatter.parse("01/29/02"); 
		return date;
	}
	
	@Test
	public void testSalvar() throws ParseException, DAOException {
		Instituicoes instituicao = new Instituicoes();
		
		instituicao.setAgencia("123");
		instituicao.setNomeBanco("Banco Brasil");
		instituicao.setOperacao("3");
		instituicao.setConta("456");
		
		instituicao.setAtivo(true);
		
		instituicao.setEmail("admin5");
		instituicao.setSenha("123");
		instituicao.setCnpj("1234567");
		instituicao.setRazaoSocial("Lar Santa");
		instituicao.setDesc("testes");
		instituicao.setEndereco("fortaleza-ce");
		instituicao.setTelefone("9999000");
		
		dao.salvar(instituicao);
		
		Doadores doadores = new Doadores();
		
		doadores.setAtivo(true);
		doadores.setCpf("12233");
		doadores.setDataNascimento(stringToDate());
		doadores.setEmail("e@email.com");
		doadores.setEndereco("Rua");
		doadores.setNome("Lucas");
		doadores.setSenha("123");
		doadores.setTelDoador("99999");
		
		dao.salvar(doadores);
		
		
		Campanhas campanha = new Campanhas();
		campanha.setDescricao("teste de testes");
		campanha.setTipo(TipoDoacao.DINHEIRO);
		campanha.setDataInicioCampanhas(stringToDate());
		campanha.setDataTerminoCampanhas(stringToDate());
		campanha.setInstituicao(instituicao);
		
		campanhasDAO.salvar(campanha);
		
		Doacao doacao = new Doacao();
		
		doacao.setCampanha(campanha);
		doacao.setDataDoacao(stringToDate());
		doacao.setInformacoes("test");
		doacao.setTipoDeDoacao(TipoDoacao.DINHEIRO);
		doacao.setDoador(doadores);
		
		doacaoDAO.salvar(doacao);
	
		//campanhasDAO.buscaPorId(campanha.getId());
		
		}

}
