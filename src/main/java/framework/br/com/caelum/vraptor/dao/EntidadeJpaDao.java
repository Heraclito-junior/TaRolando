package framework.br.com.caelum.vraptor.dao;

import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Entidade;

import java.util.Collection;

public abstract class EntidadeJpaDao<T extends Entidade> implements EntidadeDAO<T> {

    protected EntityManager manager;
    protected Class<T> tClass;

    public EntidadeJpaDao(EntityManager entityManager, Class<T> tClass) {
        this.manager = entityManager;
        this.tClass = tClass;
    }

    @Override
    public T buscarPorId(Long id) { return manager.find(tClass, id); }

    @Override
    public T salvar(T entidade) {
        if(entidade.getId() != null) {
            this.manager.merge(entidade);
        } else {
            this.manager.persist(entidade);
        }
        return entidade;
    }

    @Override
    public void remover(T entidade) { manager.remove(entidade); }

    @Override
    public Collection<T> listar() {
        return manager.createQuery("SELECT t FROM "+tClass.getSimpleName()+" t WHERE t.deletado = false").getResultList();
    }

    @Override
    public Collection<T> todos() {
        return manager.createQuery("SELECT t FROM "+tClass.getSimpleName()+" t").getResultList();
    }
}
