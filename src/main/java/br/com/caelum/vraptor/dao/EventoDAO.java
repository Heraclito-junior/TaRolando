package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Alerta;
import br.com.caelum.vraptor.model.AlertaTabela;
import br.com.caelum.vraptor.model.Evento;

import java.util.List;

public interface EventoDAO extends EntidadeDAO<Evento> {

    List<Evento> meusEventos();

	List<AlertaTabela> meusAlertas();
}
