package br.com.caelum.vraptor.dao;


import br.com.caelum.vraptor.model.Atleta;

import java.util.Optional;

public interface AtletaDAO extends EntidadeDAO<Atleta> {

    Atleta buscarPorLogin(String login);
}
