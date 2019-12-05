package casamento.dao;

import framework.br.com.caelum.vraptor.dao.EntidadeDAO;
import framework.br.com.caelum.vraptor.model.AlertaTabela;
import framework.br.com.caelum.vraptor.model.EventoCasamento;

import java.util.List;

public interface EventoCasamentoDAO extends EntidadeDAO<EventoCasamento> {

    List<EventoCasamento> meusEventos();

	List<AlertaTabela> meusAlertas();
	
	
}
