package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Entidade;

import java.util.Collection;

public interface EntidadeDAO<T extends Entidade> {

    T buscarPorId(Long id);
    T salvar(T entidade);
    void remover(T entidade);
    Collection<T> listar();
    Collection<T> todos();
}
