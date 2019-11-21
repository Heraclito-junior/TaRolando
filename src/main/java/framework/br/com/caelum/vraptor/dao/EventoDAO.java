package framework.br.com.caelum.vraptor.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.model.Alerta;
import framework.br.com.caelum.vraptor.model.AlertaTabela;
import framework.br.com.caelum.vraptor.model.Evento;

public interface EventoDAO extends EntidadeDAO<Evento> {

    List<Evento> meusEventos();

	List<AlertaTabela> meusAlertas();
}
