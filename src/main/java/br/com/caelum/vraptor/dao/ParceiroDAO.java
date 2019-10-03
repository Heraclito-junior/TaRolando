package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Parceiro;

import java.util.Optional;

public interface ParceiroDAO extends EntidadeDAO<Parceiro> {

    Optional<Parceiro> buscarPorLogin(String login);

}
