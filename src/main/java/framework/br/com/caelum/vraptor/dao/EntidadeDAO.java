package framework.br.com.caelum.vraptor.dao;

import java.util.Collection;

import framework.br.com.caelum.vraptor.model.Entidade;

public interface EntidadeDAO<T extends Entidade> {

    T buscarPorId(Long id);
    T salvar(T entidade);
    void remover(T entidade);
    Collection<T> listar();
    Collection<T> todos();
}
