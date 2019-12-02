package ajudando.negocio.strategy;

import javax.inject.Inject;

import ajudando.dao.EventoAjudandoDAO;
import ajudando.dao.EventoAjudandoJpaDao;
import framework.br.com.caelum.vraptor.strategy.GeradorRelatorio;

public class GeradorRelatorioAjudando  implements GeradorRelatorio{
	
	@Inject
	private EventoAjudandoDAO dao;
	
	
	@Inject
	private EventoAjudandoJpaDao daoJpa;
	
	
	
	public String GerarRelatorio(Long i) {
		System.out.println("2");
		System.out.println(dao.buscarPorId((long) 1).getTitulo());
		
		String relatorio="";
		
		relatorio=relatorio+CalcularDoacoesEfetivadas();
		relatorio=relatorio+CalcularDoacoesNaoEfetivadas();
		relatorio=relatorio+ListaDeVoluntariosPresentes();
		relatorio=relatorio+ListaDeVoluntariosFaltosos();
		relatorio=relatorio+DiasComMaisInscricoes();
		
		return null;
	}
	
	private Double CalcularDoacoesEfetivadas() {
		return null;
	}
	
	private Double CalcularDoacoesNaoEfetivadas() {
		return null;	
	}
	
	private String ListaDeVoluntariosPresentes() {
		return null;
	}
	
	private String ListaDeVoluntariosFaltosos() {
		return null;
	}
	
	private String DiasComMaisInscricoes() {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
