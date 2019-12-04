package ajudando.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.dao.EntidadeDAO;
import framework.br.com.caelum.vraptor.model.Alerta;
import framework.br.com.caelum.vraptor.model.AlertaTabela;
import framework.br.com.caelum.vraptor.model.Evento;
import framework.br.com.caelum.vraptor.model.EventoCasamento;

public interface EventoAjudandoDAO extends EntidadeDAO<EventoCasamento> {

    List<EventoCasamento> meusEventos();

	List<AlertaTabela> meusAlertas();
	
	
}
