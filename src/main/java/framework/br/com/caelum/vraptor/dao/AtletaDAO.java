package framework.br.com.caelum.vraptor.dao;


import java.util.Optional;

import framework.br.com.caelum.vraptor.model.Atleta;

public interface AtletaDAO extends EntidadeDAO<Atleta> {

    Atleta buscarPorLogin(String login);
}