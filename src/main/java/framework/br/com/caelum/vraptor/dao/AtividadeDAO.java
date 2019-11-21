package framework.br.com.caelum.vraptor.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.model.Atividade;

public interface AtividadeDAO extends EntidadeDAO<Atividade> {

    List<Atividade> minhasAtividades(Long id);
}
