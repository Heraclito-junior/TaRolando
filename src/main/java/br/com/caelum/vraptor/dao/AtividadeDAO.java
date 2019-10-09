package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Atividade;

import java.util.List;

public interface AtividadeDAO extends EntidadeDAO<Atividade> {

    List<Atividade> minhasAtividades(Long id);
}
