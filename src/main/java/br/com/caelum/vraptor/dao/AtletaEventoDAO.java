package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaEvento;

public interface AtletaEventoDAO extends EntidadeDAO<AtletaEvento> {

    AtletaEvento buscarPorLogin(String login);
}
