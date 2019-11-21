package framework.br.com.caelum.vraptor.dao;

import java.util.Optional;

import framework.br.com.caelum.vraptor.model.Parceiro;

public interface ParceiroDAO extends EntidadeDAO<Parceiro> {

    Optional<Parceiro> buscarPorLogin(String login);

}
